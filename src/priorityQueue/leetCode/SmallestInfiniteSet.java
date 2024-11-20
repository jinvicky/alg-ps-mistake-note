package priorityQueue.leetCode;

import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * LeetCode 2336. Smallest Number in Infinite Set
 */
public class SmallestInfiniteSet {

    int[] arr;
    int ind;

    public SmallestInfiniteSet() {
        arr = new int[1001];
        ind = 1;
    }

    public int popSmallest() {
        while(arr[ind] == 1) {
            ind++;
        }
        arr[ind] = 1;
        return ind;
    }

    public void addBack(int num) {
        if(num < ind) {
            ind = num;
        }
        arr[num] = 0;
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(1);
        smallestInfiniteSet.addBack(2);
        smallestInfiniteSet.addBack(3);
        System.out.println(smallestInfiniteSet.popSmallest());
        System.out.println(smallestInfiniteSet.popSmallest());
        smallestInfiniteSet.addBack(2);
        System.out.println(smallestInfiniteSet.popSmallest());
    }
}

class SmallestInfiniteSetByPq {
    PriorityQueue<Integer> priorityQueue;
    boolean[] element_in_set;

    public SmallestInfiniteSetByPq() {
        priorityQueue = new PriorityQueue<>();
        element_in_set = new boolean[1000];
        for(int i = 0; i < 1000; i++) {
            element_in_set[i] = true;
        }
        priorityQueue.addAll(IntStream.rangeClosed(1, 1000).boxed().toList());
    }

    public int popSmallest() {
        element_in_set[priorityQueue.peek()-1] = false;
        return priorityQueue.poll();
    }

    public void addBack(int num) {
        if(!element_in_set[num-1]) {
            priorityQueue.add(num);
            element_in_set[num-1] = true;
        }
    }


}
