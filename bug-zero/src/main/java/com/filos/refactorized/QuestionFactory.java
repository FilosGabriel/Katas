package com.filos.refactorized;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionFactory {
    public LinkedList<String> createPopQuestions() {
        return IntStream.range(0, 50)
                        .mapToObj(no -> "Pop Question " + no)
                        .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<String> createScienceQuestions() {
        return IntStream.range(0, 50)
                        .mapToObj(no -> "Science Question " + no)
                        .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<String> createSportQuestions() {
        return IntStream.range(0, 50)
                        .mapToObj(no -> "Sport Question " + no)
                        .collect(Collectors.toCollection(LinkedList::new));
    }

    public LinkedList<String> createRockQuestions() {
        return IntStream.range(0, 50)
                        .mapToObj(no -> "Rock Question " + no)
                        .collect(Collectors.toCollection(LinkedList::new));
    }

    public Questions createQuestions(StatusGame statusGame) {
        return new Questions(
                createPopQuestions(),
                createScienceQuestions(), createSportQuestions(),
                createRockQuestions(),
                statusGame
        );
    }
}
