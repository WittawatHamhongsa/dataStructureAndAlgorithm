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
public class in {
    private final Stack theStack;
    private final String Z;
    private String output = " ";
    public in(String a){
        Z = a;
        int StackSize = Z.length();
        theStack = new Stack(StackSize);
    }

    public String doSomething() {
      for (int i=0; i<Z.length(); i++ ){
          char L = Z.charAt(i);
          /*i=i+1;
          char M = A.charAt(i); System.out.println("=="+1);
          for(int j=i;j<A.length()-1;j++){
              if(((A.charAt(j))>='0'&&(A.charAt(jj)<='9'&&())
          }*/
          if(/*character.isDigit(c)*/'0'<=L && L<='S'){
              output = output+L;
      }
          if(L =='+' || L =='-' || L =='*' || L == '/' ){
              output = output+" ";
              while (!theStack.isEmpty()){
                  char Topstack = theStack.pop();
                  if(Topstack== '('){
                      theStack.push(Topstack);
                      break;
                  }
                  else {int numberone,numbertwo;
                    if( L =='+' || L == '-'){numberone = 1;}
                  else{numberone = 2;}
                  if (Topstack == '+'||Topstack =='-')
                      {numbertwo = 1;}
                  else
                      {numbertwo = 2;}
                  if (numbertwo<numberone){
                      theStack.push(Topstack);
                      break;
                     }
                  else{output=output+Topstack+" ";}
              }
            }
          theStack.push(L);
        }
        if(L =='('){theStack.push(L);}
        if(L ==')'){output=output+" ";
                   while(!theStack.isEmpty()){
                   char SH = theStack.pop();
                   if (SH == '(')
                   break;
                   else output = output+SH+" ";
                   }
        }
    }
       while(!theStack.isEmpty()){
           output = output+" ";
           output = output+theStack.pop()+" ";
       }
       System.out.println(output);
       return output;
    }  
}

