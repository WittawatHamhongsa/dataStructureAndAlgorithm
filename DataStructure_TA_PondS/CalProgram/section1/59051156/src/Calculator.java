import java.util.*;
public class Calculator
{
    public static void main(String[] args)
    {
        Scanner Sc = new Scanner(System.in);
        System.out.print("Enter you value : ");//รับค่า input
        String infix = Sc.nextLine(); 
        Stack<Character> stack = new Stack<>(); //สร้าง stack
        StringBuffer postfix = new StringBuffer(infix.length()); //สร้าง string เก็บ postfix
        char input; //เก็บตัวค่าแต่ละตัวที่ออกมาจาก infix
        for (int i = 0; i < infix.length(); i++)// loop หา postfix โดยเริ่มตั้งแต่ infix ตัวแรกไปทีละตัว
        {   
            input = infix.charAt(i);// infix ตัวที่ i
            //เช็คว่า infix เป็นตัวเลขหรือไม่
            if (Character.getNumericValue(input) >= 0 && Character.getNumericValue(input) <9 || input == '.')
            {
                postfix.append(input); //ถ้าเป็นเลขเก็บไว้ใน postfix
            }
            else
            {   if ( ( input=='*' || input=='/'|| input=='+' || input=='-'))
                   {  if (( input=='+' || input=='-' ))
                       {if(!stack.empty()){if(stack.peek()=='*'||stack.peek()=='/')
                        {postfix.append(" ");
                        postfix.append(stack.peek());
                        stack.pop();
                        stack.push(input);
                        postfix.append(" ");}}
                        else{stack.push(input);//เอาเครื่องหมายใส่stack
                        postfix.append(" ");}//เว้นวรรค
                        }
                         else if(( input=='*' || input=='/' )){
                         stack.push(input);//เอาเครื่องหมายใส่stack
                         postfix.append(" ");}
                   }//เว้นวรรค
                     else if (( input=='(' )) {stack.push(input);}
                     else if ((input==')'))
                         { do{
                                postfix.append(" ");
                                postfix.append(stack.peek());
                                stack.pop();
                            }
                            while(stack.peek()!='(');
                          //stack.pop();
                        }
            }//else
           // System.out.println("i :"+i+"stack "+stack);
}//for i 
        while(!stack.empty())
        {
                postfix.append(" ");
                postfix.append(stack.pop()); 
        }
        System.out.println("postfix is :"+postfix);//จบpostfix
       
        String postfixstr = postfix.toString(); 
        String[] a = postfixstr.split(" "); 
        Stack<Double> cal = new Stack<>();
       double m,n,o;
       for(int j = 0;j<a.length;j++){
       if("+".equals(a[j])||"-".equals(a[j])||"*".equals(a[j])||"/".equals(a[j])||"(".equals(a[j]))
       {if("+".equals(a[j])){m=cal.peek();
                        cal.pop();
                        n=cal.peek();
                        cal.pop();
                        o=m+n; cal.push(o);}//if+
       else if("-".equals(a[j])){m=cal.peek();
                        cal.pop();
                        n=cal.peek();
                        cal.pop();
                        o=n-m; cal.push(o);}//if-
       else if("*".equals(a[j])){m=cal.peek();
                        cal.pop();
                        n=cal.peek();
                        cal.pop();
                        o=m*n; cal.push(o);}//if*
       else if("/".equals(a[j])){m=cal.peek();
                        cal.pop();
                        n=cal.peek();
                        cal.pop();
                        o=n/m; cal.push(o);}//if/
           }//if+-*/
       else {double x=Double.parseDouble(a[j]);
             cal.push(x);}
     //  System.out.println("j :"+j+"stack "+cal);
    }//forj
       System.out.println("result is :"+cal.peek());
}
}