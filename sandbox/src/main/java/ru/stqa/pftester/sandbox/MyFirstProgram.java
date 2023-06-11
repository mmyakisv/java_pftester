package ru.stqa.pftester.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

    hello("world");
    hello("user");
    hello("Max");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p = new Point();
    p.p1 =
    p.p2 =
    System.out.println("Расстояние между двумя точками " + p.p1 + " и " + p.p2 + " = " + distance(p));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(Point p) {
    return (p.p1 - p.p2);
  }
}