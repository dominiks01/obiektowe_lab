package agh.ics.oop;

import static java.lang.Math.abs;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    private static final MapDirection[] val = values();

    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    };

    public MapDirection next(){
        return val[(this.ordinal()+1)%val.length];
    };

    public MapDirection previous(){
        return val[abs(val.length + this.ordinal()-1)%val.length];
    };

    public Vector2d toUnitVector(){
        return switch (this){
            case NORTH -> new Vector2d(0, 1);
            case SOUTH -> new Vector2d(0, -1);
            case WEST -> new Vector2d(-1, 0);
            case EAST -> new Vector2d(1, 0);
        };
    }
}
