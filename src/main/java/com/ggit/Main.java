package com.ggit;

import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static Random random = new Random();
    private static int mapSize=100;

    public static void main(String[] args) {
        Animal animal=new Animal(new Vector2D(random.nextInt(mapSize), random.nextInt(mapSize)));
        System.out.println("Animal created at position "+animal.getPosition());
    }
}

