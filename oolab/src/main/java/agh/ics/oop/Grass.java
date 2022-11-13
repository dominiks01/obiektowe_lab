package agh.ics.oop;

public class Grass extends IMapElement{

    Grass(Vector2d grassPosition){
        super(grassPosition);
    };

    public String toString(){
        return "*";
    }
}
