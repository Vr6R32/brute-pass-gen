package com.thebrute;

public class WifiCracker {



    public static void main(String[] args) {
        CombinationGenerator generator = CombinationGenerator.getInstance();
        generator.setCombinationSizeRange(4,8);
        generator.generateCombinations();
    }
}