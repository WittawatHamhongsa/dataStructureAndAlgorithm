import LinkedList.LinkList;
import java.util.Scanner;
import java.util.Stack;


public class Calculate {
     public static void main(String[] args) {
        
        Scanner InputString = new Scanner(System.in);
	Stack Stack1 = new Stack();
        LinkList listcal = new LinkList();
        LinkList postfixlist = new LinkList();
        char data1;
	String check="";
	String num1 ;
	String test ="";
	String datapush="";
        String checkUSE="";
	int i,count=0,countString;
	int Countround=0,CountMax=0;
        double f = 0 , l = 0 , z = 0;
	
        System.out.print("Input :   ");
	
	String InputStep1 = InputString.nextLine();
	countString=InputStep1.length();
	//System.out.println(countString);เช็คค่า
	System.out.println("***************************");
            for (i=0;i<countString ;i++ )
	{//fori 
		data1 = InputStep1.charAt(i);//รับค่า
		//System.out.println("data1"+i+";"+data1);
		if (Character.isLetter(data1))//เช็คว่าเป็นตัวอักษรไหม
                    {System.out.println("Have Letter");break;}//ถ้าเป็นตัวอักษรให้หยุด
		checkUSE = String.valueOf(data1);//แปลงให้เป็นString
		datapush=checkUSE;
                    if ((Character.isDigit(data1))||(checkUSE.equals(".")))
                        {test =test +datapush;}
                    else
                        {Stack1.push(test);test=" ";}
                    
                    if (checkUSE.equals("+"))
                        {Stack1.push( datapush);
                        //System.out.println(" Yes  1");
                        }
                    else if (checkUSE.equals("-"))
                        {Stack1.push( datapush);
                        //System.out.println(" Yes  2");
                        }
                        else if (checkUSE.equals("*"))
                        {Stack1.push( datapush);
                        //System.out.println(" Yes  3");
                        }
                    else if (checkUSE.equals("/"))
                        {Stack1.push( datapush);
                        //System.out.println(" Yes  4");
                        }
                    else if (checkUSE.equals("("))
                        {Stack1.push( datapush);
                        //System.out.println(" Yes  5");
                        }
                    else if (checkUSE.equals(")"))
                        {Stack1.push( datapush);
                        //System.out.println(" Yes  6");
                        }
        }//fori
		
            Stack1.push(test);
            //System.out.println(Stack1);
		while (!Stack1.empty())
		{
                    test = (String)Stack1.pop();
                    if (!test.equals(" "))
                    //System.out.println("test list");
                    {listcal.addFirst(test);}
		}
                //System.out.println(listcal);
                
                int size=listcal.sizeList();
                //System.out.println ("m="+m);เช็คค่า
               
            Stack<Double> calc = new Stack<>();
            Stack<String> Stack2 = new Stack<>();
            String infix;
              
            for (i=0;i<size ;i++ ) 
            {//fori
                 infix= (String) listcal.deleteFirst().getItem(); 
                 //System.out.println("q= "+q);เช็คค่า
            
                if (!infix.equals("(")&&!infix.equals(")")&&!infix.equals("+")
                        &&!infix.equals("-")&&!infix.equals("*")&&!infix.equals("/"))
                        postfixlist.addLast(infix);
                
                else if (infix.equals("("))
			Stack2.push("(");
                       
                    else if (infix.equals(")"))
			{while (!Stack2.peek().equals("(") && !Stack2.isEmpty())//ทำจนกว่าจะเจอ )
                            { postfixlist.addLast(Stack2.pop()); }     
                            Stack2.pop();}
                       
                     else if (infix.equals("+")) 
                        {if (Stack2.isEmpty()) {
                               Stack2.push("+"); }
                            else if (!(Stack2.isEmpty())){
                                if ( Stack2.peek().equals ("*") || Stack2.peek().equals ("/") ||
                                        Stack2.peek().equals ("-") )
                                { postfixlist.addLast(Stack2.pop()); } //นำค่าที่ pop เก็บไว้
                                 Stack2.push("+"); }
                        }
                        
                        else if (infix.equals("-")) 
                        {if (Stack2.isEmpty()) {
                               Stack2.push("-"); }
                            else if (!(Stack2.isEmpty())){
                                if ( Stack2.peek().equals ("*") || Stack2.peek().equals ("/") || 
                                        Stack2.peek().equals ("+") )
                                { postfixlist.addLast(Stack2.pop()); }
                                    Stack2.push("-"); }
                        }
                    
                            else if (infix.equals("*")) 
                        {if (Stack2.isEmpty()) {
                               Stack2.push("*"); }
                            else if (!(Stack2.isEmpty())){
                                if (Stack2.peek().equals ("/"))
                                { postfixlist.addLast(Stack2.pop());
                                    Stack2.push("*"); }
                            else {Stack2.push("*"); } }
                        }
                        
                        else if (infix.equals("/")) 
                        {if (Stack2.isEmpty()) {
                               Stack2.push("/"); }
                            else if (!(Stack2.isEmpty())){
                                if (Stack2.peek().equals ("*"))
                                { postfixlist.addLast(Stack2.pop());
                                    Stack2.push("/"); }
                            else {Stack2.push("/"); } }
                        }
                
                        else 
			{
				while (!Stack2.isEmpty())
                                    postfixlist.addLast(Stack2.pop());
				Stack2.push(infix);
			}
                    
                }//fori
                 
                    while (!Stack2.isEmpty())//เอาเครื่องหมายกับเลขออกมา
                    { if (!test.equals(""))
                        postfixlist.addLast(Stack2.pop());}
                   System.out.println("Postfix :");
                    postfixlist.printList();
             
                  int SizePost=postfixlist.sizeList();
                    for(int j = 0; j <SizePost; j++)
                    {//forj
                     String c= (String) postfixlist.deleteFirst().getItem(); 
                    //System.out.println("c="+c);
                   
                    if(c.equals("+")){
                        f = calc.pop();
                        l = calc.pop();
                        z = l+f;
                        calc.push(z);}
                    
                    else if(c.equals("-")){
                        f = calc.pop();
                        l = calc.pop();
                        z = l-f;
                        calc.push(z);}
                    
                    else if(c.equals("*")){
                        f = calc.pop();
                        l = calc.pop();
                        z = l*f;
                        calc.push(z);}
                    
                    else if(c.equals("/")){
                        f = calc.pop();
                        l = calc.pop();
                        z = l/f;
                        calc.push(z);}
                   
                    else {
                    double digit =  Double.parseDouble(c);//ปลี่ยนจาก String เป็น double
                    calc.push(digit); }
                     //System.out.println("cal1= "+calc);
       
                    }//forj
        
                  Double cal = calc.pop();
                  System.out.println("***************************");
                  System.out.println("Calculate= "+cal);           

    }//main
}//class