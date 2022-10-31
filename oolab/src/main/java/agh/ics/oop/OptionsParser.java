package agh.ics.oop;

import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] stringToDirection){
        MoveDirection[] resultArray = new MoveDirection[stringToDirection.length];
        int i = 0;

        for(String argument: stringToDirection){
            switch (argument){
                case "f", "forward" -> resultArray[i++] = MoveDirection.FORWARD;
                case "b", "backward" -> resultArray[i++] = MoveDirection.BACKWARD;
                case "l", "left" -> resultArray[i++] = MoveDirection.LEFT;
                case "r", "right" -> resultArray[i++] = MoveDirection.RIGHT;
            }
        }
        return Arrays.copyOfRange(resultArray, 0, i);
    }
}
