package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private static final Vector2d bottomLeft = new Vector2d(0,0);
    private static Vector2d topRight;

    public RectangularMap(int height, int width){
        topRight = new Vector2d(width, height);
    }

    //public MapBoundary boundary = new MapBoundary();

    @Override
    public boolean place(Animal animal) {
        System.out.println(animal.getPosition());
        System.out.println(canMoveTo(animal.getPosition()));
        if(canMoveTo(animal.getPosition())){
            objects.put(animal.getPosition(), animal);
            animal.addObserver(this);
            return true;
        }
        else throw new IllegalArgumentException();
    }

//    @Override
//    public boolean place(Animal animal) {
//    if (!(objects.get(animal.getPosition()) instanceof Animal))
//    {
//        objects.put(animal.getPosition(), animal);
//        animal.addObserver(this);
//        return true;
//    }
//        throw new IllegalArgumentException();
//}

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

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        return;
    }
}
