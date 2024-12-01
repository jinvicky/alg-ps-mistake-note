package greedy.leetcode;

/**
 *
 *
 * [회고]
 * 내가 맨 처음에 left, right로 나누어 구하고 붙여서 반환하려고 했던 게 맞는 접근이었다.
 *
 * [기타 배운 점]
 * 문자열에서 특정 문자를 DELETE하려면 StringBuilder()를 사용한다.
 */
public class RemoveDigitFromNumberToMaximizeResult {


    public String removeDigit(String number, char digit) {
        final char[] digits = number.toCharArray();
        int idx = 0;

        for(int i = 0; i < digits.length; i++) {
            if(digits[i]==digit){
                idx = i;

                if(i<digits.length-1 && digits[i] < digits[i+1]) {
                    break;
                }
            }
        }
        // substring은 인자값이 범위 밖이어도 에러가 안나네.
        // idx+1이 범위 벗어나도 되나 봄.
        return number.substring(0, idx) + number.substring(idx+1);
    }


    public static void main(String[] args) {
        RemoveDigitFromNumberToMaximizeResult solution = new RemoveDigitFromNumberToMaximizeResult();
        System.out.println(solution.removeDigit("123", '3')); // 3
        System.out.println(solution.removeDigit("1231", '1')); // 231
        System.out.println(solution.removeDigit("551", '5')); // 51
        System.out.println(solution.removeDigit("133235", '3')); // 13325
        System.out.println(solution.removeDigit("23", '2')); // 3
        System.out.println(solution.removeDigit("13333", '3'));
    }
}
