package character;

import java.util.Objects;

public class Point {
    private int x;
    private int y    ;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point newPosition) {
        this.x = newPosition.x;
        this.y = newPosition.y;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
