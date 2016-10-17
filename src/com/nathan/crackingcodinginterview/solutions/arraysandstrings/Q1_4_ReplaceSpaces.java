package com.nathan.crackingcodinginterview.solutions.arraysandstrings;

/*1.4 Write a method to replace all spaces in a string with '%20'. You may assume that the
string has sufficient space at the end of the string to hold the additional characters,
and that you are given the "true" length of the string. (Note: if implementing in Java,
please use a character array so that you can perform this operation in place.)
*/

public class Q1_4_ReplaceSpaces {

	
	public static void main(String[] args) {
		
		char[] charArray = new char[500];
		
		charArray[0] = 'h';
		charArray[1] = 'e';
		charArray[2] = ' ';
		charArray[3] = 'h';
		charArray[4] = ' ';
		charArray[5] = 'd';
		
		for(char c: charArray) {
			System.out.print(c);
		}
		System.out.println();
		change(charArray, 6);
		for(char c: charArray) {
			System.out.print(c);
		}
		System.out.println();
	

	}
	
	public static void change(char [] charArray, int orgLength) {
		int newLength = 0, spaceCount = 0;
		
		for(int i = 0; i < orgLength; i++) {
			if(charArray[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLength = orgLength + 2 * spaceCount;
		charArray[newLength] = '\0';
		for(int i = orgLength - 1; i >= 0; i--) {
			if(charArray[i] == ' ') {
				charArray[newLength - 1] = '0';
				charArray[newLength - 2] = '2';
				charArray[newLength - 3] = '%';
				newLength -= 3;
			} else {
				charArray[newLength - 1] = charArray[i];
				newLength -= 1;
			}
		}
	}
}
	
	



