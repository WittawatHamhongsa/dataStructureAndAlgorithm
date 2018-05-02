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
import java.io.IOException;
import java.util.Scanner;
public class CCL {
    public static void main(String[] args)throws IOException {
      Scanner sn = new Scanner (System.in);
      System.out.println("Enter value : ");
      String a = sn.nextLine();
      in input = new in (a);
      String output = input.doSomething();
      System.out.println("Portfix = "+output);
      Result Sum = new Result(output);
      double result = Sum.Answer();
      System.out.println("result = "+result);
    }
}
