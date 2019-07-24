package 剑指Offer.Interview_9;

import java.util.Stack;

/*
用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
*/

public class Solution {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() throws Exception {


        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
        }

        if (stack2.isEmpty()){
            throw new Exception("queque is empty!");
        }

        return stack2.pop();
    }

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();

        solution.push(1);
        solution.push(2);
        solution.push(3);

        int pop1 = solution.pop();
        int pop2 = solution.pop();
        int pop3 = solution.pop();
        System.out.println(pop1);
        System.out.println(pop2);
        System.out.println(pop3);
    }
}