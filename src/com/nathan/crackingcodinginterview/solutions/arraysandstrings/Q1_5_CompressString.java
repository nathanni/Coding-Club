package com.nathan.crackingcodinginterview.solutions.arraysandstrings;



/*1.5 Implement a method to perform basic string compression using the counts of
 repeated characters. For example, the string aabcccccaaa would become
 a2blc5a3. If the "compressed" string would not become smaller than the original
 string, your method should return the original string.
 */
public class Q1_5_CompressString {

	public static void main(String[] args) {
		String str1 = "aaabbbccc";
		String str2 = compressString(str1);
		String str3 = compressBad(str1);
		String str4 = getCompressedString(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str4);

		System.out.println(getCompressedSize(str1));
		
		int n = 1;
		int length = (int)(Math.log10(n)+1); //easy way to get digit
		System.out.println(length);

		/*
		 * char [] arr = new char[100];
		 * 
		 * addToArray(arr, 'a', 26000100, 0); System.out.println(new
		 * String(arr));
		 */
	}

	//1. best solution
	public static String getCompressedString(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}

		//get size for the compressed array
		int compressedSize = getCompressedSize(str);
		if (compressedSize > str.length()) {
			return str;
		}

		char[] arr = new char[compressedSize];
		char last = str.charAt(0);
		int count = 1;
		int index = 0; //index for where to insert the characters

		for (int i = 1; i < str.length(); i++) {
			if (last == str.charAt(i)) {
				count++;
			} else {
				index = addToArray(arr, last, count, index);
				last = str.charAt(i);
				count = 1;

			}
		}
		
		/* Wee need to update the string at the end of the method as well,
		 * sice the very last set of repeated characters wouldn't be set in the 
		 * compressed string yet.
		 */
		addToArray(arr, last, count, index);
		return new String(arr);

	}

	//function to insert char and digit to array
	public static int addToArray(char[] arr, char last, int count, int index) {
		arr[index++] = last;
		int digitCount = 0;
		int temp = count;
		do {
			digitCount++;
			temp = temp / 10;
		} while (temp != 0);

		for (int i = digitCount; i > 0; i--) {
			arr[index++] = (char) ((count / Math.pow(10, (i - 1))) % 10 + 48);   //48 is '0' in ASCII
		}

		return index;
	}

	// count compressed size
	public static int getCompressedSize(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}

		char last = str.charAt(0);
		int count = 1;
		int size = 0;

		for (int i = 1; i < str.length(); i++) {
			if (last == str.charAt(i)) {
				count++;
			} else {
				do {
					size++;
					count = count / 10;
				} while (count != 0);
				size++;
				last = str.charAt(i);
				count = 1;
			}
		}

		// finally
		do {
			size += 1;
			count = count / 10;
		} while (count != 0);
		size++;

		return size;
	}

	
	
	
	
	
	
	
	
	//2. My solution, use ARRAY
	public static String compressString(String str) {
		char[] orgArr = str.toCharArray();
		char[] compressedArr = new char[orgArr.length];
		int count = 0;
		try {
			for (int i = 0, j = 0; i < orgArr.length; i++) {
				// happen when the digit is different from the digit before it
				if (i != 0 && orgArr[i] != orgArr[i - 1]) {
					compressedArr[j] = orgArr[i - 1];
					j++;
					if (count >= 10) { // need to handle 2 digit count
						compressedArr[j] = (char) (count / 10 + 48); // 48 is 0 in ASCII
						j++;
						compressedArr[j] = (char) (count % 10 + 48);
						j++;
					} else {
						compressedArr[j] = (char) (count + 48);
						j++;
					}
					count = 0;
				}

				count++;

				// last digit need to be save
				if (i == orgArr.length - 1) {
					compressedArr[j] = orgArr[i];
					j++;
					if (count >= 10) { // need to handle 2 digit count
						compressedArr[j] = (char) (count / 10 + 48); // 48 is 0 in ASCII
						j++;
						compressedArr[j] = (char) (count % 10 + 48);
						j++;
					} else {
						compressedArr[j] = (char) (count + 48);
						j++;
					}
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return str;
		}
		return new String(compressedArr);
	}

	
	
	
	//3. standardSolution WORST SOLUTION! should now use it
	public static String compressBad(String str) {
		String mystr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) { // Found repeat char
				count++;
			} else { // Insert char count, and update last char
				mystr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		mystr += last + "" + count;
		if (mystr.length() > str.length())
			return str;
		else
			return mystr;
	}
}

