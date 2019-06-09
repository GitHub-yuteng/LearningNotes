package DataStructure.Stack;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author Yu
 * 前缀表达式 (波兰表达式)
 * 从右至左扫描表达式 入栈
 * <p>
 * 后缀表达式 (逆波兰表达式)
 * 从左至右扫描表达式 入栈
 */
public class InversePolandExpression {

    public static void main(String[] args) {
        //先定义一个逆波兰表达式
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        String suffixExpression = "3 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        int value = inversePolandCalc(listString);
        System.out.println(suffixExpression+" = "+value);
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到 ArrayList中
    public static List<String> getListString(String suffixExpression) {
        String[] str = suffixExpression.split(" ");
        List<String> list = Arrays.asList(str);
        return list;
    }

    //完成逆波兰表达式运算
    public static int inversePolandCalc(List<String> ls) {

        Stack<String> stack = new Stack<>();

        for (String item : ls) {
            //利用正则匹配 数字
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                //如果不是数字，pop出两个数字并运算，在压入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int oper = item.charAt(0);
                int res = calc(num1, num2, oper);
                stack.push("" + res);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    public static int calc(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;//注意顺序
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;//注意顺序
                break;
            default:
                throw new RuntimeException("运算符有误！");
        }
        return res;
    }
}

