package de.schwangpierre.minecraftparty.listener;

import de.schwangpierre.minecraftparty.GameState;
import de.schwangpierre.minecraftparty.MinecraftParty;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        // MinecraftParty.getInstance().getGameRegistry().nextGame();
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        if (MinecraftParty.getGameState() != GameState.LOBBY) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "Ingame / End");
            return;
        }
    }

}
