package com.filos.refactorized;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Questions {
    private final Map<Integer, LinkedList<String>> categories;
    private final List<String> categoriesNames;
    private final StatusGame statusGame;

    public Questions(LinkedList<String> popQuestions,
                     LinkedList<String> scienceQuestions,
                     LinkedList<String> sportsQuestions,
                     LinkedList<String> rockQuestions, StatusGame statusGame) {
        this.statusGame = statusGame;
        categoriesNames = List.of("Pop", "Science", "Sport", "Rock");
        categories = Map.of(
                0, popQuestions,
                1, scienceQuestions,
                2, sportsQuestions,
                3, rockQuestions
        );
    }

    public String getCurrentCategory() {
        return categoriesNames.get(statusGame.getPlaceForCurrentPlayer() % 4);
    }

    public void askNextQuestion() {

        System.out.println(categories.get(statusGame.getPlaceForCurrentPlayer() % 4).removeFirst());
    }
}
