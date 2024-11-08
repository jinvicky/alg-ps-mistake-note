package linkedList.leetCode;

public class DeleteMidNodeOfALinkedList {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if(prev != null) {
            prev.next = slow.next;
            return head;
        } else {
            return slow.next;
        }
    }
}
