package StackInteger;

public class ArrayStack implements Stack { 
    protected int capacity;
    //static final int CAPACITY = 1000; 
    protected int Stack[];
    protected int top = -1; 
  
    public ArrayStack() {
        capacity = 1000;
        Stack =  new int[capacity]; 
    } 
    
    public ArrayStack(int capa) { 
        capacity = capa; 
        Stack =  new int[capacity]; 
    }
  
    public int size(){   
        top=top + 1;
	return top; 
    }
    
    public boolean isEmpty(){
        if (top < 0){
            return  true;
        }
        return  false;
    }
    
    public boolean isFull(){ 
        if (top == capacity-1 ){
            return  true;
        }
        return  false;
    }
    
    public int top(){
        return Stack[top]; 
    } 
    
    public void push(int element){ 
        Stack[++top]=element;    //S[top] = element; top = top+1;
    }

    
    public int pop() { 
        int element; 
        element = Stack[top]; 
        Stack[top--] = 0;       //S[top] = 0; top = top-1;
        return element;  
    } 
  
    public void printArray() { 
        for (int i=0 ; i <= top ;i++){  
            System.out.print(Stack[i]+" ");
        }
    }
}