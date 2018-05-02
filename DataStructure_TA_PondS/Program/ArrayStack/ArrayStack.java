public class ArrayStack<E> implements Stack<E> 
{ protected int capacity;
  static final int CAPACITY = 1000; 
  protected E S[];
  protected int top = -1; 
  
  public ArrayStack() 
		{ this(CAPACITY); 
		} 
  public ArrayStack(int cap) 
	    { capacity = cap; 
		  S = (E[]) new Object[capacity]; 
		}
  public int size()
	    {   top=top + 1;
			return top; 
		} 
  public boolean isEmpty()
		{ return (top < 0); 
		} 
  public void push(E element)
	    { 
		  S[++top]=element;
		} 
  public E top()
	    { return S[top]; 
		} 
  public E pop()
	    { E element; 
		  element = S[top]; 
		  S[--top] = null;  
		  return element; 
		} 
  public void printArray()
		{ for (int i=0 ; i < capacity ;i++)
	   	   {  
			System.out.println(top());
		   }
		}
}