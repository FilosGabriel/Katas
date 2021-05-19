package com.filos.refactorized.players;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class PlayersImpl implements Players {
    @Getter
    private int currentPlayer;
    private final List<String> playersNames;

    PlayersImpl(String player1, String player2) {
        playersNames = new ArrayList<>();
        addPlayer(player1);
        addPlayer(player2);
    }

    public void addPlayer(String playerName) {
        playersNames.add(playerName);
        System.out.println(playerName + " was added");
        System.out.println("He/She is player number: " + playersNames.size());
    }

    @Override
    public void setCurrentPlayerInPrison() {
    }

    @Override
    public void moveToNextPlayer() {
        currentPlayer = ++currentPlayer % playersNames.size();
    }

    @Override
    public List<String> getPlayersNames() {
        return new ArrayList<>(playersNames);
    }

    @Override
    public String getCurrentPlayerName() {
        return playersNames.get(getCurrentPlayer());
    }
}
