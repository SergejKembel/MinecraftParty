package de.schwangpierre.minecraftparty.api;

import de.schwangpierre.minecraftparty.MinecraftParty;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for creating games. Every mini-game MUST extend this class.
 */

@Getter
public abstract class Game {

    private final String name, description;
    private List<Listener> listeners;

    public Game(String name, String description) {
        this.name = name;
        this.description = description;
        listeners = new ArrayList<>();
    }

    /**
     * This method is called when starting a mini-game. It should be used to register mini-game dependent listeners and prepare the game.
     */

    public abstract void start();

    /**
     * This method is called when stopping a mini-game. It should be used to remove the registered listeners and end the game.
     */

    public abstract void stop();

    /**
     * Used to add a listener to the list of listeners.
     *
     * @param listener The {@link Listener} object (Class which extends {@link Listener})
     */

    public void addListener(Listener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    /**
     * Used to remove a listener from the list of listeners.
     *
     * @param listener The {@link Listener} object (Class which extends {@link Listener})
     */

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    /**
     * Register all listeners from the list of added listeners.
     */

    public void registerListeners() {
        listeners.forEach(listener -> Bukkit.getServer().getPluginManager().registerEvents(listener, MinecraftParty.getInstance()));
    }

    /**
     * Unregister all listeners from the list of registered listeners.
     */

    public void unregisterListeners() {
        listeners.forEach(HandlerList::unregisterAll);
    }

}
