package DataStructure.Stack;

/**
 * @author Yu
 * 中缀表达式
 */
public class CalculatorStackDemo {

    public static void main(String[] args) {

        //单位数运算
        String expression = "700+2*11-2";

        //创建两个栈
        CalcArrayStack numStack = new CalcArrayStack(10);
        CalcArrayStack operStack = new CalcArrayStack(10);

        //定义辅助变量

        int index = 0;//用于扫描

        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到char保存到ch
        String keepNum = "";//用于拼接 多位数

        //扫描expression
        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是 数字还是运算符
            if (operStack.isOper(ch)) {//如果是运算符
                //判断当前符号栈是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈不为空有操作符，进行比较。
                    //如果当前的操作符优先级，小于或者等于栈中的操作符，就需要从数栈中pop出两个数
                    //在从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.calc(num1, num2, oper);
                        //运算结果压入数栈
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符优先级大于栈中的操作符,直接入栈
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {//如果是数字 直接入栈
                //numStack.push(ch - 48);//asc码表  '1' =>1 相差48位
                // 直接入栈只能保证单位数，比如70  就入两次栈 7,0 很显然错误

                //处理多位数
                //1、处理多位数，不能发现是一个数就立即入栈
                //2、处理数时，需要向 expression 的表达式后多看一位
                //2.1、如果是数字 进行扫描 拼接
                //2.2、如果是符号 入栈
                //3、需要定义一个字符变量用于拼接

                //处理多位数
                keepNum += ch;

                //如果ch已经是expression最后一位 就直接入栈
                if(index == expression.length()-1){

                    numStack.push(Integer.parseInt(keepNum));

                }else {
                    //判断下位数 是不是数字，是数字进行扫描，如果是字符才入栈
                    ch = expression.substring(index + 1, index + 2).charAt(0);

                    if (!operStack.isOper(ch)) {

                    } else {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";//清空keepNum
                    }
                }
            }

            //让 index+1 ,并判断是否扫描到了 expression最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕后，就顺序从数栈和符号栈中pop相应的数和符号，并运行。
        while (true) {
            //如果符号栈为空，则计算到最后的结果，或数栈只有一个数字(结果)
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.calc(num1, num2, oper);
            numStack.push(res);
        }

        int value = numStack.pop();
        System.out.println("结果为：" + expression + "=" + value);
    }
}

class CalcArrayStack {

    int top = -1;//栈顶
    int base = -1;//栈底

    int maxSize;//栈大小
    int[] stack;//数组模拟栈

    public CalcArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满！无法添加");
            return;
        }
        top++;
        stack[top] = num;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！无法取出数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void traverse() {
        //需要从栈顶向下遍历
        if (isEmpty()) {
            System.out.println("栈空！");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("Stack：" + stack[i]);
        }
        System.out.println("-------------------");
    }

    //查看栈顶元素
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空！无数据");
        }
        int value = stack[top];
        return value;
    }


    //返回运算符的优先级，优先级用数字表示，数字越大优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    //计算方法

    public int calc(int num1, int num2, int oper) {
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
                break;
        }
        return res;
    }
}