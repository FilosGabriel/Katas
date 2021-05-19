package com.filos.refactorized;

import java.util.Random;

import com.filos.refactorized.players.Players;
import lombok.Getter;

public class StatusGame {
    @Getter
    private int roll;
    private final Players players;
    private final int[] places;
    private final int[] purses;
    private final boolean[] inPenaltyBox;
    private final Random rand = new Random();

    public StatusGame(Players players) {
        this.places = new int[players.getPlayersNames().size()];
        this.purses = new int[players.getPlayersNames().size()];
        this.inPenaltyBox = new boolean[players.getPlayersNames().size()];
        this.players = players;
    }

    public Integer getPlaceForCurrentPlayer() {
        return places[players.getCurrentPlayer()];
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox[players.getCurrentPlayer()];
    }

    public void nextRoll() {
        roll = rand.nextInt(5) + 1;
    }

    public void setInPenaltyBox(boolean value) {
        inPenaltyBox[players.getCurrentPlayer()] = value;
    }

    public void increasePurses() {
        purses[players.getCurrentPlayer()]++;
    }

    public int getCurrentPurses() {
        return purses[players.getCurrentPlayer()];
    }

    public void addRoll() {
        places[players.getCurrentPlayer()] = (places[players.getCurrentPlayer()] + roll) % 12;
    }

    public boolean isWinning() {
        return (purses[players.getCurrentPlayer()] == 6);
    }

    public boolean canGetOutOfPenaltyBox() {
        return getRoll() % 2 == 0;
    }
}
