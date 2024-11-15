package priorityQueue.leetCode;

public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {

        return 0;
    }

    public static void main(String[] args) {
        MaximumSubsequenceScore maximumSubsequenceScore = new MaximumSubsequenceScore();
        System.out.println(maximumSubsequenceScore.maxScore(new int[]{2, 4, 5, 8, 10}, new int[]{4, 6, 8, 9}, 3));
        System.out.println(maximumSubsequenceScore.maxScore(new int[]{1, 3, 5, 7, 9}, new int[]{3, 5, 100}, 3));
        System.out.println(maximumSubsequenceScore.maxScore(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10}, 3));
        System.out.println(maximumSubsequenceScore.maxScore(new int[]{1, 2, 3}, new int[]{4, 5, 6}, 3));
    }
}
