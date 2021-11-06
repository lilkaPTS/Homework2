package com.company.chapters.chapter4;

import com.company.chapters.chapter2.Point;

public class Rectangle extends Shape{
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        return topLeft.translate(width/2, height/2);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topLeft=" + topLeft +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}
