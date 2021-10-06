package question4_3;

public class MyCircularDeque {
    private static int used = 0;
    private static int front = 0;
    private static int rear = 0;
    private static int capacity = 0;
    private static int[] a = null;

    public MyCircularDeque(int k) {
        capacity = k;
        a = new int[capacity];
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        a[front] = value;
        used++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        a[rear] = value;
        rear = (rear+1)%capacity;
        used++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        int ret = a[front];
        front = (front+1)%capacity;
        used--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        int ret = a[(rear-1+capacity)%capacity];
        rear = (rear-1+capacity)%capacity;
        used--;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return a[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return a[(rear-1+capacity)%capacity];
    }

    public boolean isEmpty() {
        return used == 0;
    }

    public boolean isFull() {
        return used == capacity;
    }
}
