package chapter4;

public class DoubleLinkList {
  DoubleLink newNode;
  DoubleLink head;
  DoubleLink last;
  DoubleLink curr;
  DoubleLink prev1;
  DoubleLink prev2;
  //เพิ่มข้อมูลในลิงค์ลิสต์แบบสองทิศทาง
  public void add(Object newItem) {
    if (head == null) {
      newNode = new DoubleLink(newItem);
      last = newNode;
    } else {
      newNode = new DoubleLink(newItem, head, null);
      head.setPrecede(newNode);             
      head = newNode;
    }
    head = newNode;
  }

  public boolean searchItem(Object item) {
    curr = head;
    prev1 = null;
    boolean status = false;
    while (curr != null) {
      if (curr.getItem() == item) {
        prev2 = curr.getNext();
        status = true;
        break;
      } else {
        prev1 = curr;
        curr = curr.getNext();
      }
    }

    if (status) {
      return true;
    } else {
      return false;
    }
  }

  public void deleteNode(Object item) {
    if (searchItem(item)) {
      if (prev1 == null) {
        head = curr.getNext();
        if (prev2 != null) {
          prev2.setPrecede(null);
        }
      } else if (prev2 == null) {
        prev1.setNext(null);
        curr.setPrecede(null);
        last = prev1;
      } else {
        prev1.setNext(curr.getNext());
        prev2.setPrecede(curr.getPrecede());
      }
    } else {
      System.out.println("Not found data");
    }
  }

  public void insert(Object iteminsert, Object newItem) {
    newNode = new DoubleLink(newItem);
    if (searchItem(iteminsert)) {
      prev2 = curr;
      if (prev1 == null) {
        newNode.setNext(curr);
        curr.setPrecede(newNode);
        head = newNode;
      } else {
        newNode.setNext(prev1.getNext());
        prev1.setNext(newNode);
        newNode.setPrecede(prev2.getPrecede());
        prev2.setPrecede(newNode);
      }
    } else {
      if (head == null) {
        newNode = new DoubleLink(newItem);
        last = newNode;
      } else {
        newNode = new DoubleLink( newItem,  null, last);
        last.setNext(newNode);
        last = newNode;
      }
    }
  }

  public void showdata() {
    curr = head;
    while (curr != null) {
      System.out.print(curr.getItem()+" ");
      curr = curr.getNext();
    }
    if (head != null) {
      System.out.print(" backward : ");
      curr = last;
      while (curr != null) {
        System.out.print(curr.getItem()+" ");
        curr = curr.getPrecede();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    DoubleLinkList linklist = new DoubleLinkList();
    linklist.add(9);
    System.out.print("add 9  : ");
    linklist.showdata();
    linklist.add(10);
    System.out.print("add 10 : ");
    linklist.showdata();
    linklist.add(11);
    System.out.print("add 11 : ");
    linklist.showdata();
    linklist.add(12);
    System.out.print("add 12 : ");
    linklist.showdata();
    linklist.deleteNode(10);
    System.out.print("delete 10 : ");
    linklist.showdata();
    linklist.deleteNode(12);
    System.out.print("delete 12 : ");
    linklist.showdata();
    linklist.insert(11, 15);
    System.out.print("insert 15 before 11:");
    linklist.showdata();
    linklist.insert(11, 17);
    System.out.print("insert 17 before 11:");
    linklist.showdata();
    linklist.insert(18, 19);
    System.out.print("insert 19 at last : ");
    linklist.showdata();
  }    
}
