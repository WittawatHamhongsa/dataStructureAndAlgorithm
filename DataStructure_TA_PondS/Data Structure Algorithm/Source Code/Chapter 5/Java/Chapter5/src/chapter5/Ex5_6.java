package chapter5;

public class Ex5_6 {

    public static final int MAX_ITEMS = 15;

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();
        int items[] = new int[MAX_ITEMS];
        for (int i = 0; i < MAX_ITEMS; i++) {
            items[i] = i;
            stack.push(items[i]);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
