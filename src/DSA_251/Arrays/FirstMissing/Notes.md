### Question
- You are given an arr consisting of N integers. Your task is to find the first missing positive integer in linear time and constant space. 
- In other words, find the lowest positive integer that does not exist in the array. The array can have negative numbers as well

### Sample Input
    5
    3 2 -6 1 0
    5
    0 1 2 3 4

### Sample Output
    4
    5

### Solution
- Since, we need to find the first positive number, there is no use of checking the negative integers. Also, the numbers are present in the range of N.
- Create an array of N size, and a variable res=N+1, this is because if we can't find the first positive number in the range. So just return the N+1 number (as in test case 2)
- So, we traverse the array, and if the element is <= N & > 0, then mark -1 in its index, in our new array.
- In this way, all the positive elements that are present will be marked as -1.
- Now traverse the new array, and if any index does not have -1, mark res=i+1 & break out.

### Code
    public static int firstMissing(int[] arr, int n) {
        int []check = new int[n];
        int res = n+1;  

        //if all elements are present in the range then send the next element 
        to that of range for test case {0,1,2,3,4} ans=> 5

        for(int i=0; i<n; i++) {
            if( arr[i] <= n && arr[i] > 0 ) {
                check [arr[i]-1] = -1;
            }
        }

        for(int i=0; i<n; i++){
            if( check[i] != -1 ) {
                res = i+1;
                break;
            }
        }
        return res;	
	}


### Complexity
1. Time Complexity - O(2*N)
2. Space Complexity - O(N)