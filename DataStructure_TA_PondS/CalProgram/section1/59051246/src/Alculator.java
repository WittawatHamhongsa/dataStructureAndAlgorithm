import java.util.*;
public class Alculator
{
    public static void main(String[] args)
    {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter you value : ");//รับค่า input
        String infix = Sc.nextLine();
        Stack<Character> stack = new Stack<Character>(); //สร้าง stack
        StringBuffer postfix = new StringBuffer(infix.length()); //สร้าง string เก็บ postfix
        char input; //เก็บตัวค่าแต่ละตัวที่ออกมาจาก infix
        for (int i = 0; i < infix.length(); i++)// loop หา postfix โดยเริ่มตั้งแต่ infix ตัวแรกไปทีละตัว
        {   
           
            input = infix.charAt(i);// infix ตัวที่ i
            //เช็คว่า infix เป็นตัวเลขหรือไม่ 
            //System.out.println("get: "+input);//เช็คว่าคืออะไรบ้าง
            if (Character.getNumericValue(input) >= 0 && Character.getNumericValue(input) <=9 || input == '.')
            {
                postfix.append(input); //ถ้าเป็นเลขเก็บไว้ใน postfix
            }
            else
            {   
                if (input  == ')') // ถ้าเป็น ) ทำการนำ เครื่องหมายออกมา
                {
			        if(stack.peek() != '(')
                  	{       
                  	        postfix.append(" ");
                       		postfix.append(stack.pop());
                   	}
                   	stack.pop();
                }
                else //ถ้าไม่ใช่เก็บ เครื่องหมายไว้ใน stack
                {
              	  if ( (input=='+' || input=='-' || input=='*' || input=='/' || input=='('))
                    {
                        stack.push(input);
                        if(input!='('){
                           postfix.append(" "); 
                        }
                    }
                }
            }
        }
        while(!stack.empty())
        {
                postfix.append(" ");
                postfix.append(stack.pop()); //เอาเครื่องหมายทั้งหมดออกมา
        
        }
        System.out.println("Postfix is : "+postfix.toString());
       
        String postfixstr = postfix.toString(); 
        String[] postfixnew = postfixstr.split(" "); //นำ เว้นวรรค ออกจาก postfix
        Stack<Float> num = new Stack<Float>(); //สร้าง stack เก็บตัวเลข

        for(int j=0;j<postfixnew.length;j++) //loop หาผลลัพธืจาก postfix
        {   //เช็ค string ว่าเป็นเครื่องหมายหรือไม่
            if(!postfixnew[j].equals("+") && !postfixnew[j].equals("-") && !postfixnew[j].equals("*") && !postfixnew[j].equals("/"))
            {   //ถ้าไม่ใช่ให้เก็บตัวเลขไว้ใน stack
                num.push(Float.parseFloat(postfixnew[j]));
            }
            else
            {   //ถ้าเป็นเครื่องหมายนำ ตัวเลข 2ค่า ที่อยู่หลังเครื่องหมาย มาหาผลลัพธ์ตามเครื่องหมาย
                String Operator = postfixnew[j];
                Float num1 = num.pop();
                Float num2 = num.pop();
                float total=0;
                if (Operator.equals("/")){
                    total = num2 / num1;}
              
                if(Operator.equals("*")){
                    total = num2 * num1;}
                
                if(Operator.equals("+")){
                    total = num2 + num1;}
               
                if(Operator.equals("-")){
                    total = num2 - num1;}

                num.push(total); //นำผลลัพธ์กลับเข้าไปใน stack
            }
        } 
        System.out.println("The result is = " + num.pop()); //แสดงผลลัพธ์
    }
   
}