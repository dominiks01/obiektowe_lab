package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap{

//    private List<Grass> grass = new ArrayList<>();
    private final MapVisualizer mv = new MapVisualizer(this);


    GrassField(int numberOfGrasses){
        super(0, 0);
        Random random = new Random();

        for(int i = 0; i < numberOfGrasses; ++i){

            Vector2d newPosition = new Vector2d((int)(Math.random()*(Math.sqrt(10*numberOfGrasses)+1)),
                                                (int)(Math.random()*(Math.sqrt(10*numberOfGrasses)+1)));

            while (!canMoveTo(newPosition)){
               newPosition = new Vector2d((int)(Math.random()*(Math.sqrt(10*numberOfGrasses)+1)),
                        (int)(Math.random()*(Math.sqrt(10*numberOfGrasses)+1)));
            }

            super.objects.add(new Grass(newPosition));
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) || objectAt(position) instanceof Grass;
    }


    @Override
    public Object objectAt(Vector2d position) {
        for(Animal actualAnimal : animals){
            if(position.equals(actualAnimal.getPosition())){
                return actualAnimal;
            }
        }

        for(IMapElement grassObject : super.objects){
            if(position.equals(grassObject.getPosition())){
                return grassObject;
            }
        }
        return null;
    }

    public String toString(){
        Vector2d bottomLeft = new Vector2d(0,0);
        Vector2d topRight = new Vector2d(0,0);

        for(Animal i: animals){
            topRight = topRight.upperRight(i.getPosition());
            bottomLeft = bottomLeft.lowerLeft(i.getPosition());
        }

        for(IMapElement i: super.objects){
            topRight = topRight.upperRight(i.getPosition());
            bottomLeft = bottomLeft.lowerLeft(i.getPosition());
        }

        return mv.draw(bottomLeft, topRight);
    }

}
