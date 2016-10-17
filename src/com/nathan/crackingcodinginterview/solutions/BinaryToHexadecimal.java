package com.nathan.crackingcodinginterview.solutions;


//Write a function to check if the value of a binary number(passed as a string) equals the hexadecimal representation of a string


public class BinaryToHexadecimal {
	public static void main(String[] args) {
		
		System.out.println(compareBinToHex("11110000011110011", "1e0f3"));
		
	}
	
	public static boolean compareBinToHex(String binString, String hexadecimalString) {
		int binary = convertToBase(binString, 2);
		int hexadecimal = convertToBase(hexadecimalString, 16);
		
		if(binary < 0 || hexadecimal < 0)
			return false;
		else 
			return binary == hexadecimal;
	}
	
	//convert char of the string into digit
	public static int getDigit(char digitChar) {
		
		int digit = 0;
		if(digitChar >= 'a' && digitChar <= 'f') {
			digit = 9 + digitChar - 'a' + 1;
		} else if(digitChar >= 'A' && digitChar <= 'F') {
			digit = 9 + digitChar - 'A' + 1;
		} else if(digitChar >= '0' && digitChar <= '9'){
			digit = Integer.parseInt(digitChar + "");
		} else {
			digit = -1;
		}
		
		return digit;
		
		
		
		
	}

	//convert string to base (decimal number)
	public static int convertToBase(String number, int base) {
		
		if(base < 2 || base > 10 && base != 16) return -1;  //we only convert for BINARY and HEXADECIMAL
		int value = 0;
		for(int i = 0; i <= number.length()-1; i++) {
			int digit = getDigit(number.charAt(i));
			if(digit < 0 || digit > base) return -1; //return error
			value += digit * Math.pow(base,number.length()-1-i);
		}
		
		return value;
		
	}
}
