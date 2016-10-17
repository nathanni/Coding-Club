package com.nathan.crackingcodinginterview.solutions.arraysandstrings;

import java.util.Arrays;

//1.3 Given two strings, write a method to decide if one is a permutation of the others.

public class Q1_3_Permutaion {

	public static void main(String[] args) {
		System.out.println(permutation("212 3asd4", " dsa2341"));
		System.out.println(permutation2("12345", "24312"));
	}

	// Solution 1: sort two String, Time: O(nlogn)
	public static boolean permutation(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else {
			return (sort(s1).compareToIgnoreCase(sort(s2))) == 0 ? true : false;
		}

	}

	public static String sort(String str) {
		char[] strArray = str.toCharArray();
		Arrays.sort(strArray);
		return new String(strArray);
	}

	// Solution 2: Time: o(n)
/*	We can also use the definition of an anagram�two words with the same character
	counts�to implement this algorithm. We simply iterate through this code, counting
	how many times each character appears.Then, afterwards, we compare the two arrays.*/
	
	public static boolean permutation2(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		} else {

			int[] countForArray = new int[256]; //Assumption

			for (char c : s1.toCharArray()) {
				countForArray[c]++;
			}

			for (char c : s2.toCharArray()) {
				if (--countForArray[c] < 0) {
					return false;
				}
			}

			return true;
		}
	}
}



