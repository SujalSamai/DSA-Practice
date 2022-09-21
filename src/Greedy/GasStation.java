package Greedy;
//https://leetcode.com/problems/gas-station/
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas,cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0, totalCost=0, total=0, res=0;
        for (int i = 0; i < gas.length; i++) {
            totalGas+=gas[i];
            totalCost+=cost[i];
        }
        if (totalCost> totalGas) return -1;

        for (int i = 0; i < gas.length; i++) {
            total+=gas[i]-cost[i];
            if (total<0){
                total=0;
                res=i+1;
            }
        }
        return res;
    }
}
