package com.nathan.crackingcodinginterview.solutions.arraysandstrings;

//1.2 Implement a function void reverse(char* str) in C or C++ which reverses a null-terminated string.

public class Q1_2_ReverseString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverse("123445"));
		System.out.println(reverse1("123445"));
	}
	
	//StringBuffer
	public static String reverse(String str) {
		StringBuffer sBuffer = new StringBuffer();
		for(int i = str.length() - 1 ; i >= 0; i--) {
			//System.out.println(str.charAt(i));
			sBuffer.append(str.charAt(i));
		}
		return sBuffer.toString();
	}
	
	//Recursion
	public static String reverse1(String str) {
		if(str.length() <= 1)
			return str;
		return reverse1(str.substring(1)) + str.charAt(0);
		
	}
	
	//fastest way in c++
/*	#include<iostream>
	using namespace std;

	void reverse(char* str) {
		
		char temp;
		char * end = str;
		if(str) {
			while(*end) {
				++end;
			}
		}
		
		--end;
		
		while(str<end) {
			temp = *str;
			*str++ = *end;
			*end-- = temp;
		}
		
	}
	int main() {

	    char strc[] = "hasdfsdf2344ello";
		char* str = strc;
	        cout<<str<<endl;
		reverse(str);
		cout<<str<<endl;
	}*/
}
