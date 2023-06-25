### Question
- Given an array with N elements, the task is to rotate the array to left by K steps, where K is non negative

### Sample Input
    7 5 2 11 2 43 1 1
    2

### Sample Output
    2 11 2 43 1 1 7 5

### Solution
- Reverse first k elements
- Then reverse k+1 to n elements
- At last, reverse the whole array

### Code
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        reverse(a, 0, k-1);
        reverse(a, k, n-1);
        reverse(a, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
    }

    static void reverse(int[] arr, int start, int end){
        while (start<end){
            int temp= arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
    }


### Complexity
1. Time Complexity - O(N)
2. Space Complexity - O(1)