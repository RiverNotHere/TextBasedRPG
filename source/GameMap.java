package source;

import java.io.*;
import java.util.*;

public class GameMap {
    private HashMap<String, Room> rooms;

    public GameMap() {
        this.rooms = new HashMap<>();
    }

    public void buildMap(Room currentRoom, String mapLine) {
        // Check if the line contains "->" before processing
        if (mapLine.contains("->")) {
            // Parse connections between rooms with directions
            String[] parts = mapLine.split("\\s*->\\s*");
            String fromRoomName = parts[0].trim();
            String[] connectionParts = parts[1].split("\\s+");

            if (connectionParts.length == 2) {
                String direction = connectionParts[0].trim();
                String toRoomName = connectionParts[1].trim();

                Room fromRoom = rooms.get(fromRoomName);
                Room toRoom = rooms.get(toRoomName);

                if (fromRoom != null && toRoom != null) {
                    fromRoom.addConnection(direction, toRoom);
                }
            }
        }

    }

    public void displayMap(Room currentRoom) {
        System.out.println("Game Map:");
    
        // Find the maximum description length for proper formatting
        int maxDescriptionLength = rooms.values().stream()
                .mapToInt(room -> room.getDescription().length())
                .max()
                .orElse(0);
    
        for (Room room : rooms.values()) {
            if (room.hasEntered() || room == currentRoom) {
                String border = "+" + "-".repeat(maxDescriptionLength + 4) + "+"; // Top border
    
                // Room name and description
                System.out.println(border);
                System.out.println("| Room: " + room.getName() + "\t\t|");
                System.out.println("| Description: " + room.getDescription() + " ".repeat(maxDescriptionLength - room.getDescription().length()) + " |");
    
                // Indicate the current position
                if (room == currentRoom) {
                    System.out.println("| *** Current Position! ***\t|");
                }
    
                HashMap<String, Room> connections = room.getConnections();
                if (!connections.isEmpty()) {
                    System.out.println("| Connections:");
    
                    // Display connections with arrows
                    for (HashMap.Entry<String, Room> entry : connections.entrySet()) {
                        String direction = entry.getKey();
                        Room connectedRoom = entry.getValue();
                        String arrow = getArrowForDirection(direction);
                        System.out.println("|   " + arrow + " " + connectedRoom.getName());
                    }
                }
    
                List<String> options = room.getOptions();
                if (!options.isEmpty()) {
                    System.out.println("| Options:");
    
                    // Display options
                    for (String option : options) {
                        System.out.println("|   " + option);
                    }
                }
    
                System.out.println(border); // Bottom border
                System.out.println();
            }
        }
    }
    
    private String getArrowForDirection(String direction) {
        switch (direction) {
            case "north":
                return "↑";
            case "south":
                return "↓";
            case "east":
                return "→";
            case "west":
                return "←";
            default:
                return "?";
        }
    }
    
    

    public HashMap<String, Room> getRooms() {
        return rooms;
    }
}
