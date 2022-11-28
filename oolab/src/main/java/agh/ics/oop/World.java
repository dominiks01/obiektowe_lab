
package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import javax.swing.*;
import javax.swing.text.html.Option;

import java.util.Arrays;

import static agh.ics.oop.Directions.*;
import static java.lang.System.exit;
public class World {
    public static void main(String[] args){
        try {
            Application.launch(App.class, args);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex);
            exit(0);
        }
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
