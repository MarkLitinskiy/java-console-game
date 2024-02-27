package character;

import character.type.CharacterType;

import java.util.Objects;

public class Goal extends Character{
    public Goal(int x, int y, CharacterType type) {
        super(x, y, type);
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
