package DSA_251.BinarySearch;

import java.util.ArrayList;

public class SingleElement {
    public static void main(String[] args) {
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(1);
        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(5);
        System.out.println(singleNonDuplicate(arr));
    }
    public static int singleNonDuplicate(ArrayList<Integer> arr){
        int n = arr.size();
        int low = 0, high = n - 1, mid;
        // Do binary search
        while (low < high) {
            // Calculate mid
            mid = (low + high) / 2;
            // Update low and high.
            if (mid % 2 == 1) {
                int a = arr.get(mid);
                int b = arr.get(mid - 1);
                if (a == b) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else if (mid % 2 == 0) {
                int a = arr.get(mid);
                int b = arr.get(mid + 1);
                if (a == b) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return arr.get(low);
    }
}
