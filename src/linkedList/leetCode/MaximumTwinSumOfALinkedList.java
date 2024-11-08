package linkedList.leetCode;

import java.util.Stack;

/**
 * LeetCode 1940. Maximum Ascending Subarray Sum
 * <p>
 * [회고]
 * linkedList를 뒤집는 문제는 머릿속에 잘 안 그려진다....
 * leetCode에서 discussions를 보고 fast-slow 포인터와 스택을 응용해서 리버스를 구현했다.
 * <p>
 * 하지만 성능이 23ms로 낮았다.
 */
public class MaximumTwinSumOfALinkedList {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        Stack<Integer> stack = new Stack<>();

        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }

        int max = 0;
        ListNode node = head;

        while (!stack.isEmpty()) {
            int cal = stack.pop() + node.val;

            max = Math.max(max, cal);

            node = node.next;
        }
        return max;
    }

    /**
     * 성능이 10ms 미만의 정답
     */
    public int pairSumAnswer(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int halfLen = len / 2;
        int[] sums = new int[halfLen];

        int i = 0;
        int max = Integer.MIN_VALUE;
        cur = head;
        while (i < halfLen) {
            sums[i] += cur.val;
            cur = cur.next;
            i++;
        }

        while(i<len) {
            int index = len - i - 1;
            sums[index] += cur.val;
            max = Math.max(max, sums[index]);
            cur = cur.next;
            i++;
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumTwinSumOfALinkedList maximumTwinSumOfALinkedList = new MaximumTwinSumOfALinkedList();
        ListNode head = maximumTwinSumOfALinkedList.new ListNode(5);
        head.next = maximumTwinSumOfALinkedList.new ListNode(4);
        head.next.next = maximumTwinSumOfALinkedList.new ListNode(2);
        head.next.next.next = maximumTwinSumOfALinkedList.new ListNode(1);
        System.out.println(maximumTwinSumOfALinkedList.pairSum(head));
    }
}
