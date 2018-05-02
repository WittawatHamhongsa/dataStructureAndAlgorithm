package Calculate;

import java.util.*;

public class index {

	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		String Input = getInput.nextLine();
		ArrayList<String> infix = Calculate.split_Input(Input);
		
		while(Calculate.validate(infix)){
			Display.printError("Infix isn't incorrect","Please input again");
			Input = getInput.nextLine();
			infix = Calculate.split_Input(Input);
		}
		
		Display.setWidth(60);
		
		Display.newLine();
		Display.printArr(infix,"INFIX");
		Display.newLine();
		
		ArrayList<String> postfix = Calculate.infix_to_Postfix(infix);
		double result = Calculate.postfix_sum(postfix);
		
		Display.printArr(postfix,"POSTFIX");
		Display.newLine();
		Display.printF(result,"RESULT");
		
	}
	
}
