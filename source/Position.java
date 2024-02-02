package source;

public class Position {
    class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return String.format("(%d, %d)", x, y);
        }
    }

    private Point currentPosition;

    public Position(int x, int y) {
        currentPosition = new Point(x, y);
    }

    public int getX() {
        return currentPosition.x;
    }

    public int getY() {
        return currentPosition.y;
    }

    public boolean near(Position targetPos) {
        
        return false;
    }
}
