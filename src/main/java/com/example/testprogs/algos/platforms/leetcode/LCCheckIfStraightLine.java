package com.example.testprogs.algos.platforms.leetcode;

import java.awt.*;
import java.util.ArrayList;

public class LCCheckIfStraightLine {

    //given a list of points find if its on a straight line

    public boolean solve(ArrayList<Point> points){
        if(points.size() <= 2) {
            return true;
        }
        for (int i = 2; i < points.size(); i++) {
            //here we use the slope formula (x1-x0)/(y1-y0) = (x2-x0)/(y2-y0) for a straight line

            int xi0 = points.get(i).x - points.get(0).x;
            int yi0 = points.get(i).y - points.get(0).y;
            int x10 = points.get(1).x - points.get(0).x;
            int y10 = points.get(1).x - points.get(0).x;
            if(xi0 * y10 != x10 * yi0) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1,2));
        points.add(new Point(2,3));
        points.add(new Point(3,4));
        points.add(new Point(4,5));
        points.add(new Point(5,6));
        points.add(new Point(6,7));
        LCCheckIfStraightLine checkIfStraightLine = new LCCheckIfStraightLine();
        System.out.println(checkIfStraightLine.solve(points));
    }
}
