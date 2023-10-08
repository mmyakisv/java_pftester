package ru.stqa.pftester.sandbox;

public class Triangle {
    public double a;
    public double b;
    public double c;




    public Triangle(double a, double b, double c) {


        this.a = a;
        this.b = b;
        this.c = c;

        if (a <0 || b<0 || c<0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (a + b < c || b + c < a || a + c < b) {
            throw new IllegalArgumentException("The sum of any two sides must not be less than the third");
        }
    }


    public double perimeter() {
        return this.a + this.b + this.c;
    }

    public double square() {
        return Math.sqrt((perimeter() / 2 * (perimeter() / 2 - this.a) * (perimeter() / 2 - this.b) * (perimeter() / 2 - this.c)));
    }


}
