/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication;
public class Result {
    private double result;
    private double b;
    private double a;
    private final Stackk solve;
    private final String postfix;
    private String num;
    public Result(String output) {
        num = "";
        postfix = output;
        int stackSize=postfix.length();
        solve = new Stackk(stackSize);
    }
    public double Ans(){
        for (int i = 0; i < postfix.length(); i++) {
               char c = postfix.charAt(i);
                int space=0;
               if(('0'<=c && c<='9') && space == 0){
                num=num+c;
                }else if (c == ' ' && i < (postfix.length() - 1)){
                        space=space+1; char d = postfix.charAt(i+1);
                        if ((d != ' ') && (num != "")){
                            solve.push(Double.parseDouble(num));
                            space = 0; 
                            num = "";
                        }else if (d != ' ' && num == "") 
                            {
                              space = 0;
                              num = "";
                            }
                } else if (c == ' ' && i == (postfix.length() - 1)) {}
               else{space=0;num="";
                   b= solve.pop();
                   a= solve.pop();
                   if(c == '+'){result = a+b;}
                   if(c == '-'){result = a-b;}
                   if(c == '*'){result = a*b;}
                   if(c == '/'){result = a/b;}
                   solve.push(result);
               }    
        }
        return  solve.pop();
    }
}
 