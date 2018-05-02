package chapter6;

public class UserQueueArray {

    public static void main(String[] args) {
        try {
            QueueArray queue = new QueueArray();
            for (int i = 0; i < 9; i++) {
                if (queue.isFull()) {
                    System.out.println("คิวเต็ม");
                } else {
                    queue.enqueue(i);
                }
            }//end for
            while (!queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
    }
}
