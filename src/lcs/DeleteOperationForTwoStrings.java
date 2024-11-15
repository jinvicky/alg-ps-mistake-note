package lcs;

/**
 * LeetCode 583. Delete Operation for Two Strings
 *
 * [회고]
 * dp를 풀다보면 LCS를 요구하는 문제가 나온다. LCS는 2차원 DP 배열을 요구한다.
 *
 * [참고]
 * 이론 - https://velog.io/@emplam27/알고리즘-그림으로-알아보는-LCS-알고리즘-Longest-Common-Substring와-Longest-Common-Subsequence
 * 구현 - https://st-lab.tistory.com/139
 *
 * 꼭 +1 길이의 배열을 생성해서 0 패딩을 깔아준다.
 *
 * [시행착오]
 * gcd 알고리즘은 실제로 오직 부분 문자열로만 이루어져 있어야 해서 실패
 */
public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int maxCommonLength = minDistance2(word1, word2);
        /**
         * leetcode와 etco의 경우는 s2가 s1에 완전에 포함되어서 관계가 없는데
         * eat과 sea의 경우는 공통이 아닌 문자열 연산도 있어서 아래와 같이 길이를 더하고 공통 길이를 뺐다.
         */
        return word1.length() + word2.length() - maxCommonLength - maxCommonLength;
    }

    public int minDistance2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        System.out.println(deleteOperationForTwoStrings.minDistance("leetcode", "etco"));
    }
}
