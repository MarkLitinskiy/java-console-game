package game.manager;

import character.Character;
import character.factory.CharacterFactory;
import draw.DrawMap;

import java.util.Scanner;

import static character.type.CharacterType.ENEMY;
import static properties.Properties.loadProperties;

public class GameManager {
    private final CharacterFactory characterFactory;
    private final Scanner scanner = new Scanner(System.in);
    private final String profile;

    public GameManager(int fieldSize, int enemiesCount, int wallsCount, String profile) {
        characterFactory = new CharacterFactory(fieldSize, enemiesCount, wallsCount);
        this.profile = profile;
    }
    public void start() {
        System.out.print("\033[H\033[J");
        loadProperties(profile);
        draw();
        if (profile.equals("development")) {
            developmentVersionGame();
        } else if(profile.equals("production")) {
            productionVersionGame();
        }
    }

    private void gameLoop(boolean isDevelopmentVersion) {
        String scanStr;
        while (true) {
            System.out.println("\u001B[32mYOUR MOVE! -> \u001B[0m");
            scanStr = scanner.next();
            switch (scanStr) {
                case ("W"), ("w"), ("A"), ("a"), ("S"), ("s"), ("D"), ("d") -> {
                    characterFactory.getPlayer().moveCharacter(scanStr, characterFactory.getFieldSize(), characterFactory.getWallsSet());
                    if (isDevelopmentVersion) {
                        System.out.println("\u001B[31mIT'S THE OPPONENT'S TURN, CONFIRM IT BY ENTERING THE NUMBER 8\u001B[0m");
                        scanStr = scanner.next();
                        if (scanStr.equals("8")) {
                            changePosition();
                        }
                    } else {
                        changePosition();
                    }
                    clearAndDraw();
                }
                case ("9") -> printGameOver();
            }
            checkFail();
            checkWin();
        }
    }

    private void developmentVersionGame() {
        gameLoop(true);
    }

    private void productionVersionGame() {
        gameLoop(false);
    }

    private void clearAndDraw() {
        System.out.print("\033[H\033[J");
        draw();
    }
    private void printGameOver() {
        System.out.println("\u001B[1m\u001B[31mGAME OVER\u001B[0m");
        System.exit(0);
    }

    private void printWin(){
        System.out.println("\u001B[1m\u001B[35mCONGRATULATIONS! YOU WIN!\u001B[0m");
        System.exit(0);
    }

    public void draw() {
        DrawMap.displayField(characterFactory.getFieldSize(), characterFactory.getEnemiesSet(), characterFactory.getWallsSet(),characterFactory.getPlayer(), characterFactory.getGoal());
    }

    public void checkWin() {
        if (characterFactory.getPlayer().getPosition().equals(characterFactory.getGoal().getPosition())){
            printWin();
        }
    }

    public void checkFail() {
        if (characterFactory.getEnemiesSet().contains(new Character(characterFactory.getPlayer().getPosition(), ENEMY))){
            printGameOver();
        }
    }
    public void changePosition() {
        characterFactory.changeEnemyPosition();
    }
}
