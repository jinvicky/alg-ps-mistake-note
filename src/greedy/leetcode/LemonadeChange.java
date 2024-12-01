package greedy.leetcode;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {
        int fCount = 0;
        int tCount = 0;

        for (int bill : bills) {
            if (bill == 5) {
                fCount++;

            } else if (bill == 10) { // 5달러를 거스름돈으로 주어야 합니다.
                if (fCount < 1) {
                    return false;
                }
                fCount--;
                tCount++; // 10달러 보관
            } else if (bill == 20) {
                // 15달러를 거스름돈으로 주어야 합니다.
                if (fCount < 1 || tCount < 1) {
                    return false;
                }

                if (fCount >= 3) {
                    fCount -= 3;
                } else {
                    fCount--;
                    tCount--;
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
