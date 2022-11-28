package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Grass extends IMapElement{

    private List<IPositionChangeObserver> observerList = new ArrayList<IPositionChangeObserver>();
    Grass(Vector2d grassPosition){
        super(grassPosition);
    };

    public String toString(){
        return "*";
    }

}
