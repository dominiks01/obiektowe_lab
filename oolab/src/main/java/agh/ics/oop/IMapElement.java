package agh.ics.oop;

abstract public class IMapElement {
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

}
