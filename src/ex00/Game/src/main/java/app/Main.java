package app;

import game.manager.GameManager;
import args.exception.IllegalParametersException;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;
import args.Args;


public class Main {
    private static final String ERROR_MESSAGE = "Error: invalid parameters passed to the method";

    public static void main(String[] args) {
        try {
            Args jArgs = new Args();
            JCommander jCommander = new JCommander(jArgs);
            jCommander.parse(args);
            GameManager gameManager = new GameManager(jArgs.getSize(), jArgs.getEnemiesCount(), jArgs.getWallsCount(), jArgs.getProfile());
            gameManager.start();

        } catch (ParameterException e) {
            throw new IllegalParametersException(ERROR_MESSAGE);
        }
    }

}
