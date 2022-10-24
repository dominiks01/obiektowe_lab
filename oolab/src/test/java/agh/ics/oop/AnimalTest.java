package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeTest;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {

    @Test @BeforeTest
    public void optionsParserEquals(){
        String[][] testingString = {
                {"r", "b",".....", "b", "--", "b"},
                {"ala", "ma", "kota"},
                {"b", "f", "forward", "foward"},
                {"FORWARD", "Back", "b", "F"}
        };

        MoveDirection[][] expected = {
                {MoveDirection.RIGHT, MoveDirection.BACKWARD, MoveDirection.BACKWARD, MoveDirection.BACKWARD},
                {},
                {MoveDirection.BACKWARD, MoveDirection.FORWARD, MoveDirection.FORWARD},
                {MoveDirection.BACKWARD}
        };

        Assertions.assertAll(
                ()->assertTrue(Objects.deepEquals(expected[0], OptionsParser.parse(testingString[0]))),
                ()->assertTrue(Objects.deepEquals(expected[1], OptionsParser.parse(testingString[1]))),
                ()->assertTrue(Objects.deepEquals(expected[2], OptionsParser.parse(testingString[2]))),
                ()->assertTrue(Objects.deepEquals(expected[3], OptionsParser.parse(testingString[3])))
        );

    }

    @Test
    public void orientationTest(){
        Animal testingAnimal = new Animal();
        Vector2d startingPosition = new Vector2d(2,2);
        MapDirection startingOrientation = MapDirection.NORTH;

        assertEquals(startingPosition.toString()+" "+startingOrientation.toString(),testingAnimal.toString());

        testingAnimal.move(MoveDirection.RIGHT);
        assertEquals(startingPosition.toString()+" "+MapDirection.EAST.toString(),testingAnimal.toString());

        testingAnimal.move(MoveDirection.RIGHT);
        assertEquals(startingPosition.toString()+" "+MapDirection.SOUTH.toString(),testingAnimal.toString());

    }

    @Test
    public void positionShouldBeTrue(){
        String[][] testing_pos = {
                {"r", "b", "b", "WrongOne", "left", "forward", "f"},
                {"f", "back", "f", "cała naprzód!", "f", "f"},
                {"b", "b", ":DDDD", "f", "forward"},
                {"r", "r", "l", "r"}};

        Vector2d[] expectedPosition = {
                new Vector2d(0, 4),
                new Vector2d(2, 4),
                new Vector2d(2, 2),
                new Vector2d(2, 2)
        };

        Animal[] testAnimals = {
            new Animal(),
            new Animal(),
            new Animal(),
            new Animal()
        };

        for(int i = 0; i < 4; ++i){
            for(MoveDirection mv:OptionsParser.parse(testing_pos[i])){
                testAnimals[i].move(mv);
            }
        }

        Assertions.assertAll(
                ()->assertTrue(testAnimals[0].isAt(expectedPosition[0])),
                ()->assertTrue(testAnimals[1].isAt(expectedPosition[1])),
                ()->assertTrue(testAnimals[2].isAt(expectedPosition[2])),
                ()->assertTrue(testAnimals[3].isAt(expectedPosition[3]))
        );
    }

    @Test
    public void testBordersTrue() {
        Animal animal_01 = new Animal();
        Animal animal_02 = new Animal();
        Animal animal_03 = new Animal();

        Vector2d topRight = new Vector2d(4, 4);
        Vector2d bottomLeft = new Vector2d(0, 0);

        Vector2d vector3test = new Vector2d(2, 4);

        for (int i = 0; i < 10; ++i) {
            animal_01.move(MoveDirection.FORWARD);
            animal_01.move(MoveDirection.RIGHT);
            animal_01.move(MoveDirection.FORWARD);
            animal_01.move(MoveDirection.LEFT);

            animal_02.move(MoveDirection.BACKWARD);
            animal_02.move(MoveDirection.RIGHT);
            animal_02.move(MoveDirection.BACKWARD);
            animal_02.move(MoveDirection.LEFT);

            animal_03.move(MoveDirection.FORWARD);

        }

        assertTrue(animal_01.isAt(topRight));
        assertTrue(animal_02.isAt(bottomLeft));
        assertTrue(animal_03.isAt(vector3test));

    }
}