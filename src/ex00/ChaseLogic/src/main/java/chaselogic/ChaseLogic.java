package chaselogic;

import character.Goal;
import character.Player;
import character.Point;
import character.Character;

import java.util.HashSet;
import java.util.Set;

import static character.type.CharacterType.ENEMY;

public class ChaseLogic {
    private final int fieldSize;
    private final boolean[] orderOfEnemyMovement; // координата местоположения игрока
    public ChaseLogic(int enemiesCount, int fieldSize) {
        this.fieldSize = fieldSize;
        orderOfEnemyMovement = new boolean[enemiesCount];
    }

    public boolean hasCollisions(Character newPosition, Set<Character> oldEnemiesSet, Set<Character> newEnemiesSet, Set<Character> wallsSet, Goal goal) {
        if (oldEnemiesSet.contains(newPosition) || newEnemiesSet.contains(newPosition) || wallsSet.contains(newPosition) || newPosition.getPosition().equals(goal.getPosition())) {
            return true;
        }

        if (newPosition.getPosition().getX() < 0 || newPosition.getPosition().getX() >= fieldSize) {
            return true;
        }

        if (newPosition.getPosition().getY() < 0 || newPosition.getPosition().getY() >= fieldSize) {
            return true;
        }

        return false;
    }

    public void changeEnemyPosition(Set<Character> enemiesSet, Set<Character> wallsSet, Player player, Goal goal) {
        int countCurrentEnemy = 0;
        Set<Character> newEnemyPositions = new HashSet<>();

        for (Character currentEnemy : enemiesSet) {
            Character newEnemyPosition = currentEnemy;

            int maxAttempts = 2;
            int attempts = 0;

            while (attempts < maxAttempts) {
                Character tempPosition = calculateEnemyTrajectory(countCurrentEnemy, currentEnemy, player);

                if (!hasCollisions(tempPosition, enemiesSet, newEnemyPositions, wallsSet, goal)) {
                    newEnemyPosition = tempPosition;
                    break;
                }
                attempts++;
            }
            newEnemyPositions.add(newEnemyPosition);
            countCurrentEnemy++;
        }
        enemiesSet.clear();
        enemiesSet.addAll(newEnemyPositions);
    }


    private Character calculateEnemyTrajectory(int countCurrentEnemy, Character enemyPosition, Player player) {
        Character newEnemyPosition = new Character(enemyPosition.getPosition().getX(), enemyPosition.getPosition().getY(), ENEMY);

        Point enemyPos = newEnemyPosition.getPosition();
        int playerX = player.getPosition().getX();
        int playerY = player.getPosition().getY();

        if (orderOfEnemyMovement[countCurrentEnemy]) {
            newEnemyPosition.setPositionX(playerX >= enemyPos.getX() ? enemyPos.getX() + 1 : enemyPos.getX() - 1);
        } else {
            newEnemyPosition.setPositionY(playerY >= enemyPos.getY() ? enemyPos.getY() + 1 : enemyPos.getY() - 1);
        }
        orderOfEnemyMovement[countCurrentEnemy] = !orderOfEnemyMovement[countCurrentEnemy];

        return newEnemyPosition;
    }
}
