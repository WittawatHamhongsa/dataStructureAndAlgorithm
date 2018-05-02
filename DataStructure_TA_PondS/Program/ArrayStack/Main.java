import java.util.*;
class  Main
{  public static void main(String[] args) 
	{   ArrayStack <Integer> AS = new ArrayStack <Integer>(10); 

	     AS.push(2);
		 AS.push(4);
		 AS.push(6);
		 AS.pop();
		 AS.push(8);
		 AS.push(9);
		 AS.pop();
		
		AS.printArray();
			//System.out.println(AS.S);
	}
}
