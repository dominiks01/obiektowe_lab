package agh.ics.oop;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(this.getPosition());
    }

}
