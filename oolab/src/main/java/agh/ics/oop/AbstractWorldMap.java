package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected List<IMapElement> objects = new ArrayList<>();
    private int width;
    private int height;

    public AbstractWorldMap(int height, int width) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position)!=null);
    };

    @Override
    public boolean place(Animal animal) {
        if(canMoveTo(animal.getPosition()))
        {
            animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public abstract Object objectAt(Vector2d position);

    public abstract String toString();

}
