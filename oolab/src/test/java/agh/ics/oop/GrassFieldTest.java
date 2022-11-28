package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import javax.swing.*;
import javax.swing.text.html.Option;

import java.util.Arrays;
public class GrassFieldTest {
    @Test
    public void mapAnimalsEngine(){
        IWorldMap map = new GrassField(5);

        Vector2d[] startingPosition = {  new Vector2d(2,9),
                new Vector2d(2,3),
                new Vector2d(8,9),
                new Vector2d(5,6)};

        Animal[] animals = {
                new Animal(map, startingPosition[0]),
                new Animal(map, startingPosition[1]),
                new Animal(map, startingPosition[2]),
                new Animal(map, startingPosition[3])};

        Vector2d[] expectedPosition = {  new Vector2d(2,6),
                new Vector2d(4,5),
                new Vector2d(8,4),
                new Vector2d(12,6)};

        String[] arguments = {"r", "r", "r", "r", "f", "f", "r", "f", "r", "l", "f", "f", "f", "f", "f", "f", "f", "f",
                "f", "f", "f", "f", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(arguments);

        for(Animal i : animals){
            map.place(i);
        }

        IEngine testEngine = new SimulationEngine(directions, map, startingPosition);
        testEngine.run();

        System.out.println(map.toString());

                Assertions.assertAll(    ()-> assertEquals(map.objectAt(expectedPosition[0]), animals[0]),
                        ()-> assertEquals(map.objectAt(expectedPosition[1]), animals[1]),
                        ()-> assertEquals(map.objectAt(expectedPosition[2]), animals[2]),
                        ()-> assertEquals(map.objectAt(expectedPosition[3]), animals[3])
                );

    }


    @Test
    public void mapAnimalsEngineSecondTest(){
        IWorldMap map = new GrassField(10);

        Vector2d[] expectedPosition = {
                new Vector2d(6,8),
                new Vector2d(8,5)
        };

        Vector2d[] startingPosition = {
                new Vector2d(4,4),
                new Vector2d(10,11),
        };

        Animal[] animals = {
                new Animal(map, startingPosition[0]),
                new Animal(map, startingPosition[1])
        };

        String[] arguments = {"f", "r", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f","l", "f", "f", "f", "f", "r", "l", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(arguments);

        for(Animal i : animals){
            map.place(i);
        }

        IEngine testEngine = new SimulationEngine(directions, map, startingPosition);
        testEngine.run();

        System.out.println(map.toString());

        Assertions.assertAll(    ()-> assertEquals(map.objectAt(expectedPosition[0]), animals[0]),
                ()-> assertEquals(map.objectAt(expectedPosition[1]), animals[1]));

    }};
