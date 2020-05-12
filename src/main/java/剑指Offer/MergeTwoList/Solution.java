package 剑指Offer.MergeTwoList;

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return " " + val;
    }
}

public class Solution {

    //TODO 迭代
    public static ListNode Merge(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode cur = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 == null) {
            cur.next = list2;
        }

        if (list2 == null) {
            cur.next = list1;
        }
        return head.next;
    }

    //TODO 递归
    public static ListNode MergeRecursive(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }


    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        ListNode listNode11 = new ListNode(11);

        listNode1.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode7;
        listNode7.next = listNode9;
        listNode9.next = listNode10;
        //TODO 1 -> 3 -> 4 -> 7 -> 9 -> 10
        ListNode p1 = listNode1;
        while (p1 != null) {
            System.out.print(p1.toString());
            p1 = p1.next;
        }
        System.out.println();

        listNode2.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode8;
        listNode8.next = listNode11;
        //TODO 2 -> 5 -> 6 -> 8 -> 11
        ListNode p2 = listNode2;
        while (p2 != null) {
            System.out.print(p2.toString());
            p2 = p2.next;
        }
        System.out.println();

        ListNode listNode = Merge(listNode1, listNode2);
        ListNode p = listNode;
        System.out.println("======迭代======");
        while (p != null) {
            System.out.print(p.toString());
            p = p.next;
        }

//        ListNode listHead = MergeRecursive(listNode1, listNode2);
//        ListNode pHead = listHead;
//        //TODO 迭代注释后才可以使用递归，因为上面改变了 list1、list2 指针位置
//        System.out.println("======递归======");
//        while (pHead != null) {
//            System.out.print(pHead.toString());
//            pHead = pHead.next;
//        }
    }
}