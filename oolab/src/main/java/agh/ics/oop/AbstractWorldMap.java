package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    private final MapVisualizer mv = new MapVisualizer(this);
    protected Map<Vector2d, IMapElement> objects = new HashMap<>();
//    protected List<IPositionChangeObserver> observers = new ArrayList<>();

    @Override
    public boolean isOccupied(Vector2d position) {
        return (objectAt(position)!=null);
    }

    public String toString(){
        return mv.draw(getBottomLeft(), getTopRight());
    }
    @Override
    public abstract boolean canMoveTo(Vector2d position);

    @Override
    public Object objectAt(Vector2d position){
        return this.objects.get(position);
    }

    public abstract Vector2d getBottomLeft();

    public abstract Vector2d getTopRight();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement animal = this.objects.get(oldPosition);
        this.objects.remove(oldPosition);
        this.objects.put(newPosition, animal);
    }

}
