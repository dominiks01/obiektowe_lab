package agh.ics.oop;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal(){
        orientation = MapDirection.NORTH;
        position = new Vector2d(2,2);
    }

    public String toString(){
        return position.toString()+" "+ orientation.toString();
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    private boolean isValidMove(MoveDirection direction){

        Vector2d actual_position = this.position;
        Vector2d topRightBorder = new Vector2d(4,4);
        Vector2d bottomLeftBorder = new Vector2d(0, 0);

        actual_position = switch (direction){
            case FORWARD -> actual_position.add(this.orientation.toUnitVector());
            case BACKWARD -> actual_position.subtract(this.orientation.toUnitVector());
            default -> actual_position;
        };

        return actual_position.follows(bottomLeftBorder) && actual_position.precedes(topRightBorder);

    }

    public void move(MoveDirection direction){
        if (isValidMove(direction)) {
            switch (direction) {
                case RIGHT -> this.orientation = this.orientation.next();
                case LEFT -> this.orientation = this.orientation.previous();
                case FORWARD -> this.position = this.position.add(this.orientation.toUnitVector());
                case BACKWARD ->this.position = this.position.subtract(this.orientation.toUnitVector());
            }
        }
    }
}
