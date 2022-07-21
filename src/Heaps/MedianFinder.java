package Heaps;

import java.util.PriorityQueue;

public class MedianFinder {
    //maxHeap will contain elements smaller than or equal to median
    //minHeap will contain elements greater than median or equal to median
    //both of them will have almost similar size except when number of elements is odd, maxHeap will contain the median too
    private PriorityQueue<Integer> smallHeap; //small elements - maxHeap
    private PriorityQueue<Integer> largeHeap; //large elements - minHeap

    public MedianFinder(){
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num){
        //add the number initially to smallHeap
        smallHeap.add(num);

        //if size of smallheap is not approx. equal to largeheap or if largeHeap is not empty but element of smallHeap is > largeHeap
        //remove the element from smallheap and put it into largeheap
        if(smallHeap.size()-largeHeap.size()>1 || (!largeHeap.isEmpty() && smallHeap.peek()> largeHeap.peek())){
            largeHeap.add(smallHeap.poll());
        }

        //if size of largeheap is not approx. equal to smallheap, remove element from largeHeap and add to smallHeap
        if (largeHeap.size()- smallHeap.size()>1){
            smallHeap.add(largeHeap.poll());
        }
    }

    public double findMedian(){
        if(smallHeap.size()==largeHeap.size()){
            return (double) (largeHeap.peek()+smallHeap.peek())/2;
        }else if(smallHeap.size()>largeHeap.size()){
            return (double) smallHeap.peek();
        }else {
            return (double) largeHeap.peek();
        }
    }
}
