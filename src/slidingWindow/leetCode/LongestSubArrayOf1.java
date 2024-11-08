package slidingWindow.leetCode;

/**
 * LeetCode 1493. Longest Subarray of 1's After Deleting One Element
 */
public class LongestSubArrayOf1 {

    public int longestSubarray(int[] nums) {
        int ans = 0;
        int left = 0;
        int zeroes = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroes++;
                // zeroes > 1이라면 left++해서 val을 옮긴 다음에 val == 0이면 zeroes--를 한다.
                while (zeroes > 1) {
                    int val = nums[left++];
                    if (val == 0) {
                        zeroes--;
                    }
                }
            }
            ans = Math.max(ans, i - left);
        }
        return ans;
    }

    /**
     * 더 좋은 성능을 가진 정답
     */
    public int longestSubarray2(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int n = nums.length;
        int used = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (used < 0) {
                    used = i;
                } else {
                    int length = i - left - 1;
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    left = used + 1;
                    used = i;
                }
            }
        }
        int length = n - left - 1;
        if (length > maxLength) {
            maxLength = length;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubArrayOf1 longestSubArrayOf1 = new LongestSubArrayOf1();
        int[] nums = {1, 1, 0, 1};
        nums = new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1};
        nums = new int[]{1, 1, 1};
        System.out.println(longestSubArrayOf1.longestSubarray(nums));
    }
}
