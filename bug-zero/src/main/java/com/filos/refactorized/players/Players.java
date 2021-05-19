package com.filos.refactorized.players;

import java.util.List;

public interface Players {
    void setCurrentPlayerInPrison();

    void moveToNextPlayer();

    List<String> getPlayersNames();

    String getCurrentPlayerName();

    int getCurrentPlayer();
}
