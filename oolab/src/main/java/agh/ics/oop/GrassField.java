package agh.ics.oop;

import java.util.Random;

public class GrassField extends AbstractWorldMap{

    private Vector2d getRandomVector(int n){
        return new Vector2d((int)(Math.random()*(Math.sqrt(10*n)+1)),
                (int)(Math.random()*(Math.sqrt(10*n)+1)));
    }

    GrassField(int numberOfGrasses){
        Random random = new Random();

        for(int i = 0; i < numberOfGrasses; ++i){

            Vector2d newPosition = getRandomVector(numberOfGrasses+1);

            while (!canMoveTo(newPosition)){
               newPosition = getRandomVector(numberOfGrasses+1);
            }

            super.objects.put(newPosition,new Grass(newPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(objectAt(position) instanceof Grass){

            int grassLength = super.objects.size();

            Vector2d newPosition = getRandomVector(grassLength+1);

            while (!canMoveTo(newPosition) || position.equals(newPosition)){
                newPosition = getRandomVector(grassLength+1);
            }

            super.objects.remove(objectAt(position));
            super.objects.put(newPosition, new Grass(newPosition));

        }
        return !isOccupied(position);
    }

    public Vector2d getBottomLeft(){
        Vector2d bottomLeft = new Vector2d(0,0);

        for(IMapElement i : super.objects.values()){
            bottomLeft = bottomLeft.lowerLeft(i.getPosition());
        }

        return bottomLeft;
    }

    public Vector2d getTopRight(){
        Vector2d topRight = new Vector2d(0,0);

        for(IMapElement i : super.objects.values()){
            topRight = topRight.upperRight(i.getPosition());
        }

        return topRight;
    }

}
