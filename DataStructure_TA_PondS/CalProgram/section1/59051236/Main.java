import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        String output = new Main().shuntingYard(infix);
        System.out.println(computePostfix(output));

    }

    private enum Operator {
        ADD(1), SUBTRACT(2), MULTIPLY(3), DIVIDE(4);
        final int precedence;
        Operator(int p) {
            precedence = p;
        }
    }

    private Map<String, Operator> operatorMap = new HashMap<String, Operator>() {{
        put("+", Operator.ADD);
        put("-", Operator.SUBTRACT);
        put("*", Operator.MULTIPLY);
        put("/", Operator.DIVIDE);
    }};

    private boolean isHigherPrec(String op, String sub) {
        return (operatorMap.containsKey(sub) &&
                operatorMap.get(sub).precedence >= operatorMap.get(op).precedence);
    }

    public String shuntingYard(String infix) {
        StringBuilder output = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for (String token : infix.split("")) {
            //operator
            if (operatorMap.containsKey(token)) {
                while ( ! stack.isEmpty() && isHigherPrec(token, stack.peek())) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }
            //left parenthesis
            else if (token.equals("(")) {
                stack.push(token);
            }
            //right parenthesis
            else if (token.equals(")")) {
                while ( ! stack.peek().equals("(")) {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop();
            }
            //digit
            else {
                output.append(token).append(' ');
            }
        }
        while ( ! stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }
        return output.toString();
    }
     static Double computePostfix(String postfix){
		StringTokenizer st = new StringTokenizer(postfix," ");
		Stack<Double> stack = new Stack<Double>();
		while (st.hasMoreTokens())
		{
			String S = st.nextToken();
			if (S.equals("+"))
			{
				Double b = stack.pop();
				Double a = stack.pop();
				stack.push(a+b);
			}
			else if (S.equals("-"))
			{
				Double b = stack.pop();
				Double a = stack.pop();
				stack.push(a-b);
			}
			else if (S.equals("*"))
			{
				Double b = stack.pop();
				Double a = stack.pop();
				stack.push(a*b);
			}
			else if (S.equals("/"))
			{
				Double b = stack.pop();
				Double a = stack.pop();
				stack.push(a/b);
			}
			else {
				stack.push(Double.parseDouble(S));
			}
		} //end while
		return stack.pop();
    }
    static void printBase2(int n,int b){
        Mystack s = new Mystack();
        while (n>0){
            s.push(n%b);
            n /=b;
        }
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
  }