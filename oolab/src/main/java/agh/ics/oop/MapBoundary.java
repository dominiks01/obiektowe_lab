package agh.ics.oop;

import java.util.Comparator;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private TreeSet<Vector2d> horizontal = new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d i1, Vector2d i2) {
            if(i1.x == i2.x){
                return i1.y - i2.y;
            }
            return i1.x - i2.x;
        }
    });

    private TreeSet<Vector2d> vertical = new TreeSet<Vector2d>(new Comparator<Vector2d>() {
        @Override
        public int compare(Vector2d i1, Vector2d i2){
            if(i1.y == i2.y){
                return i1.x - i2.x;
            }
            return i1.y - i2.y;
        }
    });
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
            this.horizontal.remove(oldPosition);
            this.horizontal.add(newPosition);

            this.vertical.remove(oldPosition);
            this.vertical.add(newPosition);
    }

    public void addPosition(Vector2d position){
        horizontal.add(position);
        vertical.add(position);
    }

    public Vector2d getLeftBottom() {
        if(horizontal.size() == 0 || this.vertical.size() == 0)
            return new Vector2d(0,0);
        return new Vector2d(this.horizontal.first().x, this.vertical.first().y);
    }

    public Vector2d getTopRight() {
        if(horizontal.size() == 0 || this.vertical.size() == 0)
            return new Vector2d(0,0);
        return new Vector2d(this.horizontal.last().x, this.vertical.last().y);
    }
}