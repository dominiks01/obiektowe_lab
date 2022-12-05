package agh.ics.oop.gui;

import agh.ics.oop.*;

import java.util.ArrayList;
import java.util.List;

public class ResetSimulationEngine implements IEngine, Runnable{
    private MoveDirection[] moves;
    private IWorldMap map;
    private final List<Animal> animals = new ArrayList<>();
    private int moveDelay;
    private List<IMapChangeObserver> observers = new ArrayList<>();

    public ResetSimulationEngine(IWorldMap map,Vector2d[] startingPositions) {

        this.map = map;
        this.moveDelay = 500;

        if(startingPositions != null) {
            for (Vector2d start : startingPositions) {
                Animal new_a = new Animal(map, start);
                animals.add(new_a);
                map.place(new_a);
            }
        }
    }

    public ResetSimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] starting_pos) {
        this(map, starting_pos);
        this.moves = moves;
    }

    @Override
    public void run() {
        try {
            int i = 0;
            for(MoveDirection mv : this.moves){
                animals.get(i++%(animals.size())).move(mv);
                mapReset();
                Thread.sleep(moveDelay);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted animal move!");
            System.exit(1);
        }
    }

    public void mapReset() {
        for (IMapChangeObserver observer : this.observers) {
            observer.reset();
        }
    }

    public void addObserver(IMapChangeObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IMapChangeObserver observer) {
        this.observers.remove(observer);
    }

    public void setMoves(MoveDirection[] directions) {
        this.moves = directions;
    }
}