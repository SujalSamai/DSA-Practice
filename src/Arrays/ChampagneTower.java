package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass){
        if(poured==0) return 0;

        List<Double> prevRow = new ArrayList<>(List.of((double)poured));

        while(query_row-- > 0){
            List<Double> currRow = new ArrayList<>();
            double champagneInEnds = Math.max(0, (prevRow.get(0)-1)/2);
            currRow.add(champagneInEnds);   //first glass

            for (int i = 1; i < prevRow.size(); i++) {
                currRow.add(Math.max(0, (prevRow.get(i-1) -1)/2) + Math.max(0, (prevRow.get(i)-1)/2)); //flow from top-left & top-right glass
            }
            currRow.add(champagneInEnds);   //last glass
            prevRow=currRow;
        }
        return Math.min(1, prevRow.get(query_glass));   ////max champagne in a glass can be 1
    }
}
