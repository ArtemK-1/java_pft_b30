package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    //Площадь квадрата
    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    //Площадь прямоугольника
    Rectangle r = new Rectangle(5, 10);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b +  " = " + r.area());

    //Расстояние между двумя точками на плоскости через функцию
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 10);
    System.out.println("Расстояние между двумя точками [" + p1.x + "," + p1.y + "]" + " и [" + p2.x + "," + p2.y + "]" + " = " + distance(p1, p2));

    //Расстояние между двумя точками на плоскости через метод класса.
    System.out.println("Расстояние между двумя точками [" + p1.x + "," + p1.y + "]" + " и [" + p2.x + "," + p2.y + "]" + " = " + p1.distance(p2));
  }
  public static double distance(Point p1, Point p2){
    return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
  }
}