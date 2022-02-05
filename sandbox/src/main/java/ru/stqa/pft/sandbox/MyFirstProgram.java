package ru.stqa.pft.sandbox;

public class MyFirstProgram{

  public static void main (String[] args){
    hello("world");

    double len = 5;
    System.out.printf("Площадь квадарата со стороной " + len + " = " + area(len));
  }

  public static void hello(String somebody){
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double l){
    return l * l;
  }
}