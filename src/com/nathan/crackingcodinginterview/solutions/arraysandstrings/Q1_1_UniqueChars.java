package com.nathan.crackingcodinginterview.solutions.arraysandstrings;

//1.1Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

/*Tips:  You may want to start off with asking your interviewer if the string is an ASCII string or
a Unicode string. This is an important question, and asking it will show an eye for detail
and a deep understanding of Computer Science.
*/

public class Q1_1_UniqueChars {
	public static void main(String[] args) {
		System.out.println(isUniqueChars2("cd213579 bav"));
	}
	
	
	//Time: O(n)   Space: O(1)
	public static boolean isUniqueChars(String str) {
		
		boolean [] checkVal = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			if(checkVal[str.charAt(i)]) {
				return false;
			}
			checkVal[str.charAt(i)] = true;
		}
		return true;
	}
	
	
	//We can reduce our space usage by a factor of eight by using a bit vector.
	//Bit Vector
	public static boolean isUniqueChars2(String str) {
		long checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
