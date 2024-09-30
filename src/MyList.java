import java.util.Arrays;

public class MyList<T> {

    private int size = 5;
    private T[] list;
    private int currentSize = 0;

    @SuppressWarnings("unchecked")
    public MyList() {
        list = (T[]) new Object[this.size];
    }

    public void add(T item) {
        currentSize++;
        if(currentSize > size) {
            size++;
            list = Arrays.copyOf(list, size);
        }
        for (int i = 0; i < size; i++) {
            if (list[i] == null) {
                list[i] = item;
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void add(T item, int index) {
        currentSize++;
        if (currentSize > size) {
            size++;
        }

        if (list[index] == null) {
            list[index] = item;
            return;
        }

        T[] newList = (T[]) new Object[size];
        T[] oldList = Arrays.copyOf(list, size);

        for (int i = 0; i < size; i++) {
            if (i != index) {
                newList[i] = oldList[i];
            } else {
                newList[i] = item;
                break;
            }
        }

        for (int i = size - 1; i > index; i--) {
            newList[i] = oldList[i - 1];
        }

        list = newList;
    }

    public void delete(int index) {
        if (index > size) {
            return;
        }
        list = deleteItem(list[index], list);
    }

    public void delete(T item) {
        list = deleteItem(item, list);
    }

    public void display() {
        for (T item : list) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    private T[] deleteItem(T item, T[] arr) {
        size--;
        T[] newList = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            if (list[i] != item) {
                newList[i] = list[i];
            }
        }
        return newList;
    }

    public T[] getList() {
        return list;
    }
}
