package com.nathan.interviews.twitter.oa;
import java.util.*;

class TwitterOA1 {
    public static void main(String[] args) {
        String[] bank = {"CCT","AATTGGCA", "TATTGGCC", "TTTTGGCC", "TTTTGGCA"};
        String start = "CCT";
        String end = "ACT";
        System.out.println(findMutationDistance(start, end, bank));
    }


    static int findMutationDistance(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return Integer.MAX_VALUE;

        if (start.equals(end)) return 0;

        HashSet<String> dict = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        for (String s: bank) {
            dict.add(s);
        }
        dict.add(start);
        visited.add(start);
        Queue<String> queue = new LinkedList<>();
        int level = 0;

        queue.offer(start);

        while (!queue.isEmpty()) {

            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                List<String> nextWords = getNextWords(curr, dict);
                for (String nextWord : nextWords) {
                    if (visited.add(nextWord)) {
                        if (nextWord.equals(end)) {
                            return level;
                        }
                        queue.offer(nextWord);
                    }
                }
            }

        }
        return Integer.MAX_VALUE;
    }

    public static List<String> getNextWords(String word, HashSet<String> dict) {
        List<String> words = new ArrayList<>();
        if (word == null || word.length() == 0) {
            return words;
        }
        char[] cArr = {'A', 'C', 'T', 'G'};

        for (int i = 0; i < word.length(); i++) {
            for (char c : cArr) {
                if (c == word.charAt(i)) continue;
                String newWord = replace(word, i, c);

                if (dict.contains(newWord)) {
                    words.add(newWord);
                }
            }
        }
        return words;


    }

    public static String replace(String word, int i, char c) {
        char[] wordArr = word.toCharArray();
        wordArr[i] = c;
        return new String(wordArr);
    }
}