# How to Run the "Chase Game"
Before proceeding, ensure that you have Java and Maven installed on your system.

## 1. Build the Projects

Clone the repositories and navigate to the project directories:

    git clone <repository URL>
    cd ChaseLogic

Build the ChaseLogic project using Maven:

    mvn clean install

Navigate to the Game project directory:

    cd ../Game

Build the Game project using Maven:

    mvn clean install

## 2. Run the Game:

Run the game, specifying required parameters (field size, number of enemies, number of walls, etc.):

    java -jar target/Game-1.0-SNAPSHOT.jar --size=30 --enemiesCount=10 --wallsCount=10 --profile=production

Make sure to replace Game-1.0-SNAPSHOT.jar with the actual JAR file name generated during the build.

## 3. Play "Chase Game":
    Follow the on-screen instructions. Use the A, W, D, S keys to move the player. 

## 4. End the Game:

If you realize the goal is unreachable, end the game by entering 9.

Now you should have a working version of the "Chase Game"! Enjoy playing!

Note: The mvn clean install command installs dependencies, compiles the code, and packages the project.