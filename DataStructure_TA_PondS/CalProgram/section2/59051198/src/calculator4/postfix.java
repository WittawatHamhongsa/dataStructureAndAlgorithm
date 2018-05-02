package calculator4;
import java.util.Scanner;
import java.util.StringTokenizer;
public class postfix {

    public static void main(String[] args) {
        postfix post = new postfix();
    }

    public postfix() {
        boolean repeat = true;
        while (repeat ) {
            Scanner sn = new Scanner(System.in);
            System.out.print("Enter equation :");
            String expression = sn.nextLine();
            Check(expression);
            String test = intopostfix(expression);
            System.out.println("postfix :" + test);
            cal(test);
            System.out.print("Exit [y/n] : ");
            Scanner sn2 = new Scanner(System.in);
            String re = sn.nextLine();
            if (re.equals("n")) {
                continue;
            }
            if (re.equals("y")) {
                break;
            } else {
                break;
            }
            
        }

    }
   
    public boolean Check(String g) {
        try {
            Float.parseFloat(g);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public float cal(String s) {
        linklist<Float> link = new linklist<Float>();
        String[] arr = s.split(" ");
        float o1 = 0;
        float o2 = 0;
        float ans = 0;
        for (int i = 0; i < arr.length; i++) {
            String a = arr[i];
            if (!operation(a)) {
                float b = Float.parseFloat(a); //parseFloat(a) รับ parameter string
                link.push(b);
            }
            if (operation(a)) {
                if (a.equals("+")) {
                    o1 = link.pop();
                    o2 = link.pop();
                    ans = o2 + o1;
                    link.push(ans);
                }
                if (a.equals("-")) {
                    o1 = link.pop();
                    o2 = link.pop();
                    ans = o2 - o1;
                    link.push(ans);
                }
                if (a.equals("*")) {
                    o1 = link.pop();
                    o2 = link.pop();
                    ans = o2 * o1;
                    link.push(ans);
                }
                if (a.equals("/")) {
                    o1 = link.pop();
                    o2 = link.pop();
                    ans = o2 / o1;
                    link.push(ans);
                }
            }

        }
        System.out.println("ans :" + ans);
        return ans;

    }

    public boolean operation(String op) {      
        switch (op) {
            case "+":
                return true;
            case "-":
                return true;

            case "*":
                return true;

            case "/":
                return true;
            default:
                return false;
        }
    }


    public int priority(String op) {                     //ลำดับความสำคัญoperation
        switch (op) {
            case "*":
                return 2;
            case "/":
                return 2;
            case "+":
                return 1;
            case "-":
                return 1;
            default:
                return 0;
        }
    }

    public String intopostfix(String expression) {
        linklist<String> op = new linklist<String>();                      
        String postfix = "";
        StringTokenizer st = new StringTokenizer(expression);               //แบ่งคำเมื่อเจอช่องว่าง
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            String c = s.substring(0);                                       
            if (!operation(c) && !c.equals("(")&&!c.equals(")")) {
                postfix += (s + " ");
            } else if (c.equals("(")) {
                op.push(c);
            } else if (operation(c)) {
                boolean repeat = true;
                while (repeat == true) {
                    repeat = false;
                    if (op.isEmpty() || op.peek().equals("(") || priority(c) > priority(op.peek())) {
                        op.push(c);
                    } else {
                        postfix += (op.pop() + " ");
                        repeat = true;
                    }
                }
            } else if (c.equals(")")) {
                if (operation(op.peek())) {
                    postfix += (op.pop()) + " ";
                }
            } else if (op.peek().equals("(")) {
                op.pop();
            }
        }
        int i = 0;
        while (!op.isEmpty()) {

            if (operation(op.peek())) {
                postfix += (op.pop() + " ");
            } else if (op.peek().equals("(")) {
                op.pop();
            }
        }

        return postfix;
    }

}
