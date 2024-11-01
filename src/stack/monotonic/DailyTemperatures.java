package stack.monotonic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LeetCode 739. Daily Temperatures
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < temperatures.length; i++) {

            if(stack.isEmpty()) {
                // do nothing
            } else {
                int count = 0;
                int insertIndex = 0;
                while(!stack.isEmpty() && stack.peek() > temperatures[i]) {
                    insertIndex = map.get(stack.pop());
                    count++;
                }
                ans[insertIndex] = count;
            }
            stack.push(temperatures[i]);
            map.put(temperatures[i], i);
        }
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
