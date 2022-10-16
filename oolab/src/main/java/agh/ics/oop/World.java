package agh.ics.oop;

import java.util.Arrays;

public class World {
    public static void main(String[] args){
        System.out.print("Start\n");
        run(string_to_enum(args));
        System.out.print("Stop\n");
    }

    public static Directions[] string_to_enum(String[]args){
        Directions[] result_array;
        result_array = new Directions[args.length];
        int i = 0;

        for(String argument: args){
            switch (argument) {
                case "f" -> result_array[i++] = Directions.FORWARD;
                case "b" -> result_array[i++] = Directions.BACKWARD;
                case "l" -> result_array[i++] = Directions.LEFT;
                case "r" -> result_array[i++] = Directions.RIGHT;
                default -> {
                }
            }
        }
        return Arrays.copyOfRange(result_array, 0, i);
    }
    private static void run(Directions[] direction_array) {
        for(Directions argument: direction_array) {
            String message = "Zwierzak idzie " + switch (argument) {
                case FORWARD -> "do przodu\n";
                case BACKWARD -> "do tyłu\n";
                case LEFT -> "w prawo\n";
                case RIGHT -> "w lewo\n";
            };
            System.out.print(message);
        }
    }
}
