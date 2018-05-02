package calculator;
public class stack {
    Node first ;
    Node top;
    
    public stack(){
        top = null;
    }

    public void push(Object value){
        Node n = new Node(value, null, null);
        if (first == null){
            first = n;
            top = n;
        }
        else{
            top.next = n;
            n.prev = top;
            top = n;
        }
    }
    
    public Object pop(){
        if (!isEmpty()){
                Object temp = top.idata;
                if (first == top){
                    first = null;
                    top = null;
                }
                else{
                    top = top.prev;
                    top.next = null;
                }
                return(temp);
            }
        else{
            System.out.println("Stack is Empty.");
            return (-1);
        }
    }
    
    public Object peek(){
        if (!isEmpty()){
            return (top.idata);
            }
        else{
            System.out.println("Stack is Empty.");
            return (-1);
        }
    }
    
    public boolean isEmpty(){
        return (top == null);
    }
      
    public void display(){
        if (first == null){
            System.out.println("List is Empty");
        }
        else{
            Node p = first;
            System.out.print(" : ");
            while (p != null){
                System.out.print(p.idata+" ");
                p = p.next;
            }
        }
    }
    
    public  void calculat(String num){
        //variable
        int i=0;
        double d1 = 0, operand1 , operand2;
        char c1='0', c2, c3;
        String c = "";
        Object n1, o1='-', o2='+', o3='*', o4='/';
        
        //object stack
        stack operator = new stack();
        stack postFix = new stack();
        stack cal = new stack();
        
        //infix to postfix
        while(i != num.length()){
            c2 = c1;
            c1 = num.charAt(i);
            i++;
            if(c1 == '-'){
                if(c2 == '('){
                    c += c1;
                    continue;
                }
            }
            if(c2 == ')' && c1 == '('){
                operator.push('*');
                operator.push(c1);
                continue;
            }
            if(c1 == '+' || c1 == '-' || c1 == '*' || c1 == '/'){
                if(c2 == '+' || c2 == '-' || c2 == '*' || c2 == '/'){
                    System.out.println("Please check the input.");
                    break;
                }
            }
            switch (c1) {
                case '-':
                case '+':
                    if(c2 != ')'){
                        postFix.push(d1);
                        c = "";
                    }
                    if(!operator.isEmpty()){
                        c3 = (char)operator.peek();
                        if(c3 == '*' || c3 == '/'){
                            postFix.push(operator.pop());
                            if(!operator.isEmpty()){
                                c3 = (char)operator.peek();
                                if(c3 == '+' || c3 == '-'){
                                postFix.push(operator.pop());
                                }
                            }
                        }
                        else if(c3 == '+' || c3 == '-' ){
                            postFix.push(operator.pop());
                        }
                    }                   
                    operator.push(c1);   
                    break;
                case '*':
                case '/':
                    if(c2 != ')'){
                        postFix.push(d1);
                        c = "";
                    }
                    if(!operator.isEmpty()){
                        c3 = (char)operator.peek();
                        if(c3 == '*' || c3 == '/'){
                            postFix.push(operator.pop());
                        }
                    }                   
                    operator.push(c1);
                    break;
                case '(':
                    if(c2==('-') || c2==('+') || c2==('*') || c2==('/') || c2==('(')){
                        operator.push(c1);
                    }
                    else{
                        if(i != 1 ){
                            postFix.push(d1);
                            operator.push('*');
                            operator.push(c1);
                            c = "";
                        }
                        else{
                            operator.push(c1);
                        }
                    }   break;
                case ')':
                    if(c2!=(')')){
                        postFix.push(d1);
                        c = "";
                    }
                    c3 = (char)operator.peek();
                    while(c3 != '('){
                        postFix.push(operator.pop());
                        c3 = (char)operator.peek();
                    }
                    operator.pop();
                    break;
                default:
                    c += c1;
                    d1 = Double.parseDouble(c);
                    if(i == num.length()){
                        postFix.push(d1);   
                    }
                    break;
            }
        }
        while(!operator.isEmpty()){
            postFix.push(operator.pop());
        }
        
        //print postfix
        System.out.print("Postfix");
        postFix.display();       
        
        //กลับข้อมูล
        while(!postFix.isEmpty()){
            operator.push(postFix.pop());
        }
        
        //คำนวณ postfix 
        try{
        while(!operator.isEmpty()){
            n1 = operator.pop();
            if(n1==o1){
                operand2 = (double)cal.pop();
                operand1 = (double)cal.pop();
                cal.push(operand1-operand2);
            }
            else if(n1==o2){
                operand2 = (double)cal.pop();
                operand1 = (double)cal.pop();
                cal.push(operand1+operand2);
            }
            else if(n1==o3){
                operand2 = (double)cal.pop();
                operand1 = (double)cal.pop();
                cal.push(operand1*operand2);
            }
            else if(n1==o4){
                operand2 = (double)cal.pop();
                operand1 = (double)cal.pop();
                cal.push(operand1/operand2);
            }
            else{
                cal.push(n1);
            }
        }
        System.out.println();
        System.out.printf("Ans = "+"%.4f\n",cal.pop());
        }catch( Exception e ) {    
            System.out.println( "Program Error. Please check the input." );
        }
    }
}