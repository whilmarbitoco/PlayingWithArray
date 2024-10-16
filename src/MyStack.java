import Classes.ChildNode;

public class MyStack<T> {
    private int size;
    private ChildNode<T> head;

    public MyStack() {
        this.size = 0;
    }

    public void add(T item) {
        ChildNode<T> tmp = new ChildNode<>(null, null, item);
        if (size == 0) {
            this.head = tmp;
            size++;
            return;
        }

        tmp.prev = head;
        head = tmp;
    }

    public T pop() {
       ChildNode<T> tmp = this.head;
        this.head = this.head.prev;

        return tmp.element;

    }

    public T peek() {
        return this.head.element;
    }

    public boolean contains(T element) {
        ChildNode<T> curr = this.head;
        while (curr != null){

            if (curr.element == element) {
                return true;
            }

            curr = curr.prev;
        }
        return false;
    }

    public void display() {
        ChildNode<T> curr = this.head;
        while (curr != null){
            System.out.print(curr.element + " ");
            curr = curr.prev;
        }
        System.out.println();
    }

}
