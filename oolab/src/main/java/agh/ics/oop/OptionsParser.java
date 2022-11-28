package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] stringToDirection){
        MoveDirection[] resultArray = new MoveDirection[stringToDirection.length];
        int i = 0;

        for(String argument: stringToDirection){
             MoveDirection move =  switch (argument){
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "l", "left" -> MoveDirection.LEFT;
                case "r", "right" ->  MoveDirection.RIGHT;
                 default -> null;
            };
            if(move == null)  throw new IllegalArgumentException("Argument " + argument + " is not legal move specification");
            else {
                resultArray[i] = move;
                i += 1;
            }

        }
        return Arrays.copyOfRange(resultArray, 0, i);
    }
}
