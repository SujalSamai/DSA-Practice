### Question
- You are given an unsorted array consisting of N non-negative integers. Your task is to sort the array in non-decreasing order using Bubble Sort Algorithm.

### Sample Input
    5
    6 2 8 4 10
    4
    4 3 2 1

### Sample Output
    2 4 6 8 10
    1 2 3 4

### Solution
- traverse the loop, use another nested loop from i+1
- if the next element is greater than current element, swap them

### Code
    public static void bubbleSort(int[] arr, int n) {   
        //with each complete iteration, the lowest element goes to its correct position
        for (int i = 0; i < n ; i++) {
            for (int j = i+1; j < n ; j++) {
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(1)