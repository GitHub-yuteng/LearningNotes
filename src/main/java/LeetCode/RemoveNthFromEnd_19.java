package LeetCode;

/**
 * @author Yu
 */
public class RemoveNthFromEnd_19 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode p1 = temp;
        ListNode p2 = temp;

        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode node = removeNthFromEnd(listNode, 2);
        System.out.println(node);
    }
}
