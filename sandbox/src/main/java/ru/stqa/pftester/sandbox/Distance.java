package ru.stqa.pftester.sandbox;

public class Distance {

    public static void main(String[] args) {
        Point p1 = new Point(8, 6);
        Point p2 = new Point(4, 3);

        System.out.println("Расстояние между точками с координатами " + p1.x + "," + p1.y + " и " + p2.x + "," + p2.y +
                " = " + p1.distance(p2));
    }
}
