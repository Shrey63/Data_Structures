import java.util.Scanner;

public class MyQueue {
    final private int[] a = new int[20];
    private int rear = -1;
    private int front = -1;
    final private int maxLen = 20;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        System.out.println("Queue Operations");
        System.out.println("\n1.Enqueue\n2.Dequeue\n3.Traverse\n4.Exit");
        int ch = sc.nextInt();

        do {
            switch (ch) {
                case 1:
                    System.out.println("Enter element to enqueue");
                    int e = sc.nextInt();
                    if (queue.isFull()) {
                        System.out.println("Queue is full");
                    } else {
                        queue.enqueue(e);
                    }
                    break;
                case 2:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                    } else {
                        System.out.println("The element Dequeued is " + queue.dequeue());
                    }
                    break;
                case 3:
                    if (queue.isEmpty()) {
                        System.out.println("Queue is Empty");
                    } else {
                        queue.traverse();
                    }
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("Queue Operations");
            System.out.println("\n1.Enqueue\n2.Dequeue\n3.Traverse\n4.Exit");
            ch = sc.nextInt();

        } while (ch != 4);
    }

    // Dequeue operation
    int dequeue() {
        int element = a[front];
        if (front == rear) {
            front = rear = -1;
        } else {
            front++;
        }
        return element;
    }

    // Enqueue operation
    void enqueue(int n) {
        if (rear == maxLen - 1) {
            System.out.println("Queue is full");
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear++;
        a[rear] = n;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Check if the queue is full
    boolean isFull() {
        return rear == maxLen - 1;
    }

    // Traverse the elements in the queue
    void traverse() {
        for (int i = front; i <= rear; i++) {
            System.out.println(a[i]);
        }
    }
}
