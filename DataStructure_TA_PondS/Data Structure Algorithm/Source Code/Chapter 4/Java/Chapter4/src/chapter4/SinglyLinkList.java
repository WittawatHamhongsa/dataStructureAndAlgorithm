 package chapter4;

public class SinglyLinkList {

    Node newNode;
    Node head;
    Node curr;
    Node prev;
    //เพิ่มโหนดในลิงค์ลิสต์

    public void add(Object newItem) {
        if (head == null) {
            newNode = new Node(newItem);
        } else {
            newNode = new Node(newItem, head);
        }
        head = newNode;
    }
    //ค้นหาข้อมูลในลิงค์ลิสต์

    public boolean searchItem(Object item) {
        curr = head;
        prev = null;
        boolean status = false;
        while (curr != null) {
            if (curr.getItem() == item) {
                status = true;
                break;
            } else {
                prev = curr;
                curr = curr.getNext();
            }
        }
        if (status) {
            return true;
        } else {
            return false;
        }
    }
    //ลบข้อมูลในลิงค์ลิสต์

    public void deleteNode(Object item) {
        if (searchItem(item)) {
            if (prev == null) {
                head = curr.getNext();
            } else {
                prev.setNext(curr.getNext());
            }
        } else {
            System.out.println("Not found item.");
        }
    }
    //แทรกโหนดในลิงค์ลิสต์

    public void insert(Object iteminsert, Object newItem) {
        newNode = new Node(newItem);
        if (searchItem(iteminsert)) {
            if (prev == null) {
                newNode.setNext(curr);
                head = newNode;
            } else {
                newNode.setNext(curr);
                prev.setNext(newNode);
            }
        } else {
            if (head == null) {
                newNode.setNext(curr);
                head = newNode;
            } else if (curr == null) {
                prev.setNext(newNode);
            }
        }
    }
    //แสดงข้อมูลในลิงค์ลิสต์ 

    public void showdata() {
        curr = head;
        while (curr != null) {
            System.out.print(curr.getItem() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }

    public static void main(String args[]) {
        SinglyLinkList linklist = new SinglyLinkList();
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
        System.out.print("insert 15 before 11 :");
        linklist.showdata();
        linklist.insert(11, 17);
        System.out.print("insert 17 before 11 :");
        linklist.showdata();
        linklist.insert(18, 19);
        System.out.print("insert 19 at last: ");
        linklist.showdata();
    }
}
