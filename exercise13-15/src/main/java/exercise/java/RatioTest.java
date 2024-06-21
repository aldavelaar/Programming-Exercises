package exercise.java;
import java.util.Scanner;

public class RatioTest {
  public static void main(String[] args) {
    try (Scanner input = new Scanner(System.in)) {
      System.out.println("Enter the first rational number: ");
      long s1 = input.nextLong();
      long s2 = input.nextLong();
      Rational r1 = new Rational(s1, s2);
      System.out.println("Enter the second rational number: ");
      s1 = input.nextLong();
      s2 = input.nextLong();
      Rational r2 = new Rational(s1, s2);
      System.out.println("r1 + r2 = " + r1.add(r2));
      System.out.println("r1 - r2 = " + r1.subtract(r2));
      System.out.println("r1 * r2 = " + r1.multiply(r2));
      System.out.println("r1 / r2 = " + r1.divide(r2));
    }
  }
}