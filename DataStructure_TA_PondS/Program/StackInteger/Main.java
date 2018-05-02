package StackInteger;

class  Main
{  public static void main(String[] args) 
	{   ArrayStack AS = new ArrayStack(10); 
        
            if(!AS.isFull()){
                AS.push(2);
                AS.push(4);
                AS.push(6);
            }
            
            if(!AS.isEmpty()){
                int pop1 = AS.pop();
                System.out.println("pop1 = "+pop1);
            }
	    
             if(!AS.isFull()){
                AS.push(8);
                AS.push(9);
                AS.push(100);
            }
            
              if(!AS.isEmpty()){
                int pop2 = AS.pop();
                System.out.println("pop2 = "+pop2);
            }
            
            AS.printArray();	
	}
}
