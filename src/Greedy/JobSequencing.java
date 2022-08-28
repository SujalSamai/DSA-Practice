package Greedy;
//https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

import java.util.Arrays;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class JobSequencing {
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));

        int maxi=0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline>maxi){
                maxi=arr[i].deadline;
            }
        }
        int[] res=new int[maxi+1];
        for (int i = 1; i <= maxi; i++) {
            res[i]=-1;
        }
        int countJobs=0, jobProfit=0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j >0 ; j--) {
                if (res[j]==-1){
                    res[j]=i;
                    countJobs++;
                    jobProfit+=arr[i].profit;
                    break;
                }
            }
        }
        int [] ans=new int[2];
        ans[0]=countJobs;
        ans[1]=jobProfit;
        return ans;
    }
}
