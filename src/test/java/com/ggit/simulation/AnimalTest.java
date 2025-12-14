package com.ggit.simulation;

import com.ggit.json.SimulationParams;
import org.junit.jupiter.api.Test;

public class AnimalTest {

    WorldMap map = new AnimalsEnclosure(new SimulationParams(3,3,2,4,30,15));


    @Test
    void testAnimalMoving(){
        Animal animal = new Animal(new Vector2D(0,0), 30);
        animal.move(MapDirection.SOUTH, map);
        assert animal.getPosition().x()==0;
        assert animal.getPosition().y()==2;

    }
}
