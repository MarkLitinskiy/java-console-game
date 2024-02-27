# Team 00 – Java bootcamp
### Console Game & Maven

### Exercise 00 – Surrender, You're Surrounded

| Exercise 00: Surrender, You're Surrounded | |
| ------ | ------ |
| Turn-in directory | ex00 |
| Files to turn-in | Game-folder, ChaseLogic-folder |

**Designations**: <br>
`o` - position of a player (program user) on the map.<br>
`#` - obstacle<br>
`x` - enemy (artificial intelligence)<br>
`O` - target point the player must get to before the enemies reach the player. The player is considered to have reached the target cell if they stepped on its position.

**Game rules**:
1. Each participant (player and enemies) may make one move. Then, it's another participant's turn. The enemy is considered to have reached the player if it can step on the player's position by making the current move.
2. Available movement directions are left, right, downward, and upward.
3. If an enemy is unable to move forward (there are obstacles or other enemies around them, or a map edge has been reached), the enemy skips a move.
4. The target point is an obstacle for an enemy.
5. If the player is unable to move forward (surrounded by obstacles, enemies, or has reached an edge of the map), the player loses the game.
6. The player loses if an enemy finds them before they reach the target point.
7. The player starts the game first.

**Implementation requirements**:
1. Field size, number of obstacles, and number of enemies are entered into the program using command-line parameters (their availability is guaranteed):<br>
`$ java -jar game.jar --enemiesCount=10 --wallsCount=10 --size=30 --profile=production`
2. A check shall be made whether it is possible to put the specified number of enemies and obstacles on the map of given size. If input data is incorrect, the program shall throw an unchecked IllegalParametersException and shut down.
3. Enemies, obstacles, the player, and the target point are positioned on the field randomly. 
4. When generating the map, enemies, the player, obstacles, and the target point shall not overlap.
5. In the beginning of the game, the map must be generated so that the player can reach the target point (the player must not be blocked by walls and map edge in starting position).
6. To make a move, the player shall enter a number in the console that corresponds to the movement direction A, W, D, S (left, upward, right, downward).
7. If the player is unable to make a move in the specified direction, another number (direction) shall be entered.
8. If the player understands in the beginning or middle of the game that the target point is unreachable, they shall end the game by entering 9 (player loses).
9. Once the player has made a move, it is its enemy's turn to make a move towards the player. 
10. In the development mode, each enemy's step shall be confirmed by the player by entering 8.
11. Upon each a step of any participant, map must be redrawn in the console. In development mode, the map shall be displayed without updating the screen.
12. Pursuing algorithm shall take account of the target object location in each step.

**Architecture requirements**:
1. Two projects shall be implemented: Game (contains game logic, application entry point, output functionality, etc.) and ChaseLogic (contains pursuing algorithm implementation).
2. Both are mavenprojects, and ChaseLogic shall be added as a dependency to pom.xml inside Game.
3. Game.jar archive shall be portable:  JCommander and JCDP must be directly included in the archive. At the same time, all libraries connected to the project shall be declared as maven-dependency. To build such archive, the following plugins shall be used.

It is also necessary to create a configuration file called application-production.properties. In this file, you will specify your application settings. The example of this file is shown below:

enemy.char = X <br>
player.char = o <br>
wall.char = \# <br>
goal.char = O <br>
empty.char= <br>
enemy.color = RED <br>
player.color = GREEN <br>
wall.color = MAGENTA <br>
goal.color = BLUE <br>
empty.color = YELLOW

This configuration file will be located in resources folder of the launched jar archive.

In addition to that, application-dev.properties file should be implemented. Structure of this file is similar to that of application.properties. Here, you can specify parameters for distinguishing application startup in development mode (for example, different colors/characters for map components).

It is necessary to keep in mind that the program may also be started in other modes. For this purpose, the respective properties file can be added to the source project, and the mode itself is passed via --profile parameter.
