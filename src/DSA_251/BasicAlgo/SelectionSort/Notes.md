### Question
- You are given an unsorted array consisting of N non-negative integers. Your task is to sort the array in non-decreasing order using Selection Sort Algorithm.

### Sample Input
    5
    6 2 8 4 10
    4
    4 3 2 1

### Sample Output
    2 4 6 8 10
    1 2 3 4

### Solution
- traverse the array, at each iteration, search for the minimum element in the array
- swap it with the current element

### Code
    public static void selectionSort(int arr[], int n) {
		for (int i = 0; i < n - 1; i++) {
            int min = i;
            //finding the minimum element in the array
            for (int j = i+1; j < n; j++) {
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            
            //if minimum element found, swap it with the current index
            int temp= arr[i];
            arr[i]= arr[min];
            arr[min]=temp;
        }
	}


### Complexity
1. Time Complexity - O(N^2)
2. Space Complexity - O(1)