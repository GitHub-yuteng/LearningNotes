package LeetCode;

/**
 * @author Yu
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists_21 {

    public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        head.next = l1 == null ? l2 : l1;

        while (p1 != null && p2 != null) {

            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
                curr = curr.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
                curr = curr.next;
            }

            while (p1 == null && p2 != null) {
                curr.next = p2;
                p2 = p2.next;
                curr = curr.next;
            }

            while (p2 == null && p1 != null) {
                curr.next = p1;
                p1 = p1.next;
                curr = curr.next;
            }
        }
        return head.next;
    }

    private static void solution() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode nl1 = new ListNode(1);
        ListNode nl2 = new ListNode(3);
        ListNode nl3 = new ListNode(4);
        nl1.next = nl2;
        nl2.next = nl3;

        ListNode listNode = mergeTwoLists_1(ln1, nl1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }


    public static ListNode mergeTwoLists_2(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return head.next;
    }

    private static void solution_1() {
        ListNode ln1 = new ListNode(1);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(4);
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode nl1 = new ListNode(1);
        ListNode nl2 = new ListNode(3);
        ListNode nl3 = new ListNode(4);
        nl1.next = nl2;
        nl2.next = nl3;

        ListNode listNode = mergeTwoLists_2(ln1, nl1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {

//        solution();
        solution_1();
    }
}
