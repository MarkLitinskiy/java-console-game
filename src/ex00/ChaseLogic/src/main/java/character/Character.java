package character;

import character.type.CharacterType;

import java.util.Objects;

public class Character {
    private Point position;
    private final CharacterType type;

    public Character(int x, int y, CharacterType type) {
        this.position = new Point(x, y);
        this.type = type;
    }

    public Character(Point position, CharacterType type) {
        this.position = position;
        this.type = type;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setPositionX(int x) {
        this.position.setX(x);
    }

    public void setPositionY(int y) {
        this.position.setY(y);
    }

    public CharacterType getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Character character = (Character) obj;
        return Objects.equals(position, character.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

}
