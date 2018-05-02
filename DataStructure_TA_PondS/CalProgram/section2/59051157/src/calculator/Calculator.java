package calculator;
import java.util.Scanner;
public class Calculator {
    
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        System.out.print("Enter value : ");
        String num = sn.next();
        stack a = new stack();
        a.calculat(num);
        
    }
}