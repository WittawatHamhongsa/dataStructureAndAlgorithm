package chapter6;

public class Ex6_4 {

    public static void main(String[] args) {
        try {
            Queue queue = new Queue();
            for (int i = 0; i < 9; i++) {
                queue.enqueue(i);
            }//end for
            while (!queue.isEmpty()) {
                System.out.print(queue.dequeue() + " ");
            }
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
    }
}
