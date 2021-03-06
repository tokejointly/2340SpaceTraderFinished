package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

/**
 * Provides the operations associated with the User entity
 * Relates the Model and the UI
 *
 */
public class PlayerInteractor extends Interactor implements Serializable {

    /**
     * constructor for the player interactor
     * @param repo the repository to set the player interactor after
     */
    public PlayerInteractor(Repository repo) {super(repo);}

    /**
     * gets a list of all players in repo
     * @return list of all players in repo
     */
    public List<Player> getAllPlayers() {return getRepository().getAllPlayers();}

    /**
     * adds a player to the repo
     * @param p the player to add
     */
    public void addPlayer (Player p) {getRepository().addPlayer(p);}

    /**
     * updates a player in the repo
     * @param p player in the repo
     */
    public void updatePlayer (Player p) {getRepository().updatePlayer(p);}

    private static final Repository theRepository = new Repository();

    public static final String DEFAULT_JSON_FILE_NAME = "data.json";
    public static final String DEFAULT_TEXT_FILE_NAME = "data.txt";
    public static final String DEFAULT_BINARY_FILE_NAME = "data.bin";

    private static final PlayerInteractor instance = new PlayerInteractor(theRepository);

    /**
     * gets the current instance of the player interactor
     * @return current instance of the player interactor
     */
    public static PlayerInteractor getInstance() { return instance; }

    /**
     * loads from a file on android device. doesn't work
     */
    public void loadBinary() {
        ModelSingleton.getInstance().loadBinary();
    }

    /**
     * saves the player to an outside file on the phone
     * @return success
     */
    public boolean saveBinary() {
        return ModelSingleton.getInstance().saveBinary();
    }


}
