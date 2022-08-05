package Graph;
//https://leetcode.com/problems/network-delay-time
import java.util.Arrays;

public class NetworkDelayTime {
    // Bellman Ford ALgorithm
    // Time Complexity (n * t) | Space Complexity O(n) where t is the length of times
    public int networkDelayTime(int[][]times,int n,int k){
        int[] paths=new int[n];
        Arrays.fill(paths,Integer.MAX_VALUE);

        paths[k-1]=0;
        for (int i = 0; i < n; i++) {
            int[] temp=new int[n];
            temp=Arrays.copyOf(paths,paths.length);

            for (int j = 0; j < times.length; j++) {
                int src = times[j][0]; // source
                int tgt = times[j][1]; // target
                int time = times[j][2]; // time

                if (temp[src-1]!= Integer.MAX_VALUE && temp[src-1]+time<temp[tgt-1]){
                    temp[tgt-1]=temp[src-1]+time;
                }
            }
            paths=temp;
        }
        int res=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (paths[i]==Integer.MAX_VALUE){
                return -1;
            }
            res= Math.max(res,paths[i]);
        }
        return res;
    }
}
