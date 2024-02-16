package source;

/**
 * Story script compiler
 */
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Game {
    private GameMap gameMap;
    private Position playerPosition;

    public Game() {
        this.gameMap = new GameMap();
        this.playerPosition = null;
    }

    public void initializeGame() {
        // Read the combined game script and initialize rooms
        readGameScript("test\\Test.story");

        Room startingRoom = gameMap.getRooms().get("start");
        playerPosition = new Position(startingRoom);
    }

    private void readGameScript(String scriptFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(scriptFileName))) {
            String line;
            Room currentRoom = null;

            while ((line = reader.readLine()) != null) {
                // Ignore comments starting with "#"
                if (!line.trim().startsWith("#")) {
                    if (line.startsWith("room")) {
                        currentRoom = parseRoom(line, reader);
                        gameMap.getRooms().put(currentRoom.getName(), currentRoom);
                    } else if (line.startsWith("options")) {
                        // Skip the options section
                    } else if (line.contains("->")) {
                        // Map section - pass to GameMap to build connections
                        gameMap.buildMap(currentRoom, line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Room parseRoom(String roomLine, BufferedReader reader) {
        // Extract the room name
        String[] parts = roomLine.split("\\s+");
        String roomName = parts[1].trim();

        // Initialize the room with an empty description
        Room room = new Room(roomName, "");

        String line;
        try {
            // Read the lines inside the room definition
            while (!(line = reader.readLine()).trim().equals("options")) {
                // Ignore comments starting with "#"
                if (!line.trim().startsWith("#")) {
                    // Check if the line contains "description" and extract the description
                    if (line.contains("description")) {
                        String[] descriptionParts = line.split("\"");
                        if (descriptionParts.length >= 2) {
                            String description = descriptionParts[1].trim();
                            room.setDescription(description);
                        }
                    }
                }
            }
    
            // Read the options
            while ((line = reader.readLine()) != null && !line.trim().isEmpty()) {
                // Ignore comments starting with "#"
                if (!line.trim().startsWith("#")) {
                    room.addOption(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return room;
    }

    public void start() {

    }

    // display the map
    public void displayGameMap() {
        Room currentRoom = (playerPosition != null) ? playerPosition.getCurrentRoom() : null;

        if (currentRoom != null) {
            gameMap.displayMap(currentRoom);
        } else {
            System.out.println("Error: Player position or current room is null.");
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame();
        game.displayGameMap();
    }
}
