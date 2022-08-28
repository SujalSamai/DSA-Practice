package Greedy;
//https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Meeting{
    int start;
    int end;
    int pos;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class MeetingComparator implements Comparator<Meeting>{
    @Override  //returns -1 when no changes required, returns 1 when we need to swap places
    public int compare(Meeting o1, Meeting o2){
        if (o1.end<o2.end){
            return -1;
        }else if(o1.end>o2.end){
            return 1;
        }else if(o1.pos<o2.end){
            return -1;
        }
        return 1;
    }
}

public class NMeetings {
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meet=new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meet.add(new Meeting(start[i],end[i],i+1));
        }
        MeetingComparator mc=new MeetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer=new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit= meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start>limit){
                limit=meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        return answer.size();
    }

    public static int maxMeetings2(int start[], int end[], int n) {
        // add your code here
        Pair arr[] = new Pair[n];
        for(int i=0; i<n; i++){
            arr[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(arr, (p1, p2) -> p1.e - p2.e);

        int res = 1, pre = 0;

        for(int cur = 1; cur<n; cur++){
            if(arr[cur].s > arr[pre].e){
                res++;
                pre = cur;
            }
        }

        return res;
    }

    private static class Pair{
        int s, e;
        Pair(int st, int en){
            s = st;
            e = en;
        }
    }

    public static void main(String args[]) {
        int n = 6;
        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,5,7,9,9};
        System.out.println(maxMeetings(start,end,n));

    }
}
