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
public class Stack {
    private final int maxSize;
    private final char [] stackArray;
    private int top;
    public Stack(int max){
        maxSize = max;
        stackArray = new char[maxSize];
        top = -1;
    }
    public void push (char j){
           stackArray[++top] = j;
    }
    public char pop (){
           return stackArray[top--];
    }
    public char peek (){
           return stackArray[top];
    }
    public boolean isEmpty(){
           return (top == -1);
    }
}
    
    

