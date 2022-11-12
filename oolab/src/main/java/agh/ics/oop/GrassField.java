package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField implements IWorldMap{

    public List<Grass> grass;

    GrassField(int numberOfGrasses){
        this.grass = new ArrayList<>(numberOfGrasses);
        Random random = new Random();

        for(int i = 0; i < numberOfGrasses; ++i){
            Vector2d newPosition = new Vector2d(random.ints((long) Math.sqrt(numberOfGrasses*10)).sum(),
                    random.ints((long) Math.sqrt(numberOfGrasses*10)).sum());
        }


    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        return null;
    }
}
