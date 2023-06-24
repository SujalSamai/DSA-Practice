package DSA_251.BasicAlgo;

public class VotingAlgo {
    public static int findMajority(int[] arr, int n) {
        int count=0;
        int candidate=0;
        //We traverse the array, if count=0, set the current element as candidate
        //If next element == candidate, count++, else count--
        //the dissimilar elements will cancel out each other
        //only the majority one won't be canceled, & thus it'll be returned as answer

        //here we will get the desired candidate
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

        //now we are checking if the desired candidate is present for more than n/2 times
        int count1=0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==candidate){
                count1++;
            }
        }
        return count1++ > n/2 ? candidate : -1;
    }
}
