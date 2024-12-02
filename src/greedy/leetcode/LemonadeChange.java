package greedy.leetcode;

/**
 * [회고]
 * 쉬운 레모네이드 문제라는데 분기처리에 이틀 헤매다가 실패.
 * <p>
 * 거슬러 주는 돈 외에 손님이 낸 돈을 그대로 보관하는 로직도 있어야 하는데 없었음.
 * 15달러를 계산하는 경우는 2가지인데 5달러가 3장 이상일 때만 5달러로 계산한다고 명확하게 기준을 세우면 되는데
 * 두루뭉실하게 처리해서 오류가 남.
 */
public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fCount = 0;
        int tCount = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fCount++;
            } else if (bill == 10) { // 5달러를 거스름돈으로 주어야 합니다.
                if (fCount > 0) {
                    fCount--;
                    tCount++; // 10달러 보관
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (fCount > 0 && tCount > 0) { // 둘다 최소 1장씩 가진 경우
                    fCount--;
                    tCount--;
                } else if (fCount >= 3) {
                    fCount -= 3;
                } else {
                    return false;
                }
            }

            if (fCount < 0 || tCount < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange solution = new LemonadeChange();
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(solution.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
