package 剑指Offer.reciprocalKNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

public class Solution {

    public static ListNode FindKthToTail(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        ListNode P1 = head;
        ListNode P2 = head;

        //TODO 既可以判断结点是否为空，又可以使P1指针后移
        while (P1 != null && k-- > 0) {
            P1 = P1.next;
        }

        //TODO K > 0 说明K值过大，超出链表长度
        if (k > 0) {
            return null;
        }

        while (P1 != null) {
            P1 = P1.next;
            P2 = P2.next;
        }
        return P2;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode node = FindKthToTail(listNode1, 3);
        System.out.println(node.toString());
    }
}