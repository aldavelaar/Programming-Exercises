package exercise.java;
import java.util.Scanner;

public class exercise {
    public static void main(String[] args) {
      int[][] m1 = getArray(); // Get an array
      int[][] m2 = getArray(); // Get another array
 
      if (equals(m1, m2)) {
        System.out.println("\nThe two arrays are strictly identical");
      } else {
        System.out.println("\nThe two arrays are not strictly identical");
      }
    }

    public static int[][] getArray() {
     // Create a Scanner
     Scanner input = new Scanner(System.in);
 
     // Enter array values
      int[][] m = new int[3][3];
      System.out.println("Enter " + m.length + " rows and " + m[0].length + " columns: ");
      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[i].length; j++) {
          m[i][j] = input.nextInt();
        }
      }
      return m;
    }
 
    public static boolean equals(int[][] m1, int[][] m2) {
      for (int row = 0; row < m1.length; row++) {
        for (int column = 0; column < m1[row].length; column++) {
          if (m1[row][column] != m2[row][column]) {
            return false;
          }
        }
      }
 
      return true;
    }
}