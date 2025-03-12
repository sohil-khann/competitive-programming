
public class Queue {

    int arr[];
    int front, rear, max;

    Queue(int size) {
        arr = new int[size];
        max = size;
        front = rear = -1;
    }

    public void addlast(int data) {
        if (rear == max - 1) {
            System.out.println("queue is over full");
            return;
        }
        if (front == -1 && rear == -1) {
            front = 0;
            rear = 0;
            arr[rear] = data;
            return;
        }
        rear++;
        arr[rear] = data;
    }

    public void delete() {
        if (front == -1) {
            System.out.println("queue is empty");
            return;
        }
        int ele = arr[front];
        if (front == rear) {
            front = -1;
            rear = -1;
            return;
        }
        System.out.println("delete element is" + ele);
        front++;
    }

    public void printqueue() {
        if (front == -1) {
            System.out.println("empty");
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {

        Queue qq = new Queue(5);

        qq.addlast(1);
        qq.addlast(2);
        qq.addlast(3);
        qq.addlast(4);
        qq.addlast(5);
        qq.printqueue();
        qq.addlast(8);
        qq.delete();
        qq.delete();
        qq.delete();
        qq.delete();
        qq.delete();
        qq.printqueue();
        qq.addlast(5);
        qq.printqueue();
    }
}