package linkedList.leetCode;

/**
 * LeetCode 328. Odd Even Linked List
 * <p>
 * [회고]
 * 시간초과로 실패, 홀수노드만 추출, 짝수노드만 추출하는 걸 메서드로 풀어내서 합치려고 했는데 잘 안됐다.
 * 합치는 건 좋은데 while문 조건을 어떻게 할 줄을 몰랐다.
 */
public class OddEvenLinkedList {

    class ListNode {
        int val;
        OddEvenLinkedList.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, OddEvenLinkedList.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 정답
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        /**
         * even.next => 현재 odd의 다음 홀수다.
         * odd.next => 현재 even의 다음 짝수다.
         *
         * break 기준은 짝수다.
         */
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            // ---------------------
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }


    /**
     * [나의 오답]
     * 홀수번째 노드만 추출한 head를 반환한다.
     */
    public ListNode oddHead(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            ListNode nextOdd = node.next.next;
            node.next = nextOdd;
            node = nextOdd;
        }
        return head;
    }

    /**
     * 짝수번째 노드만 추출한 head를 반환한다.
     */
    public ListNode evenHead(ListNode head) {
        if (head == null || head.next == null) {
            return new ListNode();
        }
        ListNode evenNode = head.next;
        while (evenNode != null && evenNode.next != null) {
            ListNode nextEven = evenNode.next.next;
            evenNode.next = nextEven;
            evenNode = nextEven;
        }
        return head.next;
    }

    public static void main(String[] args) {
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
//        OddEvenLinkedList.ListNode head = oddEvenLinkedList.new ListNode(1);
//        head.next = oddEvenLinkedList.new ListNode(2);
//        head.next.next = oddEvenLinkedList.new ListNode(3);
//        head.next.next.next = oddEvenLinkedList.new ListNode(4);
//        head.next.next.next.next = oddEvenLinkedList.new ListNode(5);
//        head.next.next.next.next.next = oddEvenLinkedList.new ListNode(6);
//        head.next.next.next.next.next.next = oddEvenLinkedList.new ListNode(7);
//        head.next.next.next.next.next.next.next = oddEvenLinkedList.new ListNode(8);
//        head.next.next.next.next.next.next.next.next = oddEvenLinkedList.new ListNode(9);
//        head.next.next.next.next.next.next.next.next.next = oddEvenLinkedList.new ListNode(10);

        OddEvenLinkedList.ListNode head = oddEvenLinkedList.new ListNode(2);
        head.next = oddEvenLinkedList.new ListNode(1);
        head.next.next = oddEvenLinkedList.new ListNode(3);
        head.next.next.next = oddEvenLinkedList.new ListNode(5);
        head.next.next.next.next = oddEvenLinkedList.new ListNode(6);
        head.next.next.next.next.next = oddEvenLinkedList.new ListNode(4);
        head.next.next.next.next.next.next = oddEvenLinkedList.new ListNode(7);

//        OddEvenLinkedList.ListNode result = oddEvenLinkedList.oddHead(head);
//        while(result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }

        OddEvenLinkedList.ListNode result2 = oddEvenLinkedList.evenHead(head);
        while (result2 != null) {
            System.out.println("result.val = " + result2.val);
            result2 = result2.next;
        }
    }
}
