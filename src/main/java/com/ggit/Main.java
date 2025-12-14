package com.ggit;

import com.ggit.json.JsonParser;
import com.ggit.json.SimulationParams;
import com.ggit.simulation.Simulation;
import com.ggit.gui.SimulatorFrame;

import javax.swing.*;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //private static Random random = new Random();
   /* private static int mapSize=100;
    private static final int nrDays=10;*/
    //private static final int noOfPlant=40;
    //private static final int noOfAnimals=60;

    public static void main(String[] args) {
       /* int noOfDays= args.length>0? Integer.parseInt(args[0]): nrDays;
        //SimulationParams config = JsonParser.readConfig();
        /*Animal animal=new Animal(new Vector2D(random.nextInt(mapSize), random.nextInt(mapSize)));
        System.out.println("Animal created at position "+animal.getPosition());*/
        /*Simulation simulation = new Simulation(JsonParser.readConfig());
        for (int i = 0; i < noOfDays; i++) {
            System.out.println("Day "+i);
            simulation.simulateDay(i);
        }*/
        /*for (String arg: args) {
            System.out.println(arg);
        }*/
        SwingUtilities.invokeLater(SimulatorFrame::new);
    }
}

