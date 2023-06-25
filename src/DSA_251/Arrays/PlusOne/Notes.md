### Question
- You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's. 
- Increment the large integer by one and return the resulting array of digits.

### Sample Input
    [1,2,3]
    [4,3,2,1]
    [9]

### Sample Output
    [1,2,4]
    [4,3,2,2]
    [1,0]

### Solution
- traverse the array from the back
- now if the last digit is less than 9, just add one to the last digit and return the same array
- but, if the last digit is 9, then place 0 in that index
- create a new array of n+1 length, and add 1 to the first index of the new array.

### Code
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }

        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)