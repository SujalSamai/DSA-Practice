package Graph;
//https://leetcode.com/problems/course-schedule
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    //If there is a deadLock i.e. a cycle is present then we can't finish all courses
    //so just detect a cycle in directed graph
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] topo=new int[numCourses];
        int[] indegree=new int[numCourses];

        for (int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] i:prerequisites){
            adj.get(i[0]).add(i[1]);
        }

        for (int[] arr:prerequisites ){
            indegree[arr[1]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for (int i=0; i<numCourses; i++){
            if (indegree[i]==0){
                q.add(i);
            }
        }

        int count=0, index=0;
        while (!q.isEmpty()){
            Integer node=q.poll();
            topo[index++]=node;
            count++;
            //getting neighbour nodes of popped node and decreasing their indegree by 1
            for (Integer it: adj.get(node)){
                indegree[it]--;
                if (indegree[it]==0){
                    q.add(it);
                }
            }
        }
        return count==numCourses;
    }
}
