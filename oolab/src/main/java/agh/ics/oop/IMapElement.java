package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract public class IMapElement{
    public List<IPositionChangeObserver> observers = new ArrayList<>();
    protected Vector2d position;

    public IMapElement(Vector2d initialPosition) {
        position = initialPosition;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    abstract public String toString();

    @Override
    public int hashCode() {
        return Objects.hash(this.getPosition());
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    protected void notifyObservers(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : this.observers)
            observer.positionChanged(oldPosition, newPosition);
    }


}
