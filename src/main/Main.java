package main;

import java.util.Arrays;

public class Main {
	
	public static int calculateDistance(String firstWord, String secondWord) {
		final int lengthFirstWord = firstWord.length();
		final int lengthSecondWord = secondWord.length();
		int[][] matrix = new int[lengthFirstWord+1][lengthSecondWord+1];
		for (int i = 0; i <= lengthFirstWord; i++) {
			matrix[i][0] = i;
		}
		for (int j = 0; j <= lengthSecondWord; j++) {
			matrix[0][j] = j;
		}
		for (int j = 1; j <= lengthSecondWord; j++) {
			for (int i = 1; i <= lengthFirstWord; i++) {
				int substitutionCost = firstWord.charAt(i - 1) == secondWord.charAt(j - 1) ? 0 : 1;
				int deletion = matrix[i-1][j] + 1;
				int insertion = matrix[i][j-1] + 1;
				int substitution = matrix[i-1][j-1] + substitutionCost;;
				matrix[i][j] = Math.min(deletion, Math.min(insertion, substitution));
			}
		}
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
		return matrix[lengthFirstWord][lengthSecondWord];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(calculateDistance("saturday", "saturday"));
	}

}
