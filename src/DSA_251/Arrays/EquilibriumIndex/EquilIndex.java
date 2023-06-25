package DSA_251.Arrays.EquilibriumIndex;

public class EquilIndex {
    public static void main(String[] args) {
        int[] arr={0,0,0,0,0,0,0,0,0,0};
        System.out.println(arrayEquilibriumIndex(arr));
    }
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
}
