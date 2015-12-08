package com.nathan.leetcode.easy;

public class BullsAndCows {
  public static void main(String[] args) {
    System.out.println(getHint("1122", "2211"));

  }
  
  
  //one array solution
  public String getHint2(String secret, String guess) {
    int bulls = 0;
    int cows = 0;
    int[] numbers = new int[10];
    for (int i = 0; i<secret.length(); i++) {
        int s = Character.getNumericValue(secret.charAt(i));
        int g = Character.getNumericValue(guess.charAt(i));
        if (s == g) bulls++;
        else {
            if (numbers[s] < 0) cows++;
            if (numbers[g] > 0) cows++;
            numbers[s] ++;
            numbers[g] --;
        }
    }
    return bulls + "A" + cows + "B";
}

  public static String getHint(String secret, String guess) {

    int bulls = 0;
    int cows = 0;
    int[] secretArr = new int[10];
    int[] guessArr = new int[10];
    
    for(int i = 0; i < secret.length(); i++) {
      char c1 = secret.charAt(i);
      char c2 = guess.charAt(i);
      if(c1 == c2) {
        bulls++;
        continue;
      }
      ++secretArr[Character.getNumericValue(c1)];
      ++guessArr[Character.getNumericValue(c2)];
    }
    for(int i = 0; i<10; i++) {
      cows += Math.min(secretArr[i],guessArr[i]);
    }
    return bulls + "A" + cows + "B";
  }
}
