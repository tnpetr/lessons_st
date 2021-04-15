package ru.st.less;

public class MyFirstProgram {
    public static void main(String[] args) {
        Point p1 = new Point(0,4);
        Point p2 = new Point(6,0);

        System.out.println("Вычислеине с помощью функции. Расстояние между точками: " + distance(p1, p2));
        System.out.println("Вычисление с помощью метода класса. Расстояние между точками: " + p1.distance(p2));
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt(Math.pow(p1.x-p2.x,2)+Math.pow(p1.y- p2.y, 2));
    }
}
