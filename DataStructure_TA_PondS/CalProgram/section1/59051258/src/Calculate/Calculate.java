package Calculate;

import java.util.ArrayList;
import java.util.Stack;

public class Calculate {
	private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    public static ArrayList<String> split_Input(String val) {
		String[] arr =  val.split("");
		ArrayList<String> infix = new ArrayList<String>();
		for(int i=0;i<arr.length;i++){
			if(arr[i].matches("\\W")){
				infix.add(arr[i]);
			}else if(arr[i].matches("\\d")){
				if(i<arr.length-1){
					
					if(arr[i+1].matches("\\d")||arr[i+1].equals(".")){
						
						String value = arr[i];
						for(int j=i+1;j<arr.length;j++){
							if(arr[j].matches("\\d")||arr[j].equals(".")){
								value+=arr[j];
								i++;
							}else{
								break;
							}
						}
						infix.add(value);
						continue;
					}else{
						infix.add(arr[i]);
					}
					
				}else{
					infix.add(arr[i]);
				}
			}
		}
		return infix;
	}
	
	
	
	public static ArrayList<String> infix_to_Postfix(ArrayList<String> infix) {
		Stack<String> stack = new Stack<String>();
		ArrayList<String> postfix = new ArrayList<String>();
		for(int i=0;i<infix.size();i++){
			if(!infix.get(i).matches("\\W")){
				postfix.add(infix.get(i));
			}else if(infix.get(i).matches("\\W")){
				if(stack.empty()){
					stack.push(infix.get(i));
				}else if(infix.get(i).equals("(")){
					stack.push(infix.get(i));
				}else if(infix.get(i).equals(")")){
					while(!stack.peek().equals("(")){
						postfix.add(stack.pop());
					}
					stack.pop();
				}else if(OperatorCheckLV(stack.peek())<OperatorCheckLV(infix.get(i))){
					stack.push(infix.get(i));
				}else{
					
					while((!stack.empty())?OperatorCheckLV(stack.peek())>=OperatorCheckLV(infix.get(i)):false){
						postfix.add(stack.pop());
					}
					stack.push(infix.get(i));
				}
			}
		}
		if(!stack.empty()){
			while(!stack.empty()){
				postfix.add(stack.pop());
			}
		}
		return postfix;
	}
	
	public static int OperatorCheckLV(String Op) {
		if(Op.equals("+") || Op.equals("-")){
			return 1;
		}else if(Op.equals("*") || Op.equals("/")){
			return 2;
		}else{
			return 0;
		}
		
	}
	
	public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == L_PAREN)
            	stack.push(L_PAREN);
            else if (s.charAt(i) == R_PAREN) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_PAREN) return false;
            }
        }
        return stack.isEmpty();
    }
	
	public static Double postfix_sum(ArrayList<String> postfix) {
		Stack<String> stack = new Stack<String>();
		double num1,num2,result;
		for(int i=0;i<postfix.size();i++){
			if(!postfix.get(i).matches("\\W")){
				stack.push(postfix.get(i));
			}else{
				
				num1 = Double.parseDouble(stack.pop());
				num2 = Double.parseDouble(stack.pop());
				stack.push(""+sumOp(num1,num2,postfix.get(i)));
			}
		}
		return Double.parseDouble(stack.pop());
	}
	
	public static Double sumOp(Double num2,Double num1,String op) {
		switch (op) {
		case "-":
			return num1-num2;
		case "*":
			return num1*num2;
		case "/":
			return num1/num2;
		default:
			return num1+num2;
		}
	}
	public static <T>String ArrayList_To_String(ArrayList<T> input) {
		String val="";
		for(int i=0;i<input.size();i++){
			val+=input.get(i);
		}
		return val;
	}
	
	public static boolean validate(ArrayList<String> infix) {
		if(!isBalanced(ArrayList_To_String(infix))){
			return true;
		}
		for(int i=0;i<infix.size();i++){
			if(infix.get(i).matches("\\W")&&(!infix.get(i).equals("(")&&!infix.get(i).equals(")"))){
				if(infix.get(i+1).matches("\\W")&&(!infix.get(i+1).equals("(")&&!infix.get(i+1).equals(")"))){
					return true;
				}
			}
			
		}
		return false;
	}
}
