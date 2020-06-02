package com.example.testprogs.algos.ds.heap;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KNeartestPointsToOrigin {

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public Pair[] solve(int k ,Pair[] points) {
        Pair[] res = new Pair[k];

        //we make a max heap
        PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (int) - ((Math.sqrt(Math.pow(o1.x, 2) + Math.pow(o1.y, 2)) - Math.sqrt(Math.pow(o2.x, 2) + Math.pow(o2.y, 2))));
            }
        });

        for(Pair point : points) {

            //for each point, add to max heap
            maxHeap.add(point);
            if(maxHeap.size() > k) {
                //the max value will be on top and will be popped
                maxHeap.poll();
            }
        }

        return maxHeap.toArray(res);

    }
    public static void main(String[] args) {

//        Finding the points closest to the origin i.e 0,0
        Pair[] points = new Pair[4];
        points[0] = new Pair(1,3);
        points[1] = new Pair(-2,2);
        points[2] = new Pair(5,8);
        points[3] = new Pair(0,1);

        //we need two closet points to origin
        int k = 2;

//        Basically the distance from one point to the other is sqrt( ( x1^2 - x2^2 ) + (y1^2 - y2^2) )
//        But is x2,y2 = origin = 0,0
//        formula from origin becomes
//         sqrt( x1^2 + y1^2 )
//
//        Min heap, but we need max heap as we need the min numbers in the bottom,  we will use max heap in the solve
//        PriorityQueue<Point> minHeap = new PriorityQueue<>(new Comparator<Point>() {
//            @Override
//            public int compare(Point o1, Point o2) {
//                return  (int) (Math.sqrt(Math.pow(o1.x,2)+Math.pow(o1.y,2)) - Math.sqrt(Math.pow(o2.x,2)+Math.pow(o2.y,2)));
//            }
//        });

        KNeartestPointsToOrigin kn = new KNeartestPointsToOrigin();
        Pair[] res = kn.solve(k,points);
        System.out.println(Arrays.toString(res));
    }
}
