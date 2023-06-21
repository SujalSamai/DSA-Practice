package Graph;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses,int[][] prerequisites){
        HashMap<Integer, List<Integer>> adjList=new HashMap<>();
        int[] topo=new int[numCourses];
        int[] indegree=new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int post = prerequisites[i][0];
            int pre = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(pre, new ArrayList<Integer>());
            lst.add(post);
            adjList.put(pre, lst);

            indegree[post] += 1;
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
            if (adjList.containsKey(node)){
                for (Integer it: adjList.get(node)){
                    indegree[it]--;
                    if (indegree[it]==0){
                        q.add(it);
                    }
                }
            }
        }
        if(count==numCourses){
            return topo;
        }
        return new int[0];
    }
}
