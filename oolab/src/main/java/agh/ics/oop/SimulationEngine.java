package agh.ics.oop;

public class SimulationEngine implements IEngine{

    private final MoveDirection[] moves;
    private final RectangularMap map;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] startingPositions){

        this.moves = moves;
        this.map = (RectangularMap) map;

        if(startingPositions != null) {
            for (Vector2d start : startingPositions) {
                map.place(new Animal(map, start));
            }
        }
    }

    @Override
    public void run() {
        int i = 0;
        for(MoveDirection mv : this.moves){
           map.animals.get(i++%(map.animals.size())).move(mv);
        }
    }
}
