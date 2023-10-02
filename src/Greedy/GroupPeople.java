package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPeople {
    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        System.out.println(groupThePeople(groupSizes));
    }
    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> groupMap = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0; i<groupSizes.length; i++){
            int size = groupSizes[i];   //get the sizes given at each index
            groupMap.putIfAbsent(size, new ArrayList<>());  //if the current size is not in the map, add it with an empty list in map
            groupMap.get(size).add(i);  //add the current index to the list of current size in map like [3, {0,1,2,3,4,6}]

            if(groupMap.get(size).size() == size){      //whenever the list of current size's length is equal to current size
                result.add(new ArrayList<>(groupMap.get(size)));    //add the list to our result
                groupMap.get(size).clear(); //clear the list of current size
            }
        }
        return result;
    }
}
