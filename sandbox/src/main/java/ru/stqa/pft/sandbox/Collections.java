package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
        String[] lang = {"Java","C#","Pyton","PHP"};

        //List<String> languages = new ArrayList<String>();
        //languages.add("Java");
        //languages.add("C#");
        //languages.add("Pyton");
        //languages.add("PHP");

        List<String> languages = Arrays.asList("Java","C#","Pyton","PHP");

        for (String l : languages){
            System.out.println("Я хочу выучить " + l);
        }
    }
}
