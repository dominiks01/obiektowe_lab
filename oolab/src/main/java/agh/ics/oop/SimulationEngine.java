package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final List<Animal> animals = new ArrayList<>();
    private final MoveDirection[] moves;

    private IWorldMap map;

    private boolean checkAnimal(Animal checkAnimal){

        for(Animal i: animals){
            if(i.equals(checkAnimal)){
                return true;
            }
        }
        return false;
    }

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startingPositions){

        this.moves = moves;

        if(startingPositions != null) {
            for (Vector2d start : startingPositions) {
                if(map.canMoveTo(start)) {
                    Animal new_a = new Animal(map, start);
                    animals.add(new_a);
                    map.place(new_a);
                }
                else if(!checkAnimal((Animal) map.objectAt(start))){
                    animals.add((Animal) map.objectAt(start));
                }
            }
        }
    }

    @Override
    public void run() {
        int i = 0;
        for(MoveDirection mv : this.moves){
            animals.get(i++%(animals.size())).move(mv);

        }
    }
}
