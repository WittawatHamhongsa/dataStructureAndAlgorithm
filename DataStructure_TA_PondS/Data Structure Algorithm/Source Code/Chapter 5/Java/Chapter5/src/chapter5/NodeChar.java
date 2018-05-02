package chapter5;

public class NodeChar {

    private char item;
    private NodeChar next;
    //begin constructor

    public NodeChar() {
        next = null;
    }

    public NodeChar(char newItem) {
        item = newItem;
        next = null;
    }

    public NodeChar(char newItem, NodeChar nextNode) {
        item = newItem;
        next = nextNode;
    }//end constructor	
    //begin method

    public void setItem(char newItem) {
        item = newItem;
    }

    public char getItem() {
        return item;
    }

    public void setNext(NodeChar nextNode) {
        next = nextNode;
    }

    public NodeChar getNext() {
        return next;
    }
}
