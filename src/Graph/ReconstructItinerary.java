package Graph;
//https://leetcode.com/problems/reconstruct-itinerary
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ReconstructItinerary {
    LinkedList<String > result;
    HashMap<String, LinkedList<String>> map;
    public List<String> findItinerary(List<List<String>> tickets){
        result=new LinkedList<>();
        map=new HashMap<>();

        for (List<String> t:tickets){
            //taking out the source from each pair
            String src=t.get(0);
            //putting it in the map if it's not already present
            map.putIfAbsent(src, new LinkedList<>());
            //adding the destination to the particular source
            map.get(src).add(t.get(1));
        }
        //sorting the destinations in lexical order
        map.forEach((key,value)-> Collections.sort(value));
        String start="JFK";
        findItineraryDFS(start);
        return result;
    }
    private void findItineraryDFS(String start){
        if (map.containsKey(start)){
            //taking the list of destinations for a particular source
            LinkedList<String> desList=map.get(start);
            while (!desList.isEmpty()){
                //taking the first destination of particular source and doing dfs traversal in it
                String destination=desList.pollFirst();
                findItineraryDFS(destination);
            }
        }
        //just add jfk i.e. start src to the result
        result.offerFirst(start);
    }
}
