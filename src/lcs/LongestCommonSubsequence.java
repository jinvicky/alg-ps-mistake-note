package lcs;

/**
 * LeetCode 1143. Longest Common Subsequence
 *
 * [오답]
 * 초기화하겠다고 for문 쓰는 거 필요없음.
 * for (int i = 1; i <= t1; i++) {
 * //            dp[i][0] = text1.charAt(i);
 * //        }
 * //
 * //        for (int j = 1; j <= t2; j++) {
 * //            dp[0][j] = text2.charAt(j);
 * //        }
 *
 * [풀이]
 * **두 문자가 동일할 경우 : 나의 좌측 대각선 값의 +1
 * **두 문자가 다른 경우 : 왼쪽값과 위쪽값 중 max값
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int t1 = text1.length();
        int t2 = text2.length();
        int[][] dp = new int[t1 + 1][t2 + 1];

        // 이중 for문
        for (int i = 1; i <= t1; i++) {
            for (int j = 1; j <= t2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[t1][t2];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde", "ace"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abc", "def"));
    }
}
