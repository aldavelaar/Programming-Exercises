package exercise.java;

public class Circle extends GeometricObject implements Comparable<Circle> {
  private double radius;

  public Circle() {
  }

  public Circle(double radius) {
    this.radius = radius;
  }

  public Circle(double radius,
      String color, boolean filled) {
    this.radius = radius;
    setColor(color);
    setFilled(filled);
  }

  /** Return radius */
  public double getRadius() {
    return radius;
  }

  /** Set a new radius */
  public void setRadius(double radius) {
    this.radius = radius;
  }

  /** Return area */
  public double getArea() {
    return radius * radius * Math.PI;
  }

  /** Return diameter */
  public double getDiameter() {
    return 2 * radius;
  }

  /** Return perimeter */
  public double getPerimeter() {
    return 2 * radius * Math.PI;
  }

  /** Print the circle info */
  public void printCircle() {
    System.out.println("The circle is created " + getDateCreated() +
      " and the radius is " + radius);
  }

  @Override
  public int compareTo(Circle o) {
    if (getRadius()>o.getRadius()) {
      return 1;
    } else if (getRadius()<o.getRadius()) {
      return -1;
    } else {
      return 0;
    }

  }
}