package com.company.chapters.chapter4;

import com.company.chapters.chapter2.Point;

public abstract class Shape {
    public abstract Point getCenter();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
