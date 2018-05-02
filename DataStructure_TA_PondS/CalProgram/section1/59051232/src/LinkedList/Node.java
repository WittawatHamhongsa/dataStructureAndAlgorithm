package LinkedList;
public class Node{
   private Object item;
   Node next;
   public Node() {
      next = null;
   }
   public Node(Object newItem){
      item = newItem;
      next = null;
   }
   public Node(Object newItem,Node nextNode){
      item = newItem;
      next = nextNode;
   }//end constructor	
   //begin method
   public void setItem(Object newItem){
      item = newItem;
   }
   public Object getItem (){
      return item;
   }
   public void setNext(Node nextNode){
      next = nextNode;
   }
   public Node getNext() {
      return next;
   }
}
