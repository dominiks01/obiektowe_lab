package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testng.asserts.Assertion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Vector2dTest {

    @Test
    public void addShouldBeEqual() {
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertEquals(vector03, vector01.add(vector02)),
                ()->assertEquals(vector01, vector01.add(vector04)),
                ()->assertEquals(vector02, vector02.add(vector04))
        );
    }

    @Test
    public void addShouldNotBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertNotEquals(vector04, vector01.add(vector02)),
                ()->assertNotEquals(vector04, vector01.add(vector04)),
                ()->assertNotEquals(vector04, vector02.add(vector04)),
                ()->assertNotEquals(vector03, vector02.add(vector04))
        );
    }

    @Test
    public void precedesShouldBeTrue(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertTrue(vector04.precedes(vector03)),
                ()->assertTrue(vector01.precedes(vector03)),
                ()->assertTrue(vector01.precedes(vector01)),
                ()->assertTrue(vector02.precedes(vector03))
        );
    }

    @Test
    public void precedesShouldBeFalse(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertFalse(vector01.precedes(vector02)),
                ()->assertFalse(vector03.precedes(vector04)),
                ()->assertFalse(vector03.precedes(vector01)),
                ()->assertFalse(vector02.precedes(vector04))
        );
    }

    @Test
    public void shouldBeEqual(){
        Vector2d vector01 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertTrue(vector01.equals(vector01)),
                ()->assertTrue(vector01.equals(new Vector2d(0, 0))),
                ()->assertTrue(new Vector2d(1,1).equals(new Vector2d(1,1)))
        );
    }

    @Test
    public void shouldNotBeEqual(){
        Vector2d vector02 = new Vector2d(1, 1);

        Assertions.assertAll(
                ()->assertFalse(vector02.equals(new Vector2d(0, 0))),
                ()->assertFalse(new Vector2d(1,1).equals(new Vector2d(1,0)))
        );
    }

    @Test
    public void followsShouldBeTrue(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertTrue(vector02.follows(vector04)),
                ()->assertTrue(vector02.follows(vector02)),
                ()->assertTrue(vector03.follows(vector01)),
                ()->assertTrue(vector03.follows(vector04))
        );
    }

    @Test
    public void followsShouldBeFalse(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertFalse(vector01.follows(vector02)),
                ()->assertFalse(vector04.follows(vector03)),
                ()->assertFalse(vector02.follows(vector01)),
                ()->assertFalse(vector04.follows(vector02))
        );
    }

    @Test
    public void toStringShouldBeEqual(){
        Vector2d vector01 = new Vector2d(1, 1);

        Assertions.assertAll(
                ()->assertEquals(vector01.toString(), "(1,1)"),
                ()->assertEquals(new Vector2d(0,0).toString(), "(0,0)"),
                ()->assertEquals(new Vector2d(0,1).add(new Vector2d(1,0)).toString(), "(1,1)")
        )   ;
    }

    @Test
    public void toStringShouldNotBeEqual() {
        Vector2d vector01 = new Vector2d(1, 1);

        Assertions.assertAll(
                () -> assertNotEquals(vector01.toString(), "(1 ,1)"),
                () -> assertNotEquals(new Vector2d(0, 0).toString(), "(0,1)"),
                () -> assertNotEquals(new Vector2d(0, 1).add(new Vector2d(1, 0)).toString(), "(1.1)"),
                () -> assertNotEquals(vector01.toString(), "[0,1]"),
                () -> assertNotEquals(vector01.toString(), "(1, 1)")
        );
    }

    @Test
    public void upperRightShouldBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertEquals(vector01.upperRight(vector02), vector03),
                ()->assertEquals(vector03.upperRight(vector04), vector03),
                ()->assertEquals(new Vector2d(0,1).upperRight(new Vector2d(1,1)), new Vector2d(1,1))
        );
    }

    @Test
    public void upperRightShouldNotBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertNotEquals(vector01.upperRight(vector02), vector01),
                ()->assertNotEquals(vector03.upperRight(vector04), vector04),
                ()->assertNotEquals(new Vector2d(0,1).upperRight(new Vector2d(0,1)), new Vector2d(0,0)),
                ()->assertNotEquals(vector04.upperRight(vector04), vector01),
                ()->assertNotEquals(new Vector2d(0,1).upperRight(new Vector2d(0,1)), new Vector2d(1,1))
        );
    }

    @Test
    public void lowerLeftShouldBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertEquals(vector01.lowerLeft(vector02), vector04),
                ()->assertEquals(vector03.lowerLeft(vector04), vector04),
                ()->assertEquals(new Vector2d(0,1).lowerLeft(new Vector2d(1,1)), new Vector2d(0,1))
        );
    }

    @Test
    public void lowerLeftShouldNotBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertNotEquals(vector01.lowerLeft(vector02), vector01),
                ()->assertNotEquals(vector03.lowerLeft(vector04), vector02),
                ()->assertNotEquals(new Vector2d(0,1).lowerLeft(new Vector2d(0,1)), new Vector2d(0,0)),
                ()->assertNotEquals(vector04.lowerLeft(vector04), vector01),
                ()->assertNotEquals(new Vector2d(0,1).lowerLeft(new Vector2d(0,1)), new Vector2d(1,1))
        );
    }

    @Test
    public void subtractShouldBeEqual() {
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertEquals(vector02.subtract(vector02),vector04),
                ()->assertEquals(vector03.subtract(vector02),vector01),
                ()->assertEquals(vector03.subtract(vector03),vector04 )
        );
    }

    @Test
    public void subtractShouldNotBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector03 = new Vector2d(1, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertNotEquals(vector04, vector01.subtract(vector02)),
                ()->assertNotEquals(vector04, vector01.subtract(vector04)),
                ()->assertNotEquals(vector04, vector02.subtract(vector04)),
                ()->assertNotEquals(vector03, vector02.subtract(vector04))
        );
    }

    @Test
    public void oppositeShouldBeEqual(){
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertEquals(vector04, vector04.opposite()),
                ()->assertEquals(new Vector2d(0, -1), vector02.opposite())
        );
    }

    @Test
    public void oppositeShouldNotBeEqual(){
        Vector2d vector01 = new Vector2d(1, 0);
        Vector2d vector02 = new Vector2d(0, 1);
        Vector2d vector04 = new Vector2d(0, 0);

        Assertions.assertAll(
                ()->assertNotEquals(vector02, vector01.opposite()),
                ()->assertNotEquals(vector01, vector04.opposite())
                );
    }


}
