package dp.leetCode;

/**
 * LeetCode 72. Edit Distance
 *
 * [풀이]
 * 최대 경로 구하는 공식과 같다. 그냥 외워라.
 * 처음에 두 문자열 셋팅을 한다. 이 부분도 최대 경로를 구할 때 세로 0번째들과 가로 0번째들을 셋팅하는 것과 같다.
 * ***나 자신의 왼쪽 대각선, 왼쪽, 위쪽 중 최솟값 + 1이다.***
 * ***여유 길이+1을 해야 한다.***
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        final int m = word1.length();
        final int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for(int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(editDistance.minDistance(word1, word2));
    }
}
