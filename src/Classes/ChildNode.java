package Classes;

public class ChildNode<T> {
    public T element;
    public ChildNode<T> prev;
    public ChildNode<T> next;

    public ChildNode(ChildNode<T> prev, ChildNode<T> next, T element) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

}
