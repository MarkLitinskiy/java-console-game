package character;

import character.type.CharacterType;

import java.util.Objects;
import java.util.Set;

public class Player extends Character {

    public Player(int x, int y, CharacterType type) {
        super(x, y, type);
    }

    public void moveCharacter(String move, int fieldSize, Set<Character> wallsSet) {

        int originalX = this.getPosition().getX();
        int originalY = this.getPosition().getY();

        switch (move) {
            case "w" -> this.setPositionY(originalY - 1);
            case "s" -> this.setPositionY(originalY + 1);
            case "a" -> this.setPositionX(originalX - 1);
            case "d" -> this.setPositionX(originalX + 1);
        }

        for (Character tmpWall : wallsSet) {
            if (tmpWall.getPosition().equals(this.getPosition())) {
                this.setPositionX(originalX);
                this.setPositionY(originalY);
                break;
            }
        }

        if (this.getPosition().getX() < 0 || this.getPosition().getX() >= fieldSize
                || this.getPosition().getY() < 0 || this.getPosition().getY() >= fieldSize) {
            this.setPositionX(originalX);
            this.setPositionY(originalY);
        }
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
        return Objects.equals(this.getPosition(), character.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getPosition());
    }
}
