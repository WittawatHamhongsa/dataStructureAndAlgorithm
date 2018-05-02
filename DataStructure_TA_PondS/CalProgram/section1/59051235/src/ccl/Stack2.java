/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccl;

/**
 *
 * @author admin
 */
public class Stack2 {
    private final int maxSize;
    private final double [] stackArray;
    private int top;
    public Stack2(int max){
        maxSize = max;
        stackArray = new double[maxSize];
        top = -1;
    }
    public void push (double j){
           stackArray[++top] = j;
    }
    public double pop (){
           return stackArray[top--];
    }
    public double peek (){
           return stackArray[top];
    }
    public boolean isEmpty(){
           return (top == -1);
    }
}
