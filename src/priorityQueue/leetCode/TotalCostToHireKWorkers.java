package priorityQueue.leetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * LeetCode 2462. Total Cost to Hire K Workers
 * <p>
 * [회고]
 * 우선순위 큐를 활용하는 문제인데 너무 어려워서 며칠 헤매다 포기.
 */
public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        int l = 0;
        int r = n - 1;

        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 0; i < candidates; i++) {
            if (l <= r) {
                pq1.add(costs[l++]);
            }

            // 위에서 l++ 여부에 따라서 아래가 추가되므로 if문을 합칠 수 없다.
            if (l <= r) {
                pq2.add(costs[r--]);
            }
        }
        long cost = 0;

        for(int i = 0; i < k; i++) {
            if(!pq1.isEmpty() && (pq2.isEmpty() || pq1.peek() <= pq2.peek())) {
                cost+=pq1.poll();
                if(l<=r) {
                    pq1.add(costs[l++]);
                }
            } else {
                cost+=pq2.poll();
                if(l<=r) {
                    pq2.add(costs[r--]);
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        TotalCostToHireKWorkers totalCostToHireKWorkers = new TotalCostToHireKWorkers();
        int[] costs = {10, 20, 5};
        int k = 2;
        int candidates = 3;
        System.out.println(totalCostToHireKWorkers.totalCost(costs, k, candidates));
    }
}
