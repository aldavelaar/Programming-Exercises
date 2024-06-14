package exercise.java;
import java.util.Scanner;


public class BinaryFormatException extends Exception {
  /** Main method */ 
  public static void main(String[] args) throws BinaryFormatException {
    try (// Create a Scanner
      Scanner input = new Scanner(System.in)) {
        System.out.println("Enter an integer.");
        int num = input.nextInt();
        String biNum = Integer.toBinaryString(num);
        if (biNum != null ? Integer.toBinaryString(num) == null : biNum.equals(Integer.toBinaryString(num))) {
          throw new  BinaryFormatException();
        }
        System.out.println("The binary translation is " + biNum + ".");
      }
  }
}