package source;

public class Position {
    private Room currentRoom;

    public Position(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room newRoom) {
        currentRoom = newRoom;
    }

    // Additional methods for movement and exploration
    public void moveNorth() {
        // Implement movement logic
    }

    public void moveSouth() {
        // Implement movement logic
    }

    public void moveEast() {
        // Implement movement logic
    }

    public void moveWest() {
        // Implement movement logic
    }

    public void explore() {
        // Implement exploration logic
    }
}

