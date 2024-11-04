package bit.leetCode;


/**
 * LeetCode 136. Single Number
 *
 * [어려운점]
 * XOR 연산이 너무 생소했고, 정수끼리 ^했을 때 결과값이 예상과 달랐다.
 * boolean XOR 연산과 헷갈렸음.
 *
 * [핵심]
 * XOR 연산은 교환법칙, 결합법칙이 성립하며, 항등원은 0이다.
 *
 */
public class SingleNumber {

    public static int check(int k, int[] nums) {
        if(k == nums.length) {
            return 0;
        }
        return nums[k]^check(k+1, nums);
    }

    // 메서드
    public int singleNumber(int[] nums) {
        return check(0, nums);
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber.singleNumber(nums));
    }
}
