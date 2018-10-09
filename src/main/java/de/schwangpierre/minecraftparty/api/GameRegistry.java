package de.schwangpierre.minecraftparty.api;

import java.util.List;

/**
 * This class is used to manage the mini-games.
 * This means adding, removing and starting games. It offers the possibility to start the next game.
 */

public interface GameRegistry {

    /**
     * Adds a game to the {@link GameRegistry}
     *
     * @param game The {@link Game} object.
     */

    void registerGame(Game game);

    /**
     * Removes a game from the {@link GameRegistry}
     *
     * @param game The {@link Game} object.
     */

    void unregisterGame(Game game);

    /**
     * Starts a game.
     *
     * @param game The {@link Game} object.
     */

    void startGame(Game game);

    /**
     * Starts the next game (if exists)
     */

    void nextGame();

    /**
     * Returns all registered Games.
     *
     * @return {@link List<Game>} with all registered games.
     */

    List<Game> getGames();

}
