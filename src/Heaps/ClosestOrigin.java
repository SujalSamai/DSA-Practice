package Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ClosestOrigin {
    class Pair{
        int key;
        int[] value;

        public Pair(int key, int[] value) {
            this.key = key;
            this.value = value;
        }

    }

    public int[][] kClosest(int[][]points, int k){
        PriorityQueue<Pair> pq= new PriorityQueue<Pair>((a,b)->a.key-b.key);

        for (int[] point: points){
            int dist=(int)(Math.pow(point[0],2)+ Math.pow(point[1],2));
            pq.add(new Pair(dist,point));
        }

        int[][] res= new int[k][2];
        for (int i=0; i<k; i++){
            int[] closest=pq.poll().value;
            res[i]=closest;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = {
                {1,3},
                {-2,2}
        };
        int k = 1;
        ClosestOrigin c= new ClosestOrigin();
        System.out.println(Arrays.deepToString(c.kClosest(points,k)));
    }
}
