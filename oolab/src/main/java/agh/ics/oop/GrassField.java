package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private MapBoundary boundary = new MapBoundary();

    @Override
    public boolean place(Animal animal) {
        if (!(objects.get(animal.getPosition()) instanceof Animal))
        {
            objects.put(animal.getPosition(), animal);
            animal.addObserver(this);
            animal.addObserver(boundary);
            return true;
        }
        throw new IllegalArgumentException();
    }

    int numberOfGrasses;
    private Vector2d getRandomVector(int n){
        return new Vector2d((int)(Math.random()*(Math.sqrt(10*n)+1)),
                (int)(Math.random()*(Math.sqrt(10*n)+1)));
    }

    public GrassField(int numberOfGrasses){
        this.numberOfGrasses = numberOfGrasses;
        Random random = new Random();

        for(int i = 0; i < numberOfGrasses; ++i){

            Vector2d newPosition = getRandomVector(numberOfGrasses+1);

            while (objects.containsKey(newPosition)){
               newPosition = getRandomVector(numberOfGrasses+1);
            }

            Grass newGrass = new Grass(newPosition);
            newGrass.addObserver(this);
            newGrass.addObserver(boundary);
            super.positionChanged(null, newPosition);
            super.objects.put(newPosition, newGrass);
            boundary.addPosition(newPosition);
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(objectAt(position) instanceof Grass){

            Vector2d newPosition = getRandomVector(numberOfGrasses+1);

            while (!canMoveTo(newPosition) || position.equals(newPosition)){
                newPosition = getRandomVector(numberOfGrasses+1);
            }

            Grass newGrass = new Grass(newPosition);
            newGrass.addObserver(this);
            newGrass.addObserver(boundary);
            super.positionChanged(position, newPosition);
            super.objects.put(newPosition, newGrass);
            boundary.addPosition(newPosition);

//            Grass newGrass = new Grass(newPosition);
//            super.positionChanged(position, newPosition);
//            boundary.positionChanged(position, newPosition);

            return true;
        }
        return (!isOccupied(position));
    };

    public Vector2d getBottomLeft(){
        return boundary.getLeftBottom();
    }

    public Vector2d getTopRight(){
        return boundary.getTopRight();
    }


}
