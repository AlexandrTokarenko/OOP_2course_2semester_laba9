package com.example.laba_92.table;

import com.example.laba_92.model.Point;

public class PointDTO extends Point {

    public PointDTO(double x, double y) {
        super(x, y);
    }
    public String getXStr() {
        return String.format("%5.3f", getX());
    }

    public String getYStr() {
        return String.format("%5.3f", getY());
    }
}
