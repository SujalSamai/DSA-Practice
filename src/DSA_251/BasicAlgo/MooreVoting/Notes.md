### Question
- You are given an array consisting of N integers. Your task is to find the majority element in the array. If there is no majority element present, return -1.

### Sample Input
    5
    2 3 9 2 2
    4
    8 5 1 9

### Sample Output
    2
    -1

### Solution
- We traverse the array, if count=0, set the current element as candidate
- If next element == candidate, count++, else count--
- the dissimilar elements will cancel out each other
- only the majority one won't be canceled, & thus it'll be returned as answer
- next we will again traverse the array and check if the element choosen as answer is in majority or not

### Code
    public static int findMajority(int[] arr, int n) {
		 int count=0;
        int candidate=0;
        for (int i=0; i< n; i++){
            if(count==0) {
                candidate = arr[i];
                count++;
            }
            else if(arr[i]==candidate){
                count+=1;
            }else {
                count-=1;
            }
        }

        int count1=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==candidate){
                count1++;
            }
        }
        return count1++ > n/2 ? candidate : -1;
	}


### Complexity
1. Time Complexity - O(2*N)
2. Space Complexity - O(1)