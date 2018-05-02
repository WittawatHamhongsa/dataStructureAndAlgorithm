package javaapplication;
import java.util.Scanner;
public class JavaApplication {
    public static void main(String[] args) {
       Scanner sn = new Scanner(System.in);
            System.out.println("Enter value : ");
        String x=sn.nextLine();
        InFix input= new InFix(x);
        String output = input.doSomething();   
            System.out.println("PostFix ="+output);
        Result sum = new Result(output);
        double result = sum.Ans();
            System.out.println("result ="+result);
    }
    
}
