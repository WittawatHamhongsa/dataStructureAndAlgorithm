package Calculator;
import java.util.*;
public class Cal {
    static Stack s = new Stack();
    static LinkedList q = new LinkedList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        String t = sc.nextLine();
        StringTokenizer st = new StringTokenizer(t+" ");
        while(st.hasMoreTokens()){
            String tt = st.nextToken();
            if(tt.equals("(")){
                s.push(tt);
            }
            else if(tt.equals(")")){
                while(!s.peek().equals("(")){
                    q.add(s.pop());
                }
                s.pop();
            }
            else if(tt.equals("+")||tt.equals("-")){
                gotOper(tt,1);
            }
            else if(tt.equals("*")||tt.equals("/")){
                gotOper(tt,2);
            }
            else{
                q.add(tt);
            }    
        }
        while(!s.isEmpty()){
                q.add(s.pop());
            }
        System.out.println(q.toString());
        String x ="";
        while(!q.isEmpty()){
            x = x+q.pop()+" ";
        }
        System.out.println(completeRPN(x));
        
    }
    public static void gotOper(String tt,int num){
        
        while(!s.isEmpty()){
            if(Operater(s.peek())>=num){
                q.add(s.pop());
            }
            else break;
        }
        s.push(tt);
    }
    public static int Operater(Object tt){
        if(tt.equals("+")||tt.equals("-")){
            return 1;
        }
        else if(tt.equals("*")||tt.equals("/")){
            return 2;
        }
        else{
            return 0;
        }
    }
    static double completeRPN(String x){

      double a,b; a=b=0;
      StringTokenizer s  = new StringTokenizer(x," ");
      Stack<Double> d = new Stack();
      while(s.hasMoreTokens()){
          String o = s.nextToken();
            if(o.equals("+")){
              b=d.pop();
              a=d.pop();
              Double ans= a+b;
              d.push(ans);
          }
          else if(o.equals("-")){
              b=d.pop();
              a=d.pop();
              Double ans= a-b;
              d.push(ans);
          }
          else if(o.equals("*")){
              b=d.pop();
              a=d.pop();
              Double ans= a*b;
              d.push(ans);
          }
          else if(o.equals("/")){
               b=d.pop();
              a=d.pop();
              Double ans= a/b;
              d.push(ans);
          }
          else {
              d.push(Double.parseDouble(o));
          }
      }
      return d.pop();
   }
}