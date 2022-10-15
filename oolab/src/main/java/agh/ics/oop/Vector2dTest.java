package agh.ics.oop;

import org.testng.annotations.Test;

public class Vector2dTest {
    @Test
    public static void main() {
        Vector2d vector_01 = new Vector2d(1, 1);
        Vector2d vector_02 = new Vector2d(2, 2);

        System.out.println("Vector01 : " + vector_01.toString() + ", Vector02 : " + vector_02.toString());

        System.out.println("equals(): " + vector_01.equals(vector_02));
        System.out.println("toString(): " + vector_01.toString());
        System.out.println("follows(): " + vector_01.follows(vector_02));
        System.out.println("precedes(): " + vector_01.precedes(vector_02));
        System.out.println("upperRight(): " + vector_01.upperRight(vector_02));
        System.out.println("lowerLeft(): " + vector_01.lowerLeft(vector_02));
        System.out.println("add(): " + vector_01.add(vector_02));
        System.out.println("subtract(): " + vector_01.subtract(vector_02));
        System.out.println("opposite(): " + vector_01.opposite());

    }
}
