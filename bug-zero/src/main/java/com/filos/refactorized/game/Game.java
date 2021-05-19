package com.filos.refactorized.game;

import com.filos.refactorized.LoggerGame;
import com.filos.refactorized.QuestionFactory;
import com.filos.refactorized.Questions;
import com.filos.refactorized.StatusGame;
import com.filos.refactorized.players.PlayerAnswer;
import com.filos.refactorized.players.Players;

public class Game {
    private final Players players;
    private final LoggerGame loggerGame;
    private final Questions questions;
    private final StatusGame statusGame;

    public Game(Players players) {
        this.players = players;
        statusGame = new StatusGame(players);
        questions = new QuestionFactory().createQuestions(statusGame);
        loggerGame = new LoggerGame(players, questions, statusGame);
    }

    public void play() {
        boolean winner = false;
        while (!winner) {
            statusGame.nextRoll();
            playCurrentPlayer();
            if (PlayerAnswer.answer()) {
                wrongAnswer();
            } else {
                winner = wasCorrectlyAnswered();
            }
        }
    }

    private void wrongAnswer() {
        players.setCurrentPlayerInPrison();
        players.moveToNextPlayer();
    }

    private void playCurrentPlayer() {
        loggerGame.printCurrentPlayer();
        loggerGame.printCurrentRoll();

        if (statusGame.isInPenaltyBox()) {
            if (statusGame.canGetOutOfPenaltyBox()) {
                statusGame.setInPenaltyBox(true);
                loggerGame.printCurrentPlayerIsOutPenalty();
                statusGame.addRoll();
                loggerGame.printNextLocationForPlayer();
                loggerGame.printCurrentCategory();
                questions.askNextQuestion();
            } else {
                loggerGame.printNotOut();
                statusGame.setInPenaltyBox(false);
            }
        } else {
            statusGame.addRoll();
            loggerGame.printNextLocationForPlayer();
            loggerGame.printCurrentCategory();
            questions.askNextQuestion();

        }
    }

    private boolean wasCorrectlyAnswered() {
        if (statusGame.isInPenaltyBox()) {
            if (statusGame.isInPenaltyBox()) {
                loggerGame.printCorrectAnswer();
                statusGame.increasePurses();
                boolean winner = statusGame.isWinning();
                players.moveToNextPlayer();
                return winner;
            } else {
                players.moveToNextPlayer();
                return true;
            }

        } else {
            loggerGame.printCorrectAnswer();
            statusGame.increasePurses();
            loggerGame.printPlayerHasGold();
            boolean winning = statusGame.isWinning();
            players.moveToNextPlayer();
            return winning;
        }
    }

}
