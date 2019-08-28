package 剑指Offer.ReverseList;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "->" + val;
    }
}

public class Solution {
    //TODO 迭代 头插法
    public static ListNode ReverseList(ListNode head) {

        ListNode newHead = null;
        if (head == null || head.next == null) {
            return head;
        }
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        //TODO 1 -> 2 -> 3 -> 4 -> 5

        ListNode reverseHead = ReverseList(listNode1);

        ListNode p = reverseHead;
        while (p != null) {
            System.out.print(p.toString());
            p = p.next;
        }
    }
}
