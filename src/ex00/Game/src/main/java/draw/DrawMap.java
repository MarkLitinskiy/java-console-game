package draw;

import character.Character;
import properties.Properties;
import character.*;
import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;


import java.util.Set;

import static character.type.CharacterType.ENEMY;
import static character.type.CharacterType.WALL;

public class DrawMap {
    static ColoredPrinter printer = new ColoredPrinter();

    public static void displayField(int fieldSize, Set<Character> enemiesSet, Set<Character> wallsSet, Player player, Goal goal) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                String cellSymbol = Properties.get("empty.char");
                String backColor = Properties.get("empty.color");

                if (wallsSet.contains(new Character(new Point(j, i), WALL))) {
                    cellSymbol = Properties.get("wall.char");
                    backColor = Properties.get("wall.color");
                } else if (enemiesSet.contains(new Character(new Point(j, i), ENEMY))) {
                    cellSymbol = Properties.get("enemy.char");
                    backColor = Properties.get("enemy.color");
                } else if (player.getPosition().getX() == j && player.getPosition().getY() == i) {
                    cellSymbol = Properties.get("player.char");
                    backColor = Properties.get("player.color");
                } else if (goal.getPosition().getX() == j && goal.getPosition().getY() == i){
                    cellSymbol = Properties.get("goal.char");
                    backColor = Properties.get("goal.color");
                }

                printer.print(cellSymbol, Ansi.Attribute.NONE, Ansi.FColor.BLACK, Ansi.BColor.valueOf(backColor));
            }
            System.out.println();
        }
    }
}
