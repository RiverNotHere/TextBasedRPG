package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private String name;
    private String description;
    private HashMap<String, Room> connections;
    private boolean entered;
    private List<String> options;

    public Room(String name, String description) {
        this.name = name;
        this.description = "";
        this.connections = new HashMap<>();
        this.options = new ArrayList<>();
        this.entered = true;
    }

    public boolean isCurrentRoom(Room currentRoom) {
        return this == currentRoom;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HashMap<String, Room> getConnections() {
        return connections;
    }

    public void addConnection(String direction, Room room) {
        connections.put(direction, room);
    }

    public Room getConnectedRoom(String direction) {
        return connections.get(direction);
    }

    public boolean hasEntered() {
        return entered;
    }

    public void setEntered(boolean entered) {
        this.entered = entered;
    }

    public List<String> getOptions() {
        return options;
    }

    // Add an option to the room
    public void addOption(String option) {
        options.add(option);
    }
}


