package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap {
    //protected List<IMapElement> objects = new ArrayList<>();
    private final MapVisualizer mv = new MapVisualizer(this);

    protected Map<Vector2d, IMapElement> objects = new HashMap<>();
    public AbstractWorldMap() {
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position)!=null);
    };

    @Override
    public boolean place(Animal animal) {
        if (!(objects.get(animal.getPosition()) instanceof Animal))
        {
            objects.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }

    public String toString(){
        return mv.draw(getBottomLeft(), getTopRight());
    }

    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public Object objectAt(Vector2d position){
        return objects.get(position);
    }

    public abstract Vector2d getBottomLeft();

    public abstract Vector2d getTopRight();


}
