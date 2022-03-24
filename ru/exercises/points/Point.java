package ru.exercises.points;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Point {
    public static int maxPointOnLine(List<Point> points) {
        int maxPoints = 0;
        for (int i = 0; i < points.size(); i++) {
            int local=0, overlap=1, vertical=1;
            HashMap<Double, Integer> m =  new HashMap<>();
            for (int j = i+1; j < points.size(); j++) {
                if (points.get(i).x == points.get(j).x && points.get(i).y == points.get(j).y) {
                    overlap++;
                } else if(points.get(i).x == points.get(j).x ) {
                    vertical++;
                } else {
                    Double slope = (points.get(i).y - points.get(j).y)/(points.get(i).x - points.get(j).x);
                    m.put(slope, m.get(slope)+1);
                }
            }
            for (Double s: m.keySet() ) {
                local  = Math.max(m.get(s), local);
            }
            maxPoints = Math.max(vertical, Math.max(local+overlap, maxPoints));
        }
        return maxPoints;
    }

    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 && Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

