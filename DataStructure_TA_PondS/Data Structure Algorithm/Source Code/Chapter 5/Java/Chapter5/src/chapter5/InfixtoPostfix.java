package chapter5;

public class InfixtoPostfix {

    public static void main(String[] args) {
        String infix = "a-(b+c*d)/e";
        String postfix = "";
        StackLinkedListChar stack = new StackLinkedListChar();
        char[] ch = infix.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case '+':
                case '-':
                case '*':
                case '/':
                case '%':
                case '(':
                    stack.push(ch[i]);
                    break;
                case ')':
                    char stackBuffer = stack.pop();
                    while (stackBuffer != '(') {
                        postfix += stackBuffer;
                        stackBuffer = stack.pop();
                    }
                    break;
                default:
                    postfix += ch[i];
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        System.out.println(postfix);
    }
}
