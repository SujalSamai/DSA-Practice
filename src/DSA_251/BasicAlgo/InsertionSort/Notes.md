### Question
- You are given an unsorted array consisting of N non-negative integers. Your task is to sort the array in non-decreasing order using Insertion Sort Algorithm.

### Sample Input
    5
    6 2 8 4 10
    4
    4 3 2 1

### Sample Output
    2 4 6 8 10
    1 2 3 4

### Solution
- left side is already sorted, we will check at right side, and add it to appropriate position on left side
- start traversing from 1 to n, if the prev element is greater than current element, then keep on shifting the current element to left side till it reaches its correct position

### Code
    public static void insertionSort(int n , int[] arr) {
		for (int i = 1; i < n; i++) {
            int key= arr[i];
            int j= i-1;

            // Compare key with each element on the left of it until an element smaller than it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j>=0 && key<arr[j]){
                arr[j+1]= arr[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            arr[j+1] = key;
		}
	}


### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(1)