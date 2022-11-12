package agh.ics.oop;

public class Grass {

    private final Vector2d position;

    Grass(Vector2d grassPosition){
        this.position = grassPosition;
    };

    Vector2d getPosition(){
        return this.position;
    };

    public String toString(){
        return "*";
    }
}
