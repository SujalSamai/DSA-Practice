package Trie;

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

class Nodee{
    Nodee[] links=new Nodee[2];
    Nodee(){}
    boolean containsKey(int n){
        return links[n]!=null;
    }
    void put(int n, Nodee node){
        links[n]=node;
    }
    Nodee get(int n){
        return links[n];
    }
}

class Triee{
    Nodee root;
    Triee(){
        root=new Nodee();
    }
    void insert(int n){
        Nodee node=root;
        for (int i = 31; i >=0 ; i--) {
            int bit=(n&(1<<i))==0?1:0;
            if (node.containsKey(bit)){
                node.put(bit, new Nodee());
            }
            node=node.get(bit);
        }
    }

    int getMax(int n){
        Nodee node=root;
        int res=0;
        for (int i = 31; i >=0 ; i--) {
            int reqBit=(n&(1<<i))==0?1:0;
            if (node.containsKey(reqBit)){
                res|=(1<<i);
                node=node.get(reqBit);
            }else{
                node=node.get(1-reqBit);
            }
        }
        return res;
    }
}
public class MaxXORofTwoNum {
    public int findMaximumXOR(int[] nums) {
        Triee t=new Triee();
        for (int num : nums) {
            t.insert(num);
        }
        int maxi=0;
        for (int num : nums) {
            maxi = Math.max(maxi, t.getMax(num));
        }
        return maxi;
    }
}
