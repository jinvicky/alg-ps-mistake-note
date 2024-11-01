package greedy.leetcode;

import java.util.Arrays;

/**
 * LeetCode 435. Non-overlapping Intervals
 *
 * [핵심]
 * 시작점이 아니라 끝점 기준으로 정렬해야 함
 * 그리디 알고리즘 유형, 사전 정렬을 요구
 *
 * 현재 구간의 시작점이 이전 구간의 끝점보다 크거나 같으면 겹치지 않음
 * 현s >= 기존e
 * 1 >= 2 // false  -> count = 1;
 * 2 >= 2 // true -> end = 3;
 * 3 >= 3 // true -> end = 3;
 */
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int endTmp = intervals[0][1];

        for(int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            if(currentStart >= endTmp) {
                endTmp = intervals[i][1];
            } else {
                count++;
            }
        }
        return count;
    }
}
