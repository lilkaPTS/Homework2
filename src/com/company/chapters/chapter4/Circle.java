package com.company.chapters.chapter4;

import com.company.chapters.chapter2.Point;

public class Circle extends Shape{
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return this.center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

}
