package com.example.laba_92.model;

import javafx.beans.property.SimpleDoubleProperty;

public class Point {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double value) {
        x = value;
    }

    public double getY() {
        return y;
    }

    public void setY(double value) {
        y = value;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
