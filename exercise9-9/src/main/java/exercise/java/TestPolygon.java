package exercise.java;

public class TestPolygon {
    /** Main method */ 
    public static void main(String[] args) {
// let's make polygons
      Polygon polygon1 = new Polygon();
      System.out.println("The area of the polygon is "
        + polygon1.getArea() + " and the perimeter is " + polygon1.getPerimeter());

      Polygon polygon2 = new Polygon(6, 4);
      System.out.println("The area of the polygon is "
        + polygon2.getArea() + " and the perimeter is " + polygon2.getPerimeter());
      
      Polygon polygon3 = new Polygon(10, 4, 5.6, 7.8);
      System.out.println("The area of the polygon is "
        + polygon3.getArea() + " and the perimeter is " + polygon3.getPerimeter());
  
    
    }
  }
// the polygon object
  class Polygon {
    int numSides;
    double side;
    double x;
    double y;
// no args constructor
    public Polygon() {
      this.numSides = 3;
      this.side = 1;
      this.x = 0;
      this.y = 0;
    }

    public Polygon(int numsides, int side) {
      this.numSides = numsides;
      this.side = side;
      this.x = 0;
      this.y = 0;
    }

    public Polygon(int numsides, int side, double x, double y) {
      this.numSides = numsides;
      this.side = side;
      this.x = x;
      this.y = y;
    }
// get that area
    double getArea() {
      return (this.numSides * Math.pow(this.side, 2))
      / (4 * Math.tan(Math.PI / numSides));
    }
// and the perimeter too
    double getPerimeter() {
      return this.side * this.numSides;
    }
  }