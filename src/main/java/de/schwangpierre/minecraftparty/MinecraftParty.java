package de.schwangpierre.minecraftparty;

import de.schwangpierre.minecraftparty.api.GameRegistry;
import de.schwangpierre.minecraftparty.game.SimpleGameRegistry;
import de.schwangpierre.minecraftparty.game.games.spleef.SpleefGame;
import de.schwangpierre.minecraftparty.listener.PlayerJoinListener;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class MinecraftParty extends JavaPlugin {

    @Getter
    private static MinecraftParty instance;

    @Getter
    @Setter
    private static GameState gameState;

    private GameRegistry gameRegistry;

    //TODO: Language System, Scoreboard Handler, Database Integration (MongoDB, MySQL, SQLite) + Stats, API Integrations(?)

    @Override
    public void onEnable() {
        instance = this;
        setGameState(GameState.LOBBY);
        setGameRegistry(new SimpleGameRegistry());
        getGameRegistry().registerGame(new SpleefGame());
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {

    }

    /**
     * Sets a custom {@link GameRegistry}.
     *
     * @param gameRegistry The new / custom {@link GameRegistry}
     */

    public void setGameRegistry(GameRegistry gameRegistry) {
        this.gameRegistry = gameRegistry;
    }

}
