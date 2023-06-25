### Question
- You are given an arr consisting of N integers. Write a solution to check if it could become non-decreasing by modifying at most 1 element.

### Sample Input
    3
    8 4 6
    3
    8 4 2
    6
    -2 7 -1 0 1 2
    5
    -10 10 0 10 3

### Sample Output
    true
    false
    true
    false

### Solution
- Since, we don't need to make any changes to the array, we just need to return whether we can get the answer by modifying the array, so we will just count the number of times, array is not non-decreasing.
- Traverse the array from first index, as first element is already sorted always, close the loop if count goes <= 1, as that means we need multiple modifications
- if the prev element > curr element, count++
- Also check if(i-2<0 || arr[i-2] <= arr[i])arr[i-1] = arr[i], else arr[i] = arr[i-1]
- This is to not count repetitive changes 

### Code
    public static boolean isPossible(int[] arr, int n) {
		int cnt = 0;          
        for(int i = 1; i < arr.length && cnt<=1 ; i++){
            if(arr[i-1] > arr[i]){
                cnt++;
                if(i-2<0 || arr[i-2] <= arr[i])arr[i-1] = arr[i];           
                else arr[i] = arr[i-1];                        
            }
        }
        return cnt<=1;
	}


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)