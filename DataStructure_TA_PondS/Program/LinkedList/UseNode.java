package LinkedList;
public class UseNode{
    public static void main(String[] args){
        //Node n = new Node(9);
   	//Node first = new Node(19,n);     
        //Node curr = new Node();
        //curr = first;
        //while (curr != null){
        //    System.out.println(curr.getItem());
        //    curr = curr.getNext();
        //}

//finished 2
        
        //Node first = new Node();  
        //Node newNode = new Node(6);
        //first = newNode;
        //newNode = new Node(9); 
        //newNode.setNext(first); 
        //first = newNode; 
        //Node curr = new Node();
        //curr = first;
        //while (curr != null){
        //  System.out.println(curr.getItem());
        //  curr = curr.getNext();
        //}

//finished 4
        
        //LinkList myLinkList = new LinkList();
        //System.out.println("======== add 6 and 9 in first node =========");
        //myLinkList.addFirst(6);
        //myLinkList.addFirst(9);
        //myLinkList.addLast(98);   //No.6
        //myLinkList.printList();
        //System.out.println("=== add 10 in first node and add 22 in last===");
        //myLinkList.addFirst(10);
        //myLinkList.addLast(22);   //No.6
        //myLinkList.printList();
     
//finished 5 and 6
    
       LinkList myLinkListA = new LinkList();
       LinkList myLinkListB = new LinkList();
       LinkList myLinkListC = new LinkList();
       LinkList myLinkListD = new LinkList();
       LinkList myLinkListE = myLinkListD;
       
        myLinkListA.addFirst(5);
        myLinkListA.addFirst(6);
        
        myLinkListB.addFirst(9);
        myLinkListB.addFirst(11);
        
        myLinkListA.addLast(20);
        myLinkListA.addLast(22);
        myLinkListA.addLast(38);
        
        myLinkListB.addLast(44);
        myLinkListB.addLast(55);
        
       myLinkListC.addFirst(myLinkListA.deleteFirst().getItem());
       myLinkListC.addFirst(myLinkListB.deleteLast().getItem());

       int a = (int) myLinkListA.deleteFirst().getItem();
       int b = (int) myLinkListB.deleteFirst().getItem();
     
       myLinkListB.addLast(a+b);
       
       myLinkListD.addFirst("Ant");
       myLinkListD.addFirst("Bat");
       myLinkListD.addFirst("Cat");
       myLinkListD.addFirst("Dog");
       
       System.out.println("Data fo myLinkListA is");
       myLinkListA.printList();
       System.out.println("\nData fo myLinkListB is");
       myLinkListB.printList();
       System.out.println("\nData fo myLinkListC is");
       myLinkListC.printList();
       System.out.println("\nData fo myLinkListD is");
       myLinkListD.printList();
    }
}

