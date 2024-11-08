package bit.leetCode;


import java.util.Arrays;

/**
 * LeetCode 136. Single Number
 * <p>
 * [어려운점]
 * XOR 연산이 너무 생소했고, 정수끼리 ^했을 때 결과값이 예상과 달랐다.
 * boolean XOR 연산과 헷갈렸음. (그냥 0 또는 1인줄 알았음)
 * <p>
 * [핵심]
 * XOR 연산은 교환법칙, 결합법칙이 성립하며, 항등원은 0이다.
 * 같으면 0을 반환하고 다르면 둘이 다르면 0이 아닌 값을 그대로 반환한다.
 * <p>
 * 0 xor 0 xor 0xor 3 = 3을 반환한다. 3은 유일하게 한 번만 나타나는 숫자이다.
 * 3은 인덱스가 아닌 nums의 값 자체이다.
 */
public class SingleNumber {

    public static int check(int k, int[] nums) {
        if (k == nums.length) {
            return 0;
        }
        return nums[k] ^ check(k + 1, nums);
    }

    public int singleNumber(int[] nums) {
        return check(0, nums);
    }

    /**
     * XOR 연산을 사용하지 않은 Arrays.sort() + index 비교
     * 1. 오름차순으로 배열을 정렬한다.
     * 2. 짝수 인덱스 (0,2,4..)를 탐색해서 현재와 다음 값을 비교해서 다르면 왼쪽인 i의 값을 반환한다.
     * 3. 2에서 반환하지 못했을 경우 마지막 값이 정답이다. nums[nums.length-1];
     */
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber.singleNumber(nums));
    }
}
