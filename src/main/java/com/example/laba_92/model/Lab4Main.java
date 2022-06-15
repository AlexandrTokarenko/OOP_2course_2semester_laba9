package com.example.laba_92.model;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;
import static java.lang.Math.sin;

public class Lab4Main {
    public final static double EPS = 1e-6;

    public double t = 2.2;

    public static void main(String[] args) {

        new Lab4Main().run();
    }

    private void run() {

    }

    public List<Point> tabulate(double a, double b, double h) {

        List<Point> res = new ArrayList<>();
        for (int i = 0; i < countSteps(a,b,h); i++) {
            double x = a + i * h;
            double y = f(x);
            res.add(new Point(x,y));
        }
        return res;
    }

    public double f(double x) {

        if((x - 0.9) < EPS) return (log(x)*log(x)*log(x)+x*x)/sqrt(x+t);
        else return cos(x)+t*sin(x)*sin(x);
    }

    public int countSteps(double start, double finish, double step) {

        return (int)Math.round((finish - start)/step) + 1;
    }

    public int maxIndex(List<Point> arr) {

        int ind = 0;
        double min = arr.get(0).getY();
        for (int i = 1; i < arr.size(); i++) {
            if (min < arr.get(i).getY()) {
                min = arr.get(i).getY();
                ind = i;
            }
        }
        return ind;
    }

    public int minIndex(List<Point> arr) {

        int ind = 0;
        double min = arr.get(0).getY();
        for (int i = 1; i < arr.size(); i++) {
            if (min > arr.get(i).getY()) {
                min = arr.get(i).getY();
                ind = i;
            }
        }
        return ind;
    }

    public double sum(List<Point> arr) {

        double result = 0;
        for (Point point : arr) {
            result += point.getY();
        }
        return result;
    }

    public double average(List<Point> arr) {

        return sum(arr)/arr.size();
    }
}
