package agh.ics.oop;

import com.google.common.hash.HashCode;

import java.util.Objects;

public class Vector2d {
    public final int x, y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")";
    }

    public boolean precedes(Vector2d other){
        return this.x <= other.x && this.y <= other.y;
    }

    public boolean follows(Vector2d other){
        return this.x >= other.x && this.y >= other.y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d subtract(Vector2d other){
        return new Vector2d(this.x - other.x, this.y - other.y);
    }

    public Vector2d upperRight(Vector2d other){
        return new Vector2d(Integer.max(this.x, other.x), Integer.max(this.y, other.y));
    }

    public Vector2d lowerLeft(Vector2d other){
        return new Vector2d(Integer.min(this.x, other.x), Integer.min(this.y, other.y));
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

    public boolean equals(Object other){
        if(this == other)
            return true;
        if(!(other instanceof Vector2d that))
            return false;
        return that.x == this.x && that.y == this.y;
    }

    @Override
    public int hashCode() {
        final int p = 7;
        int result = p + Integer.hashCode(this.x);
        int temp;
        temp = Integer.hashCode(this.y);
        return p*result + (int)(temp ^ (temp >>>10));
    }
}