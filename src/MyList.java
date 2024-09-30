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

    public void delete(int index) {
        if (index > size) {
            return;
        }
        list = deleteItem(list[index], list);
    }

    public void delete(T item) {

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
        T[] newList = (T[]) new Object[this.size];

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
