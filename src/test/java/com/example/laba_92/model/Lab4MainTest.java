package com.example.laba_92.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Lab4MainTest {

    Lab4Main main;
    public final static double EPS = 1e-2;
    @BeforeEach
    void setUp() {

        main = new Lab4Main();
    }

    @AfterEach
    void tearDown() {

    }

    @org.junit.jupiter.api.Test
    void tabulate() {

        double x1 = 0.2;
        double x2 = 2;
        double h = 0.004;
        List<Point> list = main.tabulate(x1,x2,h);
        double[][] expected = {{0.2,-2.66},{0.9,0.45},{2,1.4}};
        double[][] result = {{list.get(0).getX(),list.get(0).getY()},
                {list.get(175).getX(),list.get(175).getY()},{list.get(450).getX(),list.get(450).getY()}};
        assertArrayEquals(expected[0],result[0],EPS);
        assertArrayEquals(expected[1],result[1],EPS);
        assertArrayEquals(expected[2],result[2],EPS);
    }

}