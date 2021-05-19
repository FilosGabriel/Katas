package com.filos.refactorized.players;

import java.util.Random;

import lombok.experimental.UtilityClass;

@UtilityClass
public class PlayerAnswer {
    private static final Random random = new Random();

    public static boolean answer() {
        return random.nextInt(9) == 7;
    }
}
