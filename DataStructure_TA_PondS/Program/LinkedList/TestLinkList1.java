
package LinkedList;

import java.util.Scanner;

public class TestLinkList1 {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        LinkList myLinkList = new LinkList();
//        //Create LinkList
//        myLinkList.addFirst(50);
//        myLinkList.addFirst(40);
//        myLinkList.addFirst(30);
//        myLinkList.addFirst(20);
//        myLinkList.addFirst(10);
//        
//        System.out.print("Enter key search : ");
//        int key = sc.nextInt();
//        int index =  myLinkList.searchIndex(key);
//        System.out.println("Index = "+index);        
        
        
        //==========No. 2===============
        LinkList myLinkList = new LinkList();
        //Create LinkList
        myLinkList.addFirst("Phayathai");
        myLinkList.addFirst("Rajaprarop");
        myLinkList.addFirst("Makkasan");
        myLinkList.addFirst("Ramkhamhaeng");
        myLinkList.addFirst("Hua Mak");
        myLinkList.addFirst("Ban Thap Chang");
        myLinkList.addFirst("Lad Krabang");
        myLinkList.addFirst("Suvarnabhumi Airport");

        myLinkList.printList();
        myLinkList.reverseList();
        
        //=========No.3==================
    }
}
