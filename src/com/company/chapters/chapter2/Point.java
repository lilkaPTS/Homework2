package com.company.chapters.chapter2;

import java.util.Objects;

/**
 * Implement an immutable class Point that describes a point in the plane.
 * Provide a constructor to set it to a specific point, a no-arg constructor to
 * set it to the origin, and methods getX, getY, translate, and scale. The translate
 * method moves the point by a given amount in x- and y-direction. The
 * scale method scales both coordinates by a given factor. Implement these
 * methods so that they return new points with the results.
 */
public class Point {

    private double x = 0.0;
    private double y = 0.0;

    /**
     * Empty constructor set x = 0.0, y = 0.0
     */
    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     *
     * @param dX delta x
     * @param dY delta y
     * @return new point with coordinates (x+dX, y+dY)
     */
    public Point translate(double dX, double dY) {
        return new Point(this.x+dX,this.y+dY);
    }

    /**
     *
     * @param multiplier factor
     * @return new point with coordinates (x*multiplier,y*multiplier)
     */
    public Point scale(double multiplier) {
        return new Point(this.x*multiplier, this.y*multiplier);
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

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
