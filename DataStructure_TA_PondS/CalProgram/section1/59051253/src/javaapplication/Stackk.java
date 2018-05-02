/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
public class Stackk {
      private final int maxSize;
      private final double[] stackArray;
      private int top;
      public Stackk(int max) {
         maxSize = max;
         stackArray = new double[maxSize];
         top = -1;
      }
      public void push(double j) {
          if(top == maxSize-1){
         System.out.println("Stack is Full.Cannot push");
          }else{stackArray[++top] = j;}
      }
      public double pop() {
         return stackArray[top--];
      }
      public double peek() {
         return stackArray[top];
      }
      public boolean isEmpty() {
         return (top == -1);
      }
   }