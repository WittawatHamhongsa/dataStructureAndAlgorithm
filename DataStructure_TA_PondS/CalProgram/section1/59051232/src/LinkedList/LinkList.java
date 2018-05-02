package LinkedList;
public class LinkList {
   private Node newNode;
   public Node first = null;
   private Node last = null; 
   int count=0;
   
   public void addFirst(Object newItem){
       newNode = new Node(newItem);
       if(first == null){
          first = newNode;
          last = first;
      }else{
          newNode.setNext(first);
          first = newNode;
      }
   }
   
   public void addLast(Object newItem){
       newNode = new Node(newItem);
       if(first == null){
          first = newNode;
          last = first;
       }else{
          last.setNext(newNode);
          last = newNode;
       }
   }
   
   public Node deleteFirst(){
       Node temp;
       if (first==null) {
            System.out.println("List is empty. Cannot delete");
            return(null);
       }
       else{
            temp = first;
            if(last == first){
                first = null; 
                last = null;
            }
            else{
                first = first.getNext();
            }
           temp.setNext(null);
           return temp;
        }
   }
   
   
   public void printList(){
    Node curr = new Node();
    curr = first;
    while (curr != null){
        System.out.print("=> "+curr.getItem());
        curr = curr.getNext();
    }
    System.out.println();
   }
   

   public int sizeList() {
        if (first==null){
             System.out.println ("List is Empty");}
        else {
             Node p;
            p=first;
            count=0;
            while (p!=null)
                {count++;
                p=p.next;}
                    //System.out.println("count="+count);
        }
        return count;
       }
}