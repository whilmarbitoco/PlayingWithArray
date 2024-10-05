import Classes.ChildNode;

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
        newNode.prev = this.last;
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

        newNode.next = this.first;
        this.first.prev = newNode;
        this.first = newNode;
    }

    public void delete(int index) {
        if (index >= this.size) {
            return;
        }
        size--;
        if (index == 0) {
            this.first = this.first.next;
            return;
        }

        ChildNode<T> current = first;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                ChildNode<T> next = current.prev;

                current.prev.next = current.next;
                next.prev = next;

                return;
            }
            current = current.next;
        }
    }

    public void delete(T element) {
        size--;

        ChildNode<T> current = first;
        for (int i = 0; i < this.size; i++) {
            if (current.element == element) {
                ChildNode<T> next = current.prev;

                if (current.prev == null) {
                    this.first = current.next;
                    return;
                }

                current.prev.next = current.next;
                next.prev = next;

                return;
            }
            current = current.next;
        }
    }

    public void display() {
        ChildNode<T> current = first;
        for (int i = 0; i < this.size; i++) {
            System.out.println(current.element);
            if (current.next != null) current = current.next;
        }
    }

    public void displayFromTail() {
        ChildNode<T> current = last;
        for (int i = 0; i < this.size; i++) {
            System.out.println(current.element);
            if (current.prev != null) current = current.prev;
        }
    }

    public T get(int index) {
        ChildNode<T> current = first;
        for (int i = 0; i < this.size; i++) {
            if (i == index) {
                return current.element;
            }
            current = current.next;
        }
        return null;
    }

    public T peek() {
        return this.last.element;
    }

    public int getSize() {
        return size;
    }
}
