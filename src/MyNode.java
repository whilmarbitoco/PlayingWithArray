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
        ChildNode<T> current = first;

        for (int i = 0; i < this.size; i++) {
            if (current.element.equals(element)) {
                ChildNode<T> next = current.prev;

                if (current.prev == null) {
                    this.first = current.next;
                    return;
                }

                current.prev.next = current.next;
                next.prev = next;
                size--;
                return;
            }

            current = current.next;
        }
    }

    public void recursiveDelete(T target) {
        recursiveDeleteHelper(first, target);
    }

    private void recursiveDeleteHelper(ChildNode<T> current, T target) {
        if (current == null) return;

        if (current.element.equals(target)) {
            ChildNode<T> next = current.prev;

            if (current.prev == null) {
                this.first = current.next;
                return;
            }

            current.prev.next = current.next;
            next.prev = next;
            size--;
            return;
        }

        recursiveDeleteHelper(current.next, target);
    }

    public void recursiveDisplay() {
//        might change everything to recursion
        MyList<T> els = new MyList<>();
        recursiveDisplayHelper(first, els);
//        System.out.println();
        els.display();
    }

    @SuppressWarnings("unchecked")
    private void recursiveDisplayHelper(ChildNode<T> current, MyList<T> t) {

        if (current == null) return;
        t.add(current.element);
        recursiveDisplayHelper(current.next, t);

    }

    public void display() {
        ChildNode<T> current = first;

        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
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

    public T recursiveGet(int index) {
        return recursiveGetHelper(index, 0, first);
    }

    private T recursiveGetHelper(int index, int currentIndex, ChildNode<T> current) {
        if (current == null) return null;

        if (index == currentIndex) {
            return current.element;
        }
       return recursiveGetHelper(index, currentIndex + 1, current.next);

    }

    public T peek() {
        return this.last.element;
    }

    public int getSize() {
        return size;
    }
}
