/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author PARK
 */
import java.util.*;
public class Main {



    public static void main(String[]args) {

        String infix = "( 10 + 3 ) * ( 1.5 - ( 345 - 88.76 ) )";

        System.out.println("Infix : " + infix);
        String A = inf2postf(infix);
        System.out.println("Postfix : "+ A);
        System.out.println("ANS : " + computePostfix(A));

    }

    private static String inf2postf(String infix) {

        String postfix = "";
        Stack<String> operator = new Stack<String>();
        String popped;

        StringTokenizer st = new StringTokenizer(infix," ");

        while (st.hasMoreTokens()){
            String get = st.nextToken();
            //System.out.println("get: "+get);
            if (!isOperator(get)){
                postfix += get;
                postfix+=" ";
            }
            else if (get.equals(")")){
                while (!(popped = operator.pop()).equals("(")){
                    postfix += popped;
                    postfix+=" ";
                }
            }else {
                while (!operator.isEmpty() && !get.equals("(") && precedence(operator.peek()) >= precedence(get)){
                    postfix += operator.pop();
                    postfix+=" ";
                }
                operator.push(get);
            }

        }
        // pop any remaining operator
        while (!operator.isEmpty()){
            postfix += operator.pop();
            postfix+=" ";
        }

        return postfix;
    }

    private static boolean isOperator(String i) {
        return precedence(i) > 0;
    }

    private static int precedence(String i) {

        if ((i.equals("(")) || (i.equals(")"))) return 1;
        else if ((i.equals("-")) || (i.equals("+"))) return 2;
        else if ((i.equals("*")) || (i.equals("/"))) return 3;
        else return 0;
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
}
