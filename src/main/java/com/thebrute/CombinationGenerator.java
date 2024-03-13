package com.thebrute;

public class CombinationGenerator {

    public static final double DIVISION_FOR_SECOND_DURATION = 1_000_000_000.0;
    private static CombinationGenerator instance;
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private int minLength = 0;
    private int maxLength = 0;
    private boolean found = false;
    private int count = 0;

    private CombinationGenerator() {
    }

    public static CombinationGenerator getInstance() {
        if (instance == null) {
            instance = new CombinationGenerator();
        }
        return instance;
    }

    public void setCombinationSizeRange(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public void generateCombinations() {
        long startTime = System.nanoTime();

        found = false;
        count = 0;
        for (int currentLength = minLength; currentLength <= maxLength; currentLength++) {
            generateCombinationsHelper("", 0, currentLength);
            if (found) break;
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Total combinations tried: " + count);
        System.out.println("Execution time: " + duration / DIVISION_FOR_SECOND_DURATION + " seconds");
    }

    private void generateCombinationsHelper(String currentString, int currentIndex, int targetLength) {
        if (found) {
            return;
        }

        if (currentIndex == targetLength) {
            count++;
            if (currentString.equals("abcdef")) {
                System.out.println(currentString);
                found = true;
            }
            return;
        }

        for (int i = 0; i < CHARACTERS.length(); i++) {
            String newString = currentString + CHARACTERS.charAt(i);
            generateCombinationsHelper(newString, currentIndex + 1, targetLength);
        }
    }
}
