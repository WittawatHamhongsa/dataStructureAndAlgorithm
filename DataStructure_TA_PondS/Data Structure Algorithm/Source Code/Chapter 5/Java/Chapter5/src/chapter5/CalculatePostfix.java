package chapter5;

public class CalculatePostfix {

    public static void main(String[] args) {
        String postfix = "abcd*+e/-";
        double a = 20, b = 5, c = 3, d = 5, e = 4;
        double Op1 = 0, Op2 = 0, f = 0;
        char chOp1, chOp2;
        StackLinkedListChar stack = new StackLinkedListChar();
        char[] ch = postfix.toCharArray();
        for (int i = 0; i < ch.length; i++) {

            if ((ch[i] == '+') || (ch[i] == '-')
                    || (ch[i] == '*') || (ch[i] == '/')
                    || (ch[i] == '%')) {
                chOp2 = stack.pop();
                chOp1 = stack.pop();
                if (chOp1 == 'a') {
                    Op1 = a;
                } else if (chOp1 == 'b') {
                    Op1 = b;
                } else if (chOp1 == 'c') {
                    Op1 = c;
                } else if (chOp1 == 'd') {
                    Op1 = d;
                } else if (chOp1 == 'e') {
                    Op1 = e;
                } else if (chOp1 == 'f') {
                    Op1 = f;
                }
                if (chOp2 == 'a') {
                    Op2 = a;
                } else if (chOp2 == 'b') {
                    Op2 = b;
                } else if (chOp2 == 'c') {
                    Op2 = c;
                } else if (chOp2 == 'd') {
                    Op2 = d;
                } else if (chOp2 == 'e') {
                    Op2 = e;
                } else if (chOp2 == 'f') {
                    Op2 = f;
                }
                if (ch[i] == '+') {
                    f = Op1 + Op2;
                } else if (ch[i] == '-') {
                    f = Op1 - Op2;
                } else if (ch[i] == '*') {
                    f = Op1 * Op2;
                } else if (ch[i] == '/') {
                    f = Op1 / Op2;
                } else if (ch[i] == '%') {
                    f = Op1 % Op2;
                }
                stack.push('f');
            } else {
                stack.push(ch[i]);
            }
        }
        System.out.println("Posfix Calculate:" + f);
    }
}
