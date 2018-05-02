package Stack;
import java.util.*;
class  Main
{  public static void main(String[] args) 
	{   ArrayStack <Integer> AS = new ArrayStack <Integer>(10); 

	     AS.push(2);
		 AS.push(4);
		 AS.push(6);
		 int pop1 = AS.pop();
                 System.out.println("pop1 = "+pop1);
		 AS.push(8);
		 AS.push(9);
		 int pop2 = AS.pop();
		 System.out.println("pop2 = "+pop2);
		AS.printArray();
		
	}
}
