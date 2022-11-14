package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends IMapElement {
    private MapDirection orientation;
    private MapDirection direction = MapDirection.NORTH;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.orientation = MapDirection.NORTH;
        this.map = map;
    }

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observers.remove(observer);
    }

    public String toString(){
        return switch (this.orientation){
            case NORTH -> "N";
            case EAST ->  "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    public void move(MoveDirection direction){
        if(direction.equals(MoveDirection.FORWARD) || direction.equals(MoveDirection.BACKWARD)){

            Vector2d newPosition = super.position;

            if(map.canMoveTo(newPosition.add(this.orientation.toUnitVector()))){
                newPosition = (direction.equals(MoveDirection.FORWARD))?
                        newPosition.add(this.orientation.toUnitVector()):
                        newPosition.subtract(this.orientation.toUnitVector());
            }
            this.positionChanged(super.position, newPosition);
            super.position = newPosition;
        } else {
            this.orientation = (direction.equals(MoveDirection.LEFT))?
                    this.orientation.previous():
                    this.orientation.next();
        }
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : this.observers)
            observer.positionChanged(oldPosition, newPosition);
    }

}
