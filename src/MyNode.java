import Classes.ChildNode;

import java.util.LinkedList;

public class MyNode<T> {
    private int size;
    private ChildNode<T>  first;
    private ChildNode<T> last;


    public MyNode() {
        this.size = 0;
    }

    public void add(T element) {
        this.addLast(element);
    }

    public void addLast(T element) {
        size++;

        ChildNode<T> newNode = new ChildNode<>(null, null, element);

        if (size == 1) {
            this.first = newNode;
            this.last = newNode;
            return;
        }
        this.last.next = newNode;
        this.last = newNode;
    }


    public void addFirst(T element) {
        size++;

        ChildNode<T> newNode = new ChildNode<>(null, null, element);

        if (size == 1) {
            this.first = newNode;
            this.last = newNode;
            return;
        }
        ChildNode<T> tmp = this.first;

        this.first = newNode;
        this.first.next = tmp;
    }


    public void display() {
        ChildNode<T> current = first;
        for (int i = 0; i < this.size; i++) {
            System.out.println(current.element);
            current = current.next;
        }
    }

    public T peek() {
        return this.last.element;
    }

    public int getSize() {
        return size;
    }
}
