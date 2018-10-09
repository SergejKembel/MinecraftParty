package de.schwangpierre.minecraftparty;

import de.schwangpierre.minecraftparty.api.GameRegistry;
import de.schwangpierre.minecraftparty.game.SimpleGameRegistry;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class MinecraftParty extends JavaPlugin {
    @Getter
    private static MinecraftParty instance;

    private final GameRegistry gameRegistry = new SimpleGameRegistry();

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {

    }
}
