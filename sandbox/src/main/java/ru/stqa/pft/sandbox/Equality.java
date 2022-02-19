package ru.stqa.pft.sandbox;

public class Equality {
    public static void main(String[] args) {
        String s1 = "FireFox";
        String s2 = "Fire" + "Fox";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}