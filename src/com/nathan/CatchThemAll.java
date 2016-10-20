package com.nathan;
import java.util.Arrays;

class CatchThemAll {

    static class PokeMap {

        private final long[][] grid;

        PokeMap(long[][] grid) {
            this.grid = grid;
        }

        public long getSizeX() {
            return grid[0].length;
        }

        public long getSizeY() {
            return grid.length;
        }

        public long getValue(Location loc) {
            return getValue(loc.getX(), loc.getY());
        }

        long getValue(int x, int y) {
            if (y >= grid.length || x >= grid[y].length) {
                throw new IllegalArgumentException("Requested coordinates outside of map");
            }
            return grid[y][x];
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String lineSeparator = System.getProperty("line.separator");
            for (long[] row : grid) {
                sb.append(Arrays.toString(row)).append(lineSeparator);
            }
            return sb.toString();
        }
    }

    static class Location {

        private final int x;
        private final int y;

        Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getY() {
            return y;
        }

        int getX() {
            return x;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static double sqrt(double a) {
        return Math.sqrt(a);
    }

    private static double log10(double a) {
        return Math.log10(a);
    }

    private static double roundToPlaces(double d, int numDecimalPlaces) {
        int scaleFactor = (int) Math.pow(10, numDecimalPlaces);
        return Math.floor(d * scaleFactor) / scaleFactor;
    }

    /**
     * Complete the function below
     */
    static double findMaximumXP(Location playerPosition, long numPokeBalls, PokeMap pokeMap) {

        double[] maximum = new double[]{0.0};

        dfs(maximum, 0.0, playerPosition, playerPosition, numPokeBalls, pokeMap);

        return roundToPlaces(maximum[0], 3);

    }

    static void dfs(double[] maximum, double currXp, Location playerPosition, Location pokemonPosition, long numPokeBalls, PokeMap pokeMap) {

        if (numPokeBalls == 0 || pokemonPosition.getX() < 0 || pokemonPosition.getX() >= pokeMap.getSizeX() || pokemonPosition.getY() < 0 || pokemonPosition.getY() >= pokeMap.getSizeY())
            return;


        double gainedXp = calculateXp(playerPosition, pokemonPosition, pokeMap);
        if (gainedXp != 0) numPokeBalls--;

        maximum[0] = Math.max(maximum[0], gainedXp + currXp);


        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int[] dir : dirs) {
            int x = pokemonPosition.getX() + dir[0];
            int y = pokemonPosition.getY() + dir[1];
            Location newPokemonPosition = new Location(x, y);
            dfs(maximum, gainedXp + currXp, playerPosition, newPokemonPosition, numPokeBalls, pokeMap);
        }
    }

    static double calculateXp(Location playerPosition, Location pokemonPosition, PokeMap pokeMap) {
        double res = 0.0;

        double xpPokemon = pokeMap.getValue(pokemonPosition);
        double distance = sqrt((pokemonPosition.getX() - playerPosition.getX()) * (pokemonPosition.getX() - playerPosition.getX()) +
                (pokemonPosition.getY() - playerPosition.getY()) * (pokemonPosition.getY() - playerPosition.getY()));
        double cost = distance + log10(xpPokemon);

        res = xpPokemon / cost;
        return res;
    }

}