package Stack;

public class ArrayStack<E> implements Stack<E> { 
    protected int capacity;
    static final int CAPACITY = 1000; 
    protected E Stack[];
    protected int top = -1; 
  
    public ArrayStack() {
        Stack = (E[]) new Object[CAPACITY]; 
    } 
    
    public ArrayStack(int capa) { 
        Stack = (E[]) new Object[capa]; 
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
    
    public void push(E element){ 
        Stack[++top]=element;    //S[top] = element; top = top+1;
    }
    
    public E top(){
        return Stack[top]; 
    } 
    
    public E pop() { 
        E element; 
        element = Stack[top]; 
        Stack[top--] = null;       //S[top] = null; top = top-1;
        return element; 
    } 
  
    public void printArray() { 
        for (int i=0 ; i <= top ;i++){  
            System.out.print(Stack[i]+" ");
        }
    }
}