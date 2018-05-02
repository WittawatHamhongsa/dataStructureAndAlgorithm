package calculator;
class Node {
    Object idata;
    Node next;
    Node prev;
    
    public Node (Object v,Node n,Node t){
        idata = v;
        next = n;
        prev = t;
    }
}