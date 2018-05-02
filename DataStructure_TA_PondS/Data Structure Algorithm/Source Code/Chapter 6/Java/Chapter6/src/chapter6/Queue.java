package chapter6;

public class Queue {

    private Node lastNode;

    public Queue() {
        lastNode = null;
    } //end default constructor

    public boolean isEmpty() {
        return lastNode == null;
    }

    public void dequeueAll() {
        lastNode = null;
    }

    public void enqueue(int newItem) {
        Node newNode = new Node(newItem);
        if (isEmpty()) {
            newNode.setNext(newNode);
        } else {
            newNode.setNext(lastNode.getNext());
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
    }

    public Object dequeue() {
        if (!isEmpty()) {
            Node firstNode = lastNode.getNext();
            if (firstNode == lastNode) {
                lastNode = null;
            } else {
                lastNode.setNext(firstNode.getNext());
            }
            return firstNode.getItem();
        } else {
            return -1;
        }
    }

    public Object peek() {
        if (!isEmpty()) {
            Node firstNode = lastNode.getNext();
            return firstNode.getItem();
        } else {
            return -1;
        }
    }
}
