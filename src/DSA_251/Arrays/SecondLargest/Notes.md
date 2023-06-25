### Question
- You have been given an array of integers, your task is to find the second largest element present in the array.
- Note that duplicate elements may be present 

### Sample Input
    6
    12 1 35 10 34 1
    5
    10 10 10 10 10
    6
    7 8 8 1 4 3

### Sample Output
    34
    -1
    7

### Solution
- Create two variable, max & secondMax
- Traverse the array, if element > max, then mark secondMax=max, and max=element
- else if element > secondMax but not equal to max, then secondMax = element

### Code
    public static int findSecondLargest(int n, int[] arr) {
		int maxi=Integer.MIN_VALUE;
		int secondMax= Integer.MIN_VALUE;
	
		for(int i=0; i<n; i++){
			if(arr[i]>maxi){
				secondMax= maxi;
				maxi=arr[i];
			}else if(arr[i]>secondMax && arr[i]!= maxi){
				secondMax= arr[i];
			}
		}
		if(secondMax == Integer.MIN_VALUE) return -1;
		else return secondMax;
	}


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)