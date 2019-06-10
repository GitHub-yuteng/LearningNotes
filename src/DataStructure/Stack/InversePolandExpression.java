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
 * <p>
 * <p>
 * 中缀表达式 转 后缀 表达式
 *
 * 1、初始化两个栈；运算符栈 s1 和 储存中间结果的栈 s2
 * 2、从左至右扫描中缀表达式；
 * 3、遇到操作数时，将其压入 s2;
 * 4、遇到运算符，比较其与 s1 栈顶运算符的优先级。
     * 4.1、如果 s1 为空，或栈顶运算符为 左括号 ( 则直接将此运算符入栈;
     * 4.2、否则，若优先级比栈顶运算符的高，也将运算符压入s1;
     * 4.3、否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较;
 * 5、遇到括号时:
     * 5.1、如果是左括号“(”，则直接压入s1；
     * 5.2、)如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃。
 * 6、重复步骤 2至5，直到表达式的最右边
 * 7、将s1中剩余的运算符依次弹出并压入s2；
 * 8、依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式。
 */
public class InversePolandExpression {

    public static void main(String[] args) {


        String Expression = "1+((2+3)*4)-5";

        List<String> infixlist = toInfix(Expression);
        System.out.println("中缀表达式:"+infixlist.toString());

        //将得到的中缀表达式对应的List => 后缀表达式对应的list
        List<String> suffixExpressionList = parseSuffixExpressionList(infixlist);//中缀转后缀
        System.out.println("后缀表达式:"+suffixExpressionList.toString());

        //先定义一个逆波兰表达式
        //(3+4)*5-6 => 3 4 + 5 * 6 -
        //(30+4)*5-6 => 30 4 + 5 * 6 -
        //4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        List<String> listString = getListString(suffixExpression);//
//        System.out.println(listString.toString());

        int value = inversePolandCalc(suffixExpressionList);//后缀逆波兰计算
        System.out.println();

        System.out.println(suffixExpressionList + " = " + value);
    }


    public static List<String> parseSuffixExpressionList(List<String> list) {

        //定义两个栈 初始化栈  第二个栈可以用 List代替
        Stack<String> stack1 = new Stack<>();
        //List 代替Stack 因为 第二个栈没有 pop操作 最后还要逆序
        //Stack<String> stack2 = new Stack<>();
        List<String> stack2 = new ArrayList<>();

        // 1+((2+3)*4)-5
        for (String item : list) {
            if (item.matches("\\d+")) {
                stack2.add(item);
            } else if (item.equals("(")) {
                stack1.push(item);
            } else if (item.equals(")")) {
                //如果是右括号 ) 则依次弹出 stack1栈顶的运算符，并压入stack2
                // 直到遇到(左括号为止，此时将这一对括号舍弃
                while (!stack1.peek().equals("(")) {
                    stack2.add(stack1.pop());
                }
                stack1.pop();//将 （  弹出stack1 消除 ()
            } else {
                //当 item 的优先级 小于或者等于 栈顶优先级
                //将 stack1 栈顶运算符弹出并加入 stack2 中，再次转到 与 stack1 中新栈顶元素比较
                while (stack1.size() != 0 && priority(stack1.peek()) >= priority(item)) {
                    stack2.add(stack1.pop());
                }
                stack1.push(item);
            }
        }

        while (stack1.size() != 0) {
            stack2.add(stack1.pop());
        }

        return stack2;
    }

    public static int priority(String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
//                System.out.println("运算符输入有误!" + oper);
                break;
        }
        return res;
    }


    public static List<String> toInfix(String expression) {

        List<String> list = new ArrayList<>();

        int i = 0;//用于遍历 中缀表达式
        String str;//对 多位数进行拼接
        char c;//遍历字符存进 c

        do {
            //如果 c 是一个非数字 需要加入到 list
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                list.add("" + c);
                i++; //i后移
            } else {//如果是一个数字，则需要考虑多位数
                str = "";//清空  '0'[48] -> '9'[57]
                while (i < expression.length() && (c = expression.charAt(i)) > 48 && (c = expression.charAt(i)) < 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < expression.length());

        return list;
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到 ArrayList中
    public static List<String> getListString(String Expression) {
        String[] str = Expression.split(" ");
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

