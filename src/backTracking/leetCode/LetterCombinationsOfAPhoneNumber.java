package backTracking.leetCode;

import java.util.*;

/**
 *
 *
 * [회고]
 * * answer를 global로 선언하려면 잘 보고 하기. 여러 테스트 케이스 때 다음 테스트 케이스에 영향 미치니까.
 */
public class LetterCombinationsOfAPhoneNumber {

    private static char[][] dfs;

    private void initAlphaDict(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> answer = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        initAlphaDict(map);

        if (digits.length() == 1) {
            return Arrays.stream(map.get(digits.charAt(0)).split("")).toList();
        }

        dfs = new char[digits.length()][4];
        for (int h = 0; h < digits.length(); h++) {
            char[] toCharArr = map.get(digits.charAt(h)).toCharArray(); // "abc" || "def"....
            for (int k = 0; k < toCharArr.length; k++) {
                dfs[h][k] = toCharArr[k];
            }
        }

        backtrack(digits, 0, new StringBuilder(), answer, map);

        return answer;
    }

    private void backtrack(String digits, int idx, StringBuilder comb, List<String> res, Map<Character, String> digitToLetters) {
        if (idx == digits.length()) {  // break; 조건
            res.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(idx));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, idx + 1, comb, res, digitToLetters);
            // 초기화하지 않고 현재 조합을 유지하는 방법 : StringBuilder 재사용 + 마지막 문자를 제거
            comb.deleteCharAt(comb.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("2"));
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("22"));
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("23"));
        System.out.println(letterCombinationsOfAPhoneNumber.letterCombinations("234"));
    }
}
