package de.schwangpierre.minecraftparty.api;

import de.schwangpierre.minecraftparty.MinecraftParty;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class Game {

    private final String name, description;
    private List<Listener> listeners;

    public Game(String name, String description) {
        this.name = name;
        this.description = description;
        listeners = new ArrayList<>();
    }

    public abstract void start();

    public abstract void stop();

    public void addListener(Listener listener) {
        if (!listeners.contains(listener))
            listeners.add(listener);
    }

    public void removeListener(Listener listener) {
        listeners.remove(listener);
    }

    public void registerListeners() {
        listeners.forEach(listener -> Bukkit.getServer().getPluginManager().registerEvents(listener, MinecraftParty.getInstance()));
    }

    public void unregisterListeners() {
        listeners.forEach(HandlerList::unregisterAll);
    }

}
