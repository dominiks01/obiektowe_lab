package agh.ics.oop;
import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    public int height;
    public int width;
    public List<Animal> animals = new ArrayList<>();
    private static final Vector2d bottomLeft = new Vector2d(0,0);
    private static Vector2d topRight;

    public RectangularMap(int height, int width){
        this.height = height;
        this.width = width;

        topRight = new Vector2d(width, height);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) &&
                position.follows(bottomLeft) &&
                position.precedes(topRight);
    }

    @Override
    public boolean place(Animal animal) {
        if(!isOccupied(animal.getPosition()) &&
                animal.getPosition().follows(bottomLeft) &&
                animal.getPosition().precedes(topRight)){
            animals.add(animal);
            return true;
        }

        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal actualAnimal : animals){
            if(position.equals(actualAnimal.getPosition())){
                return true;
            }
        }
        return false;
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
        MapVisualizer mv = new MapVisualizer(this);
        return mv.draw(bottomLeft, topRight);
    }
}
