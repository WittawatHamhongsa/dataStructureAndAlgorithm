/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author PNCOM
 */
public class Calculator {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kb = new Scanner (System.in);
        System.out.print("Enter you value : ");
        String expression = kb.nextLine();
        Calculator mathSolve = new Calculator (expression);
        Double result = mathSolve.getResult() ;
        System.out.println("The result is "+result);
   
}
     
    private final Double result;
    public  Calculator(String expression){
        result = solvePostfix(this.infixToPostfix(expression.toCharArray())) ;
     }
 
    public Double getResult() {
        return result;
    }
 
     private char[] infixToPostfix(char[] expression){
          System.out.println("Infix : "+new String(expression));
 
         Stack<Character> stack  = new Stack<>();
         StringBuilder buffer = new StringBuilder();
 
         for (int i = 0; i < expression.length; i++) {
 
             if (expression[i] == ')')
                 buffer.append(stack.pop());
 
             if(expression[i] == '+' || expression[i] == '-' ||
                expression[i] == '*' || expression[i] == '/'
                )
                 stack.push(expression[i]) ;
 
             if(expression[i] >= '0' && expression[i] <='9' || expression[i] <='.')
                 buffer.append(expression[i]);
 
         }
         while(!stack.empty())
             buffer.append(stack.pop());
 
         return new String(buffer).toCharArray();
     }
 
    private Double solvePostfix(char[] postfix){
         System.out.println("Postfix : "+new String(postfix));
 
         Stack<Double> calStack = new Stack<>();
 
         Double b , a ;
 
         for (int i = 0; i < postfix.length; i++) {
             char ch = postfix[i] ;
             
             if ('0'<=ch && ch<='9') {
                 calStack.push((double) (ch-'0'));
             }else {
                 switch (postfix[i]) {
                     case '+':
                         b = calStack.pop();
                         a = calStack.pop();
                         calStack.push(a+b);
                         break;
                     case '-':
                         b = calStack.pop();
                         a = calStack.pop();
                         calStack.push(a - b);
                         break;
                     case '*':
                         b = calStack.pop();
                         a = calStack.pop();
                         calStack.push(a * b);
                         break;
                     case '/':
                         b = calStack.pop();
                         a = calStack.pop();
                         calStack.push(a / b);
                         break;
                 }
             }
         }
 
         return calStack.pop();
     }
    }