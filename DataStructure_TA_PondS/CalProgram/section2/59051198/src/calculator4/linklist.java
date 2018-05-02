package calculator4;
public class linklist<E> {
    Node<E> first;
    Node<E> last;
    int size = 0;
    public linklist() {
        first = null;
        last = null;
    }

    public void push(E value) {                 //insertfirt
        Node<E> n = new Node<>(value, null);
        if (first == null) {
            first = n;
            last = n;
        } else {
            n.next = first;
            first = n;
        }
        size++;
        
    }
    public E pop() {                       //delete first
        Node<E> temp = first;
        if (first == last) {
            first = last = null;
        }
        else
            first = first.next;
        size--;
        return (temp.iData);
    }
      public boolean isEmpty() {
        return size == 0;
    }
      public E peek(){
          Node<E>f=first;
          return(f.iData);
      }

}

