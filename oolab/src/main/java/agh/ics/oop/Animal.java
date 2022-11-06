package agh.ics.oop;

public class Animal {
    private MapDirection orientation;
    private Vector2d position;
    public IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.orientation = MapDirection.NORTH;
        this.position = initialPosition;
        this.map = map;
    }

    public Animal(IWorldMap map){
        this.orientation = MapDirection.NORTH;
        this.position = new Vector2d(2,2);
        this.map = map;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return switch (this.orientation){
            case NORTH -> "N";
            case EAST ->  "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction){
        if(direction.equals(MoveDirection.FORWARD) || direction.equals(MoveDirection.BACKWARD)){

            if(map.canMoveTo(this.position.add(this.orientation.toUnitVector()))){
                this.position = (direction.equals(MoveDirection.FORWARD))?
                        this.position.add(this.orientation.toUnitVector()):
                        this.position.subtract(this.orientation.toUnitVector());
            }
        } else {
            this.orientation = (direction.equals(MoveDirection.LEFT))?
                    this.orientation.previous():
                    this.orientation.next();
        }
    }
}
