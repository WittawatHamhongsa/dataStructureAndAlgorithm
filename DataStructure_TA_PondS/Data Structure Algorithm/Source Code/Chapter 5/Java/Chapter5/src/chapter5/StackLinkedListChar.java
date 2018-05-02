/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter5;

public class StackLinkedListChar {

    private NodeChar top;

    public StackLinkedListChar() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(char newItem) {
        top = new NodeChar(newItem, top);
    }

    public char pop() {
        if (!isEmpty()) {
            NodeChar temp = top;
            top = top.getNext();
            return temp.getItem();
        } else {
            return 'j';
        }
    }

    public void popAll() {
        top = null;
    }

    public char peek() {
        if (!isEmpty()) {
            return top.getItem();
        } else {
            return 'j';
        }
    }
}
