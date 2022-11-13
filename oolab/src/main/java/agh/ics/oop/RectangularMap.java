package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    public int height;
    public int width;
    private static final Vector2d bottomLeft = new Vector2d(0,0);
    private static Vector2d topRight;
    private MapVisualizer mv = new MapVisualizer(this);


    public RectangularMap(int height, int width){
        super(height, width);

        topRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) &&
                position.follows(bottomLeft) &&
                position.precedes(topRight);
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal actualAnimal : animals){
            if(position.equals(actualAnimal.getPosition())){
                return actualAnimal;
            }
        }
        return null;
    }

    public String toString(){
        return mv.draw(bottomLeft, topRight);
    }
}
