package com.nathan.crackingcodinginterview.solutions.arraysandstrings;
/*1.7 Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.*/
public class Q1_7_SetZeros {

	public static void main(String [] args) {
		int [][]arr =new int[][]{{0,2,3,4},{5,6,99,8},{10,11,0,13},{14,15,16,17}};
		printMatrix(arr);
		setZeros(arr);
		printMatrix(arr);
		
/*		short a = 0;
		for(int i = 0; i < 17 ; i ++) {
			a = (short) (1 << i);
			System.out.println(i + " " + a);
		}*/

	}
	
	
	public static void setZeros(int[][] matrix) {

		int rowChecker = 0, columnChecker = 0;

		// first loop, get the point which is zero
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rowChecker |= 1 << i;
					columnChecker |= 1 << j;
				}
			}
		}

		//second loop, to set zeros
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if ((rowChecker & 1 << i) > 0 || (columnChecker & 1 << j) > 0) {
					matrix[i][j] = 0;
				}
			}
		}
	}
	
	public static void printMatrix(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] < 10) 					
					System.out.print("0"+ arr[i][j] + " ");
				else 
					System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
