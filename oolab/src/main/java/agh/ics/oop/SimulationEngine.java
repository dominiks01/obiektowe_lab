package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final List<Animal> animals = new ArrayList<>();
    private final MoveDirection[] moves;

    private final List<IPositionChangeObserver> animalMoveObservers = new ArrayList<>();
    private final int moveDelay = 300;

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
                    Animal new_a = new Animal(map, start);
                    animals.add(new_a);
                    map.place(new_a);
            }
        }
    }



    @Override
    public void run() throws InterruptedException {
        int i = 0;
        for(MoveDirection mv : this.moves){
            animals.get(i++%(animals.size())).move(mv);
        }
    }

    public void addAnimalMoveObserver(IPositionChangeObserver animalMoveObserver) {
        this.animalMoveObservers.add(animalMoveObserver);
    }
}
