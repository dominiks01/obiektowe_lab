package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
    @Test
   public void mapAnimalsEngine(){
       IWorldMap map = new RectangularMap(10, 10);

       Vector2d[] expectedPosition = {  new Vector2d(2,6),
                                        new Vector2d(4,5),
                                        new Vector2d(8,4),
                                        new Vector2d(10,6)};

       String[] arguments = {"r", "r", "r", "r", "f", "f", "r", "f", "r", "l", "f", "f", "f", "f", "f", "f", "f", "f",
                            "f", "f", "f", "f", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
       MoveDirection[] directions = new OptionsParser().parse(arguments);

       Animal[] animals = { new Animal(map, new Vector2d(2, 9)),
                            new Animal(map, new Vector2d(2, 3)),
                            new Animal(map, new Vector2d(8, 9)),
                            new Animal(map,  new Vector2d(5, 6))};

       for(Animal animal: animals)
           map.place(animal);

       IEngine testEngine = new SimulationEngine(directions, map, null);
       testEngine.run();

       Assertions.assertAll(    ()-> assertEquals(animals[0], map.objectAt(expectedPosition[0])),
                                ()-> assertEquals(animals[1], map.objectAt(expectedPosition[1])),
                                ()-> assertEquals(animals[2], map.objectAt(expectedPosition[2])),
                                ()-> assertEquals(animals[3], map.objectAt(expectedPosition[3]))
       );

   }
}