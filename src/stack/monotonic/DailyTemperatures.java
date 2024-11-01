package stack.monotonic;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 739. Daily Temperatures
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Map<Integer, Integer> map = new HashMap<>();




        return ans;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
//        temperatures = new int[]{30,40,50,60};
//        temperatures = new int[]{30,60,90};

        int[] result = dailyTemperatures.dailyTemperatures(temperatures);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
