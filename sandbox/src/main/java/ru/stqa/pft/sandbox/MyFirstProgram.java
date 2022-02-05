package ru.stqa.pft.sandbox;

public class MyFirstProgram{

  public static void main (String[] args){
    hello("world");


    Square s = new Square(5);
    System.out.println("Площадь квадарата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(5, 10);
    System.out.println("Площадь прямоугольника = " + r.area());

  }

  public static void hello(String somebody){
    System.out.println("Hello, " + somebody + "!");
  }


}