package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MapDirectionTest {

    @Test
    public void nextTestShouldBeEqual(){
        MapDirection east = MapDirection.EAST;
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        Assertions.assertAll(
                ()->assertEquals(MapDirection.EAST,north.next()),
                ()->assertEquals(MapDirection.SOUTH,east.next()),
                ()->assertEquals(MapDirection.WEST,south.next()),
                ()->assertEquals(MapDirection.NORTH,west.next())
        );
    }

    @Test
    public void prevTestShouldBeEqual(){
        MapDirection east = MapDirection.EAST;
        MapDirection north = MapDirection.NORTH;
        MapDirection south = MapDirection.SOUTH;
        MapDirection west = MapDirection.WEST;

        Assertions.assertAll(
                ()->assertEquals(MapDirection.EAST,south.previous()),
                ()->assertEquals(MapDirection.NORTH,east.previous()),
                ()->assertEquals(MapDirection.WEST,north.previous()),
                ()->assertEquals(MapDirection.SOUTH,west.previous())
        );
    }

}
