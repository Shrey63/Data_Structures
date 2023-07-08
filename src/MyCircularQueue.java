import java.util.Scanner;

public class MyCircularQueue {
    final private int[] a = new int[5];
    private int rear = -1;
    private int front = -1;
    final private int maxLen = 5;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyCircularQueue s = new MyCircularQueue();
        System.out.print("Queue Operations");
        System.out.println("\n1.Enqueue\n2.Dequeue\n3.Traverse\n4.Exit");
        int ch = sc.nextInt();
        do {
            switch (ch) {
                case 1:
                    if (s.isFull()) {
                        System.out.println("Queue is full");
                    } else {
                        System.out.println("Enter element to enqueue");
                        int e = sc.nextInt();
                        s.enqueue(e);
                    }
                    break;
                case 2:
                    if (s.isEmpty()) {
                        System.out.println("Queue is Empty");
                    } else {
                        System.out.println("The element Dequeued is " + s.dequeue());
                    }
                    break;
                case 3:
                    if (s.isEmpty()) {
                        System.out.println("Queue is Empty");
                    } else {
                        s.traverse();
                    }
                    break;
                case 4:
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.print("Queue Operations");
            System.out.println("\n1.Enqueue\n2.Dequeue\n3.Traverse\n4.Exit");
            ch = sc.nextInt();
        } while (ch != 4);
    }

    // Dequeue operation
    int dequeue() {
        int element = a[front];
        if (rear == front) {
            rear = front = -1;
        } else {
            front = (front + 1) % maxLen; // Circularly increment front index
        }
        return element;
    }

    // Enqueue operation
    void enqueue(int n) {
        if (front == -1) {
            front = rear = 0;
        } else {
            rear=(rear+1)%maxLen;
        }
        a[rear] = n;
    }

    // Check if the queue is empty
    boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    // Check if the queue is full
    boolean isFull() {
        return front == (rear + 1) % maxLen;
    }

    // Traverse the elements in the queue
    void traverse() {
        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                System.out.println(a[i]);
            }
        } else {
            for (int i = front; i < maxLen; i++) {
                System.out.println(a[i]);
            }
            for (int i = 0; i <= rear; i++) {
                System.out.println(a[i]);
            }
        }
    }
}
