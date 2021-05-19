package com.filos.refactorized;

import com.filos.refactorized.players.Players;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LoggerGame {

    private final Players players;
    private final Questions questions;
    private final StatusGame statusGame;

    public void printCurrentPlayer() {
        System.out.println(players.getCurrentPlayer() + " is the current player");
    }

    public void printCurrentRoll() {
        System.out.println("They have rolled a " + statusGame.getRoll());
    }

    public void printCurrentPlayerIsOutPenalty() {
        System.out.println(players.getCurrentPlayer() + " is getting out of the penalty box");
    }

    public void printCurrentCategory() {
        System.out.println("The category is " + questions.getCurrentCategory());
    }

    public void printNextLocationForPlayer() {
        System.out.println(players.getCurrentPlayer()
                                   + "'s new location is "
                                   + statusGame.getPlaceForCurrentPlayer());
    }

    public void printNotOut() {
        System.out.println(players.getCurrentPlayer() + " is not getting out of the penalty box");
    }

    public void printCorrectAnswer() {
        System.out.println("Answer was correct!!!!");
    }

    public void printWrongAnswer(){
        System.out.println("Question was incorrectly answered");
        System.out.println(players.getCurrentPlayer() + " was sent to the penalty box");
    }
    public void printPlayerHasGold() {
        System.out.println(players.getCurrentPlayerName()
                                   + " now has "
                                   + statusGame.getCurrentPurses()
                                   + " Gold Coins.");

    }
}
