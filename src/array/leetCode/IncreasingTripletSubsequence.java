package array;

/**
 * LeetCode 334. Increasing Triplet Subsequence
 *
 * i < j < k를 주어진 배열이 만족하는 지 여부를 true/false로 표현
 *
 * 처음에 투 포인터 알고리즘으로 풀어서 테스트 케이스 절반 통과한 후 실패. (투 포인터 아님)
 * i < j < k를 만족하는 케이스는 여러 개일 수 있다. 관계없이 있으면 true
 *
 * 아직도 else if 해석 미숙함. if(false) + a임
 *
 * n이 들어오면 min1과 비교 -> 더 작으면 min1에 저장
 * min1보다 크면 min2와 비교 -> 더 작으면 min2에 저장
 * min2보다 크면 true 반환
 */
public class IncreasingTripletSubsequence {

    public boolean increasingTriplet(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n <= min1) {
                min1 = n;
            } else if (n <= min2) { // n <= min이 아니면서  + n <= min2인 경우
                min2 = n;
            } else {
                return true;
            }
        }
        return false;
    }
}
