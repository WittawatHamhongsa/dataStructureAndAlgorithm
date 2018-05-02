package LinkedList;
public class LinkList {
   private Node newNode;
   private Node first = null;
   private Node last = null; 
   
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
   
   public Node deleteLast(){
       Node temp;
       if (first==null) {
            System.out.println("List is empty Cannot delete");
            return(null);
        }
       else{
           temp = last; 
           Node curr = first;
           if(first==last){
                first = null; 
                last = null;
           }else{
               while (curr.getNext()!= last){ 
                    curr = curr.getNext();
                }
               last = curr; 
               curr.setNext(null);
           }
        return temp;
       }  
   }
   
   public void printList(){
    Node curr = new Node();
    curr = first;
    while (curr != null){
        System.out.print(" ==> "+curr.getItem());
        curr = curr.getNext();
    }
    System.out.println();
   }
   
//additional   
   public int searchIndex(Object data){
    int count = 0;
    Node curr = new Node();
    curr = first;
    if(first == null){
        System.out.println("Search not found !!List is Empty!!");
        return count = -1;
    }else{
        while (curr != null){
            if(curr.getItem() == data){
                break;
            }else{
                count++;
                curr = curr.getNext();
            }
        }
        if(curr == null){
            System.out.println("Search not found");
            count = -1;
        }
        return count;
    }
   }
   
    public void reverseList(){
        LinkList reList = new LinkList();
        Node curr = new Node();
        curr = first;
        if(first == null){
            System.out.println("!!List is Empty!!");
        }else{
            while (curr != null){
                reList.addFirst(curr.getItem());
                curr = curr.getNext();
            }
        }
        reList.printList();
    }
    
    public void insertNode() {
         if(first == null){
            System.out.println("!!List is Empty!!");
        }else{
            // Make the first node the start of the sorted list.
            Node sortedList = first;
            Node temp = first.getNext();
            sortedList.setNext(null);

            while(temp != null) {
                Node current = temp;
                temp = temp.getNext();

                //เนื่องจากข้อมูลของเรามี type เป็นชนิด Object ก่อนจะเปรียบเทียบได้จึงต้องมีการ Casting ก่อน 
                // Find where current belongs. 
                if ((int)sortedList.getItem() < (int)current.getItem()) {
                    // Search list for correct position of current.
                    Node search = sortedList;
                    while(search.getNext() != null && (int)current.getItem() > (int)search.getNext().getItem())
                        search = search.getNext();
                
                    // current goes after search.
                    current.setNext(search.getNext());
                    search.setNext(current);
                } else {
                    // Current is new sorted head.
                    current.setNext(sortedList);
                    sortedList = current;
                }
            }
        
            //print sortedList
            Node curr = new Node();
            curr = sortedList;
            while (curr != null){
                System.out.print(" ==> "+curr.getItem());
                curr = curr.getNext();
            }
            System.out.println();
        }     
    }
}