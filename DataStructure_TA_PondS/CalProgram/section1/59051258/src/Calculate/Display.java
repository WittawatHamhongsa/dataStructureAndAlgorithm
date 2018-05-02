package Calculate;

import java.util.ArrayList;

public class Display {
	private static int width=30;
	public static void setWidth(int w) {
		width=w;
	}
	public static void newLine() {
		System.out.println();
	}
	
	public static void printdash(int w) {
		for(int i=0;i<w;i++){
			System.out.print("-");
		}
	}
	
	public static void printspace(int w) {
		for(int i=0;i<w;i++){
			System.out.print(" ");
		}
	}
	
	public static <T> void print(T val,String txt) {
		String valTxt = String.format("%.2f", val);
		int sumLen = txt.length()+valTxt.length()+8;
		System.out.print("+");
		printdash(width);
		System.out.println("+");
		System.out.print("| >> "+txt+" : "+valTxt);
		printspace((width+2)-sumLen);
		System.out.println("|");
		System.out.print("+");
		printdash(width);
		System.out.println("+");
	}
	
	public static void printError(String txt,String warning) {
		int sumLen = txt.length()+16+19+warning.length();
		System.out.print("+");
		printdash(sumLen);
		System.out.println("+");
		System.out.print("| !! Error !! : "+txt+" , ## Warning ## : "+warning);
		printspace(1);
		System.out.println("|");
		System.out.print("+");
		printdash(sumLen);
		System.out.println("+");
	}
	
	public static <T>void printF(T val,String txt) {
		String valTxt = String.format("%.2f", val);
		int sumLen = txt.length()+valTxt.length()+8;
		System.out.print("+");
		printdash(width);
		System.out.println("+");
		System.out.print("| >> "+txt+" : "+valTxt);
		printspace((width+1)-sumLen);
		System.out.println("|");
		System.out.print("+");
		printdash(width);
		System.out.println("+");
	}
	
	public static <T>void printArr(T[] val,String txt) {
		int sumLen = txt.length()+1;	
		System.out.print("+");
		printdash(width);
		System.out.println("+");
		System.out.print("| "+txt);
		printspace((width+1)-sumLen);
		System.out.println("|");
		System.out.print("+");
		printdash(width);
		System.out.println("+");
		System.out.print("   ");
		for(int i=0;i<val.length;i++){
			System.out.print(val[i]+" ");
		}
		System.out.print("+");
		printdash(width);
		System.out.println("+");
	}
	public static <T>void printArr(ArrayList<T> val,String txt) {
		int sumLen = txt.length()+1,sumLen2;	
		System.out.print("+");
		printdash(width);
		System.out.println("+");
		System.out.print("| "+txt);
		printspace((width)-sumLen);
		System.out.println("|");
		System.out.print("+");
		printdash(width);
		System.out.println("+");
		System.out.print("|  ");
		String arrTXT="";
		for(int i=0;i<val.size();i++){
			arrTXT+=val.get(i)+" ";
		}
		sumLen2=arrTXT.length()+3;
		System.out.print(arrTXT);
		printspace((width+1)-sumLen2);
		System.out.println("|");
		System.out.print("+");
		printdash(width);
		System.out.println("+");
	}
}
