package math.leetCode;

/**
 * 그냥 수학을 요구
 *
 * 8글자 블록마다 추가적인 푸시가 필요하다.
 *
 * [회고]
 * %랑 /를 사용해서 정처기에서 본 걸로 이케저케 풀어보려다가 테스트 케이스 3번째에서 실패.
 */
public class MinimumNumberOfPushesToTypeWord1 {
    public int minimumPushes(String word) {
        final int MAX_LENGTH = 8;
        if (word.length() < MAX_LENGTH) {
            return word.length();
        }
        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            answer+= (i / 8) + 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        MinimumNumberOfPushesToTypeWord1 minimumNumberOfPushesToTypeWord1 = new MinimumNumberOfPushesToTypeWord1();
        System.out.println(minimumNumberOfPushesToTypeWord1.minimumPushes("abcde"));
        System.out.println(minimumNumberOfPushesToTypeWord1.minimumPushes("xycdefghij"));
        System.out.println(minimumNumberOfPushesToTypeWord1.minimumPushes("abhrlngxyjkezwcm"));
    }
}
