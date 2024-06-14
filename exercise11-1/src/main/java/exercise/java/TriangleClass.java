package exercise.java;
import java.util.Scanner;

public class TriangleClass {
    /** Main method */ 
    public static void main(String[] args) {
      try (// Create a Scanner
      Scanner input = new Scanner(System.in)) {

        System.out.println("Enter three sides of a triangle as numbers with a decimal point, one at a time, pressing enter after each number.");
        Triangle triangle = new Triangle(input.nextDouble(), input.nextDouble(), input.nextDouble());
        System.out.println("Is the triangle filled? Enter \"true\" or \"false\"");
        boolean filled = input.nextBoolean();
        System.out.println("The area of the triangle is " + triangle.getArea()
        + " and the perimeter is " + triangle.getPerimeter() + ".");
        if (filled) {
          System.out.println("The triangle is filled.");
        } else {
          System.out.println("The triagle is not filled.");
        }
    
      }
    }
  }

// the triangle object
  class Triangle {
    double side1;
    double side2;
    double side3;

// no args constructor
    public Triangle() {
      this.side1 = 1.0;
      this.side2 = 1.0;
      this.side3 = 1.0;
    }

    public Triangle(double s1, double s2, double s3) {
      this.side1 = s1;
      this.side2 = s2;
      this.side3 = s3;
    }

// get that area
    double getArea() {
      double s = (this.side1 + this.side2 + this.side3) / 2;
      return Math.sqrt(s * (s - this.side1) * (s - this.side2) * (s - this.side3));
    }

// and the perimeter too
    double getPerimeter() {
      return this.side1 + this.side2 + this.side3;
    }
  }