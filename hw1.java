import java.util.Scanner;

public class hw1 {
	public static void main(String[] args) {
		//Let user type 1 or 2, 1 is int matrix, 2 is double
		Scanner input = new Scanner(System.in);
		System.out.print("Press 1 if you want int matrix, press 2 if you want double matrix:");
		int key = input.nextInt();
		//when user want int matrix
		if (key == 1) {
			int[][] m1 = makeMatrix(100, 200);
			System.out.println();
			System.out.println("The first int matrix is:");
			printMatrix(m1);
			System.out.println();
			int[][] m2 = makeMatrix(200, 150);
			System.out.println("The second int matrix is:");
			printMatrix(m2);
			System.out.println();
			long startTime1 = System.nanoTime();
			int[][] multi = naiveMultiplication(m1, m2);
			long endTime1 = System.nanoTime();
			System.out.println("In the first algorithm, the result int matrix is:");
			printMatrix(multi);
			System.out.println();
			int[][] multi2 = rowNaiveMulti(m1, m2);
			System.out.println("After change the algorithm, the result int matrix is:");
			long startTime2 = System.nanoTime();
			printMatrix(multi2);
			long endTime2 = System.nanoTime();
			System.out.println();
			System.out.println("Program runs time of the first int matrix algorithm is:" + (endTime1 - startTime1) + "ns");
			System.out.println("Program runs time of the second int matrix algorithm is:" + (endTime2 - startTime2) + "ns");

		} 
		//when user want double matrix
		else if (key == 2) {
			double[][] m1 = makeDoubleMatrix(100, 200);
			System.out.println();
			System.out.println("The first double matrix:");
			printMatrix(m1);
			System.out.println();
			double[][] m2 = makeDoubleMatrix(200, 150);
			System.out.println("The second double matrix:");
			printMatrix(m2);
			System.out.println();
			System.out.println("In the first algorithm, the result double matrix is:");
			long startTime1 = System.nanoTime();
			double[][] multi = naiveMultiplication(m1, m2);
			long endTime1 = System.nanoTime();
			printMatrix(multi);
			System.out.println();
			double[][] multi2 = rowNaiveMulti(m1, m2);
			System.out.println("After change the algorithm, the result double matrix is:");
			long startTime2 = System.nanoTime();
			printMatrix(multi2);
			long endTime2 = System.nanoTime();
			System.out.println();
			System.out.println("Program runs time of the first double matrix algorithm is:" + (endTime1 - startTime1) + "ns");
			System.out.println("Program runs time of the second double matrix algorithm is:" + (endTime2 - startTime2) + "ns");

		} else {
			System.out.println("Please entre a valid number!");
		}

	}
	//randomly generate a int matrix 
	public static int[][] makeMatrix(int row, int colomn) {
		int[][] result = new int[row][colomn];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colomn; j++) {
				result[i][j] = (int) (Math.random() * 100); // the int in the matrix are randomly from 0 to 100
			}
		}
		return result;
	}
	//randomly generate a double matrix 
	public static double[][] makeDoubleMatrix(int row, int colomn) {
		double[][] result = new double[row][colomn];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < colomn; j++) {
				result[i][j] = (double) (Math.random() * 100); // the double in the matrix are randomly from 0 to 100
			}
		}
		return result;
	}
	//print out the int matrix
	static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}
	//print out the double matrix
	static void printMatrix(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.out.print(a[i][j] + " ");
			System.out.println();
		}
	}

	//Brute Force/Naive Algorithm
	//int matrix Multiplication
	public static int[][] naiveMultiplication(int[][] m1, int[][] m2) {
		if (m1[0].length != m2.length) {
			return null;
		}
		int[][] result = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}
	//double matrix Multiplication
	public static double[][] naiveMultiplication(double[][] m1, double[][] m2) {
		if (m1[0].length != m2.length) {
			return null;
		}
		double[][] result = new double[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}
	
	//Change the Algorithm, let row m.length in the inner loop	
	//int matrix Multiplication
	public static int[][] rowNaiveMulti(int[][] m1, int[][] m2) {
		if (m1[0].length != m2.length) {
			return null;
		}
		int[][] result = new int[m1.length][m2[0].length];
		for (int j = 0; j < m2[0].length; j++) {
			for (int i = 0; i < m1.length; i++) {
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}
	//double matrix Multiplication
	public static double[][] rowNaiveMulti(double[][] m1, double[][] m2) {
		if (m1[0].length != m2.length) {
			return null;
		}
		double[][] result = new double[m1.length][m2[0].length];
		for (int j = 0; j < m2[0].length; j++) {
			for (int i = 0; i < m1.length; i++) {
				for (int k = 0; k < m1[0].length; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}

}
