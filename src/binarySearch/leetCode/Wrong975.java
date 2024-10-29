package binarySearch.leetCode;

import java.util.Arrays;

/**
 * LeetCode 875. Koko Eating Bananas
 * <p>
 * [어려웠던 점]
 * 문제 이해못함
 */
public class Wrong975 {

    // 브루트 포스로 탐색
    public int minEatingSpeedByBruteForce(int[] piles, int h) {
        int len = piles.length;
        int speed = 1;
        while (true) {
            int time = 0;
            for (int i = 0; i < len; i++) {
                time += Math.ceil((double) piles[i] / speed);
                if (time > h) {
                    break;
                }
            }

            if (time <= h) {
                return speed;
            } else {
                speed++;
            }
        }
    }

    //    성능 느림
    public int minEatingSpeedByBinarySearch(int[] piles, int h) {
        Arrays.sort(piles); // 이 문제에서는 더미의 순서, 아이템과 인덱스가 별로 안 중요해서 정렬해도 무방함
        int len = piles.length;
        int start = 1;
        int end = piles[len - 1];

        while (start < end) {
            int speed = (start + end) / 2;
            int time = 0;
            for (int i = 0; i < len; i++) {
                time += Math.ceil((double) piles[i] / speed);
                if (time > h) {
                    start = speed + 1;
                    break;
                }
            }

            if (time <= h) {
                end = speed;
            }
        }
        return start;
    }


    /**
     * 위보다 성능 나은 코드
     */
    public int minEatingSpeed2 (int[] piles, int h) {
        int max = Integer.MIN_VALUE;

        for (int pile : piles) {
            max = Math.max(pile, max);
        }

        int low = 1;
        int high = max;
        int a = -1;

        while(low <= high) {
            int mid = low + (high - low)/ 2; // mid는 현재 속도를 말한다.

            // 여기서부터 생각을 못해낸 거지.
            int ans = isPos(piles, mid);

            if(ans <= h) { // 더미별로 바나나 먹는 시간이 주어진 제한 시간 h보다 작거나 같다면
                a = mid; // 중간값을 a에 저장한다.
                high = mid - 1; // 오른쪽 포인터를 절반 가량 왼쪽으로 옮긴다.
            } else {
                low = mid + 1; // 왼쪽 포인터를 절반 가량 오른쪽으로 옮긴다.
            }
        }
        return a;
    }

    public int isPos(int[] arr, int k) {
        int d = 0;
        for (int j : arr) { // arr[i], 즉 더미별 바나나의 개수
            d +=  Math.ceil((double) j / k);
            // int로 형변환을 하면 소수점 제거된 정수값만 누적되므로, 계산 결과가 달라질 수 있음
            // Math.ceil()은 소수점 이하를 올림한다.
            // 개수 / 속도(mid)로 모든 더미의 바나나 먹는 시간을 구한다.
        }
        return d;
    }


}
