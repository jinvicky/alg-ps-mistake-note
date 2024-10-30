package stack.monotonic;

import java.util.Stack;

public class Wrong901 {
    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}

class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while(st.size() > 0 && st.peek()[0] <= price) {
            // 스택에서 가격이 나보다 작거나 같음을 만족할 동안 계속 pop해서 ans를 누적 가산.
            ans = ans + st.pop()[1];
        }
        st.push(new int[]{price, ans});
        return ans;
    }
}
