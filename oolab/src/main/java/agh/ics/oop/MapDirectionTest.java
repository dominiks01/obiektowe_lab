package agh.ics.oop;

import org.testng.annotations.Test;

public class MapDirectionTest {
    @Test
    public static void main(){
        MapDirection testVar = MapDirection.NORTH;
        for(int i = 0; i < 4; ++i){
            System.out.println(testVar.next());
            testVar = testVar.next();
        }

        System.out.print("\n");

        testVar = MapDirection.NORTH;
        for(int i = 0; i < 4; ++i){
            System.out.println(testVar.previous());
            testVar = testVar.previous();
        }
    }
}
