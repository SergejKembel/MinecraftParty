package de.schwangpierre.minecraftparty.game.games.spleef;

import de.schwangpierre.minecraftparty.api.Game;
import de.schwangpierre.minecraftparty.game.games.spleef.listener.SpleefPlayerListener;

public class SpleefGame extends Game {

    public SpleefGame() {
        super("Spleef", "Boden wech hui");
    }

    @Override
    public void start() {
        addListener(new SpleefPlayerListener());
        registerListeners();
    }

    @Override
    public void stop() {
        unregisterListeners();
    }

}