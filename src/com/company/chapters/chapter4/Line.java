package com.company.chapters.chapter4;


import com.company.chapters.chapter2.Point;

public class Line extends Shape{
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return new Point((from.getX() + to.getX())/2, (from.getY() + to.getY())/2);
    }

    @Override
    public String toString() {
        return "Line{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
}
