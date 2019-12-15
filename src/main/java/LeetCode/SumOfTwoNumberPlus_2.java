package LeetCode;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Yu
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class SumOfTwoNumberPlus_2 {

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        ListNode p1 = l1;
        ListNode p2 = l2;

        while (p1 != null) {
            stack1.push(p1.val);
            p1 = p1.next;
        }

        while (p2 != null) {
            stack2.push(p2.val);
            p2 = p2.next;
        }

        StringBuilder sb1 = new StringBuilder();
        while (!stack1.isEmpty()) {
            sb1.append(stack1.pop());
        }

        StringBuilder sb2 = new StringBuilder();
        while (!stack2.isEmpty()) {
            sb2.append(stack2.pop());
        }

        //TODO  NumberFormatException 如果数值过大，格式化异常
        String num = String.valueOf(Integer.parseInt(sb1.toString()) + Integer.parseInt(sb2.toString()));

        ListNode lNode = new ListNode(0);
        ListNode temp = lNode;

        for (int i = num.length(); i > 0; i--) {
            ListNode listNode = new ListNode(Integer.parseInt(num.substring(i - 1, i)));
            lNode.next = listNode;
            lNode = lNode.next;
        }

        return temp.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = temp;

        int carry = 0;
        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }

        if(carry>0){
            curr.next = new ListNode(carry);
        }

        return temp.next;
    }

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        ListNode ln1 = new ListNode(9);

        ListNode nl1 = new ListNode(1);
        ListNode nl2 = new ListNode(9);
        ListNode nl3 = new ListNode(9);
        ListNode nl4 = new ListNode(9);
        ListNode nl5 = new ListNode(9);
        ListNode nl6 = new ListNode(9);
        ListNode nl7 = new ListNode(9);
        ListNode nl8 = new ListNode(9);
        ListNode nl9 = new ListNode(9);
        ListNode nl10 = new ListNode(9);
        nl1.next = nl2;
        nl2.next = nl3;
        nl3.next = nl4;
        nl4.next = nl5;
        nl5.next = nl6;
        nl6.next = nl7;
        nl7.next = nl8;
        nl8.next = nl9;
        nl9.next = nl10;

        ListNode listNode = addTwoNumbers(ln1, nl1);

        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
    }
}
