package com.nathan.crackingcodinginterview.solutions.arraysandstrings;

/*1.8 Assume you have a method isSubstring which checks if one word is a substring
of another. Given two strings, s1 and s2, write code to check If s2 is a rotation of s1
using only onecalltoisSubstring (e.g., "waterbottLe" is a rotation of "erbottLewat").*/

public class Q1_8_CheckRotation {
	

	public static void main(String [] args) {
		String s1 = "abc";
		String s2 = "bca";
		
		System.out.println(isRotation(s1, s2));
	}
	
	
	public static boolean isRotation(String s1, String s2) {
		
		return isSubString(s2, s1+s1);
		
		
	}
	
	
	public static boolean isSubString(String smallStr, String largerStr) {
		char[] larger = largerStr.toCharArray();
		char[] smaller = smallStr.toCharArray();

		int i = 0;

		for (int j = 0; j < larger.length; j++) {
			if (larger[j] == smaller[i]) {
				if (i == smaller.length - 1) {
					// done we found that this string is substring
					return true;
				}
				i++;
				continue;
			} else {
				if (i > 0) {
					// that means we encountered a duplicate character before
					// and if string was substring
					// it shouldn't have hit this condition..
					if (larger.length - j > smaller.length) {
						i = 0;
						// reset i here because there are still more characters
						// to check for substring..
					} else {
						// we don't have enough characters to check for
						// substring.. so done..
						return false;
					}

				}
			}

		}

		return false;
	}

}
