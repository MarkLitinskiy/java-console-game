package character.factory;


import character.Character;
import character.type.CharacterType;
import character.Goal;
import character.Player;
import chaselogic.ChaseLogic;

import java.util.*;

import static character.type.CharacterType.PLAYER;
import static character.type.CharacterType.TARGET;
import static character.type.CharacterType.*;

public class CharacterFactory {
    private final int fieldSize;
    private final Set<Character> enemies;
    private final Set<Character> walls;
    private final Player player;
    private final Goal goal;
    private final Random random;

    private final ChaseLogic chaseLogic;

    public CharacterFactory(int fieldSize, int enemiesCount, int wallsCount) {
        this.fieldSize = fieldSize;
        this.random = new Random();
        this.walls = new HashSet<>();
        this.enemies = new HashSet<>();

        addWallsToSet(wallsCount);
        addEnemiesToSet(enemiesCount);
        player = createPlayer(PLAYER);
        goal = createGoal(TARGET);
        this.chaseLogic = new ChaseLogic(enemiesCount, fieldSize);
    }

    public int getFieldSize() {
        return fieldSize;
    }
    private int getRandomCoordinate() {
        return random.nextInt(fieldSize);
    }

    private boolean isPositionOccupiedByWalls(int x, int y) {
        return walls.contains(new Character(x, y, WALL));
    }

    private boolean isPositionOccupiedByEnemies(int x, int y) {
        return enemies.contains(new Character(x, y, ENEMY));
    }

    public Character createCharacter(CharacterType type) {
        int x, y;
        do {
            x = getRandomCoordinate();
            y = getRandomCoordinate();
        } while (isPositionOccupiedByWalls(x, y) || isPositionOccupiedByEnemies(x, y));
        return new Character(x, y, type);
    }
    public Player createPlayer(CharacterType type) {
        int x, y;
        do {
            x = getRandomCoordinate();
            y = getRandomCoordinate();
        } while (isPositionOccupiedByWalls(x, y) || isPositionOccupiedByEnemies(x, y));
        return new Player(x, y, type);
    }

    public Goal createGoal(CharacterType type) {
        int x, y;
        do {
            x = getRandomCoordinate();
            y = getRandomCoordinate();
        } while (isPositionOccupiedByWalls(x, y) || isPositionOccupiedByEnemies(x, y));
        return new Goal(x, y, type);
    }

    public Set<Character> createSet(int count, CharacterType type) {
        Set<Character> points = new HashSet<>();
        for (int i = 0; i < count; i++) {
            points.add(createCharacter(type));
        }
        return points;
    }

    public Set<Character> createWallsSet(int count) {
        return createSet(count, WALL);
    }

    public Set<Character> createEnemiesSet(int count) {
        return createSet(count, ENEMY);
    }

    public void addWallsToSet(int count) {
        walls.addAll(createWallsSet(count));
    }

    public void addEnemiesToSet(int count) {
        enemies.addAll(createEnemiesSet(count));
    }

    public Set<Character> getWallsSet() {
        return walls;
    }

    public Set<Character> getEnemiesSet() {
        return enemies;
    }
    public void changeEnemyPosition() {
        chaseLogic.changeEnemyPosition(enemies, walls, player, goal);
    }

    public int getEnemiesCount() {
        return enemies.size();
    }
    public int getWallsCount() {
        return walls.size();
    }
    public Player getPlayer(){ return player; }
    public Goal getGoal(){ return goal; }
}
