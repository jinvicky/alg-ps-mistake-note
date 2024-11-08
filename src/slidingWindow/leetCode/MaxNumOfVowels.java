package slidingWindow.leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * [어려웠던 부분]
 * for문의 i와 k의 인덱스 범위를 잡는데 시간이 오래 걸렸다.
 * lee, eet, etc, tco 가 되려면 맨처음에 k개 뽑고 i는 k부터 시작
 *
 * [결과]
 * 전날 2시간 공부하다가 막혔다.
 * string substring 인덱스 계산이 약해서 큐 자료구조 힘을 빌려서 처리했다.
 * 다음날 오전에 10분 내로 풀었지만 성능이 25ms로 매우 낮았다.
 */
public class MaxNumOfVowels {

    public int maxVowels(String s, int k) {
        Queue<Character> queue = new LinkedList<>();
        int maxCount = 0;

        for(int i = 0; i < k; i++) {
            if(isVowel(s.charAt(i))) {
                maxCount++;
            }
            queue.add(s.charAt(i));
        } // ok

        int calCount = maxCount;
        for(int i = k; i < s.length(); i++) {
            if(!queue.isEmpty() && isVowel(queue.poll())) {
                calCount--;
            }
            if(isVowel(s.charAt(i))) {
                calCount++;
            }

            queue.add(s.charAt(i));
            maxCount = Math.max(calCount, maxCount);
        }
        return maxCount;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowelsAnswer(String s, int k) {
        int i=0; // 슬라이딩 윈도우의 시작 인덱스
        int c=0; // 난 maxCount, calCount로 했는데 1개로 줄일 수 있었음
        char ch; // 현재 문자
        int ans=0;

        for(int j=0; j<s.length();j++) {
            /**
             * 현재 슬라이딩 윈도우의 크기가 k보다 클 때,
             * j가 증가하여 k를 초과하면 i가 증가하고, 시작 문자를 제거하면서 모음 수를 조절
             * i는 윈도우에서 제거할 문자의 인덱스를 의미한다.
             */
            if((j-i+1) > k) {
                ch=s.charAt(i); // CHK:: i번째 문자를 조회
                ans=Math.max(c,ans);
                if(isVowel(ch)) {
                    if(c>0) {
                        c--;
                    }
                }
                i++;
            }
            // 1. 현재 문자가 모음인지 여부를 체크해서 c++한다.
            ch=s.charAt(j); // CHK:: j번째 문자를 조회
            if(isVowel(ch)) {
                c++;
            }
        }
        return Math.max(c,ans);
    }
}
