
package LinkedList;

public class TestInsertion {
     public static void main(String[] args){
         LinkList myLinkList = new LinkList();
        //Create LinkList
        myLinkList.addFirst(22);
        myLinkList.addFirst(32);
        myLinkList.addFirst(360);
        myLinkList.addFirst(44);
        myLinkList.addFirst(10);
        myLinkList.printList();
        myLinkList.insertNode();
     }
}
