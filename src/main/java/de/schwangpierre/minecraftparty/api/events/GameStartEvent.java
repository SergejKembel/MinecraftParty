package de.schwangpierre.minecraftparty.api.events;

import de.schwangpierre.minecraftparty.api.Game;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class GameStartEvent extends Event {

    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    private final Game game;

    public GameStartEvent(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
