package com.filos.refactorized.players;

public class PlayersGenerator {
    public static Players of(String player1, String player2) {
        return new PlayersImpl(player1, player2);
    }

    public static PlayersImpl of(String player1, String player2, String player3) {
        PlayersImpl players = new PlayersImpl(player1, player2);
        players.addPlayer(player3);
        return players;
    }

    public static PlayersImpl of(String player1, String player2, String player3, String player4) {
        PlayersImpl players = PlayersGenerator.of(player1, player2, player3);
        players.addPlayer(player4);
        return players;
    }

    public static PlayersImpl of(String player1, String player2, String player3, String player4, String player5) {
        PlayersImpl players = PlayersGenerator.of(player1, player2, player3, player4);
        players.addPlayer(player5);
        return players;
    }

    public static Players of(String player1, String player2, String player3, String player4, String player5, String player6) {
        PlayersImpl players = PlayersGenerator.of(player1, player2, player3, player4, player5);
        players.addPlayer(player6);
        return players;
    }

}
