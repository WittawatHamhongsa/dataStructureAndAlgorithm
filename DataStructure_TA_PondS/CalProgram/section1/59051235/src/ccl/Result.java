/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ccl;

/**
 *
 * @author admin
 */
public class Result {
    private double result;
    private double m;
    private double n;
    private final Stack2 solve;
    private final String postfix;
    private String num;
    public Result(String output){
        num = " ";
        postfix = output;
        int stackSize = postfix.length();
        solve = new Stack2(stackSize);
    }
    public double Answer(){
        for (int i=0 ; i<postfix.length(); i++){
            char L = postfix.charAt(i);
            int Space = 0;
            if (('0'<=L && L<='9') && Space == 0 ){
             //"double number = L-'0'"//
            num = num+L;
            System.out.println(num);
            /*solve.push(num);*/                   
        }
            else if ( L== ' ' && i <(postfix.length() - 1)) {
                 Space = Space +1;
                 char K = postfix.charAt(i+1);
                 if ((K!= ' ') && (num != " ")){
                     solve.push(Double.parseDouble(num));
                     Space = 0;
                     num = " ";              
                    }
                 else if (K != ' ' && num == " "){
                     Space = 0;
                     num = " ";
            }                      
    }   
            else if (L == ' ' && i == (postfix.length() -1)) {      
        }
    else{
            Space = 0;
            num = " ";
            m =solve.pop();
            n =solve.pop();
            if(L == '+'){result= n+m;}
            if(L == '-'){result= n-m;}
            if(L == '*'){result= n*m;}
            if(L == '/'){result= n/m;}
            solve.push(result);
            }
        } 
        return solve.pop();           
    }    
}
