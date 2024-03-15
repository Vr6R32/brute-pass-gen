package com.thebrute;

public class TheBrute {


    public static void main(String[] args) {
        CombinationGenerator generator = CombinationGenerator.getInstance();
        generator.setCombinationSizeRange(4,8);
        generator.setCombinationToFind("abdce");
        generator.generateCombinations();
    }
}