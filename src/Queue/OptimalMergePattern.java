package Queue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class OptimalMergePattern {
    static int minComputation(int size, int files[]) {
        // create a min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            pq.add(files[i]);
        }

        int count = 0;

        while (pq.size() > 1) {
            int temp = pq.poll() + pq.poll();
            count += temp;

            pq.add(temp);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number of files: ");
        int size= sc.nextInt();
        // 6 files with their sizes
        int files[] = new int[size];
        System.out.print("Enter the file sizes: ");
        for (int i = 0; i < size; i++) {
            files[i]=sc.nextInt();
        }

        System.out.println("Minimum Computations = "
                + minComputation(size, files));
    }
}
