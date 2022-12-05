package agh.ics.oop;

public class Animal extends IMapElement {
    private MapDirection orientation;
    private final IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        super(initialPosition);
        this.orientation = MapDirection.NORTH;
        this.map = map;
    }

    public Animal(IWorldMap map){
        this(map, new Vector2d(2,2));
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

    public void move(MoveDirection direction) throws InterruptedException {
        if(direction.equals(MoveDirection.FORWARD) || direction.equals(MoveDirection.BACKWARD)){

            Vector2d newPosition = super.position;

            if(map.canMoveTo(newPosition.add(this.orientation.toUnitVector()))){
                newPosition = (direction.equals(MoveDirection.FORWARD))?
                        newPosition.add(this.orientation.toUnitVector()):
                        newPosition.subtract(this.orientation.toUnitVector());
            }
            notifyObservers(super.position, newPosition);
            super.position = newPosition;
        } else {
            this.orientation = (direction.equals(MoveDirection.LEFT))?
                    this.orientation.previous():
                    this.orientation.next();
        }

    }

}
