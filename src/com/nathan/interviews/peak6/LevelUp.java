package com.nathan.interviews.peak6;

/**
 * Created by nni on 10/20/2016.
 */

class LevelUp {


    static class Pokemon {

        final double attack;
        final double defense;
        final double stamina;
        double level;

        Pokemon(double attack, double defense, double stamina, double level) {
            this.attack = attack;
            this.defense = defense;
            this.stamina = stamina;
            this.level = level;
        }
    }

    static class CPMultiplier {

        private final double[] multipliers;

        CPMultiplier(double[] multipliers) {
            this.multipliers = multipliers;
        }


        double getMultiplierForLevel(double level) {
            if (level > 40.0d) {
                return multipliers[multipliers.length - 1];
            }
            return multipliers[(int) (level * 2 - 2)];
        }
    }

    private static double sqrt(double a) {
        return Math.sqrt(a);
    }

    private static double roundToPlaces(double d, int numDecimalPlaces) {
        int scaleFactor = (int) Math.pow(10, numDecimalPlaces);
        return ((double) Math.floor(d * scaleFactor)) / scaleFactor;
    }




/*
 * Complete the function below.
 */

    static double findMaximumCPGained(long numPowerUps, Pokemon[] pokemonArray, CPMultiplier cpMultiplierMapping) {

        double[] maxCPGained = new double[]{0, 0};

        dfs(maxCPGained, 0.0, numPowerUps, pokemonArray, cpMultiplierMapping, 1.0);

        return roundToPlaces(maxCPGained[0], 8);

    }

    static void dfs(double[] maxCPGained, double currCPGained, long numPowerUps, Pokemon[] pokemonArray, CPMultiplier cpMultiplierMapping, double level) {

        if (numPowerUps == 0 || level > 40) return;


        for (Pokemon pokemon : pokemonArray) {
            double CPGained = calculateCPGained(pokemon, cpMultiplierMapping, level + 0.5);
            currCPGained += CPGained;
            maxCPGained[0] = Math.max(maxCPGained[0], currCPGained);
            dfs(maxCPGained, currCPGained, numPowerUps - 1, pokemonArray, cpMultiplierMapping, level);
            currCPGained -= CPGained;
        }


    }

    static double calculateCPGained(Pokemon pokemon, CPMultiplier cpMultiplierMapping, double level) {

        return (pokemon.attack * sqrt(pokemon.defense) * sqrt(pokemon.stamina) * cpMultiplierMapping.getMultiplierForLevel(level) * cpMultiplierMapping.getMultiplierForLevel(level)) / 10.0;

    }
}