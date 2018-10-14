package de.schwangpierre.minecraftparty.game;

import de.schwangpierre.minecraftparty.Constants;
import de.schwangpierre.minecraftparty.api.Game;
import de.schwangpierre.minecraftparty.api.GameRegistry;
import de.schwangpierre.minecraftparty.api.events.GameStartEvent;
import de.schwangpierre.minecraftparty.utility.TitleAPI;
import org.bukkit.Bukkit;

import java.util.ArrayList;
import java.util.List;

public class SimpleGameRegistry implements GameRegistry {

    private int gameIndex = -1;
    private List<Game> games = new ArrayList<>();

    public void registerGame(Game game) {
        games.add(game);
    }

    public void unregisterGame(Game game) {
        games.remove(game);
    }

    public void startGame(Game game) {
        TitleAPI.sendTitle(Bukkit.getServer().getOnlinePlayers(), "§e" + game.getName(), "");
        Bukkit.getServer().broadcastMessage(Constants.PREFIX + "Next game is " + game.getName());
        Bukkit.getServer().broadcastMessage(Constants.PREFIX + game.getDescription());
        Bukkit.getServer().getPluginManager().callEvent(new GameStartEvent(game));
        game.start();
    }

    public void nextGame() {
        if(gameIndex > games.size()) {
            //TODO: stop round
        }
        gameIndex++;
        startGame(games.get(gameIndex));
    }

    public List<Game> getGames() {
        return games;
    }

}
