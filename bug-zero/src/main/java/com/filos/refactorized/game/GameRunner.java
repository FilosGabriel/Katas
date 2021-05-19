package com.filos.refactorized.game;

import com.filos.refactorized.players.PlayersGenerator;
import com.filos.refactorized.players.PlayersImpl;

public class GameRunner {

    public static void main(String[] args) {
        PlayersImpl players = PlayersGenerator.of("Chet", "Pat", "Sue");
        Game game = new Game(players);
        game.play();
    }
}
