package com.nathan.crackingcodinginterview.solutions.arraysandstrings;


/*Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?*/


public class Q1_6_RotateMatrix {

	public static void main(String[] args) {
		
		int [][]arr =new int[][]{{1,2,3,4},{5,6,7,8},{10,11,12,13},{14,15,16,17}};
		int [][]arr1 = new int [][]{{1,2,3,4,5,6},{7,8,9,10,11,12},{13,14,15,16,17,18},{19,20,21,22,23,24},{25,26,27,28,29,30},{31,32,33,34,35,36}};
		
		
		printMatrix(arr);
		rotateMatrix(arr, 4);
		System.out.println();
		printMatrix(arr);
		System.out.println();
		printMatrix(arr1);
		rotateMatrix(arr1, 6);
		System.out.println();
		printMatrix(arr1);
	}
	
/*	This algorithm is 0(N2), which is the best we can do since any algorithm must touch all
	N2 elements.*/
	
	//arr[n][m] = arr[N-1-m][n]    clockwise rotate 90 degreee
	public static void rotateMatrix(int[][] arr, int n) {
		
		
		for(int layer = 0,m = 0; layer < n/2; layer++) {
			
			if(layer == 0 )
				m = n ;
			else 
				m= m - 2;
			
			for(int i = layer, j = layer; i < m-1 + layer; i++) {
				
				int top = arr[j][i]; //save top as temp
				
				//left to top // top=left
				arr[j][i] = arr[n-1-i][j];
				
				//bottom to left // left = bottom
				arr[n-1-i][j] = arr[n-1-j][n-1-i];
				
				//right to bottom // bottom = right
				arr[n-1-j][n-1-i] = arr[i][n-1-j];
				
				//top to right //right = top
				arr[i][n-1-j] = top;
			}
		}
	}
	
	//print 
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
	}
	
	
	
	// Leetcode solution
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}

}
