### Question
- You are given an arr consisting of N integers. You need to find the equilibrium index of the array.
- An index is considered to be equilibrium index if the sum of the elements of the array to the left of the index is equal to the sum of elements to right of it.

### Sample Input
    6
    1 7 3 6 5 6
    6
    1 2 2 9 3 2
    4
    1 2 3 4

### Sample Output
    3
    3
    -1

### Solution
- Get the sum of all elements present in the array & store it in a variable
- Now again traverse and add each element one by one in a new variable
- At each iteration check if the totalsum - (prevsum + arr[i]) is equal to prevsum
- if it's true, return the index

### Code
    public static int arrayEquilibriumIndex(int[] arr){
        if(arr.length==1) return arr[0];
        int totalSum=0;
        for (int i = 0; i < arr.length; i++) {
            totalSum+= arr[i];
        }

        int prevSum=0;
        for (int i = 0; i < arr.length; i++) {
            int curSum= totalSum- (prevSum + arr[i]);
            if(curSum == prevSum){
                return i;
            }
            prevSum+=arr[i];
        }
        return -1;
	}

### Edge Cases
- If the length of the array is 1, then just return the first element

### Complexity
1. Time Complexity - O(2*N)
2. Space Complexity - O(1)