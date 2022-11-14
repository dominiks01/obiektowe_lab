package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private static final Vector2d bottomLeft = new Vector2d(0,0);
    private static Vector2d topRight;

    public RectangularMap(int height, int width){
        topRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) &&
                position.follows(bottomLeft) &&
                position.precedes(topRight);
    }

    public Vector2d getBottomLeft(){
        return bottomLeft;
    }

    public Vector2d getTopRight(){
        return topRight;
    }
}
