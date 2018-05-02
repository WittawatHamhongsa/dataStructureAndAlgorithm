package chapter11;
import java.util.Scanner;

public class Ex11_1 {
    public static void main(String[] args) {        
        final int size = 100;
        String key = "";
        Scanner scan = new Scanner(System.in);
        Comparable[] Data = new Comparable[size];
        Comparable[] DataSort = new Comparable[size];
        int count = 0;       
        //รับข้อมูลจากคีย์บอร์ดเข้ามาเก็บไว้ในอาร์เรย์ทำจนกระทั้งกด ‘q’
  
        while (!key.equals("q")){
            System.out.print("Input Data"+(count+1)+":"); 
            key = scan.nextLine();
            if(!key.equals("q")){
                Data[count] = Integer.parseInt(key);
                ++count;
            }    
        }
        
        //เรียกใช้เมธอดในการจัดการเรียงข้อมูล  
       //!!! DataSort = เมธอดในการจัดเรียงข้อมูล(Data,count) ;  
  
        System.out.print("ข้อมูลที่ถูกจัดเรียงข้อมูล :");
        for(int i=0;i<count;i++){	                
            System.out.print(DataSort[i]+" ");
        }           
    }
}