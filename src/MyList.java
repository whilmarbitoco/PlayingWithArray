import java.util.Arrays;

public class MyList<T> {

    private int size = 15;
    private T[] list;
    private int currentSize = 0;

    @SuppressWarnings("unchecked")
    public MyList() {
        list = (T[]) new Object[this.size];
    }

    public void add(T item) {
        currentSize++;
        if(currentSize > size) {
            size = (size * 3)/2 + 1;
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
        if (index > size) {
            System.err.println("MyList out of index");
            return;
        }
        currentSize++;
        if (currentSize > size) {
            size = (size * 3)/2 + 1;
            list = Arrays.copyOf(list, size);
        }

        if (list[index] == null) {
            list[index] = item;
            return;
        }


        list[index] = item;
    }

    public void delete(int index) {
        if (index > size) {
            return;
        }
        delete(list[index]);
    }

    public T get(int index) {
        if (index >= this.size) {
            return null;
        };

        return this.list[index];
    }

    @SuppressWarnings("unchecked")
    public void delete(T item) {
        currentSize--;
        T[] newList = (T[]) new Object[size];

        for (int i = 0; i < size; i++) {
            if (list[i] != item) {
                newList[i] = list[i];
            }
        }
        list = newList;
    }

    public void display() {
        for (T item : list) {
            if (item != null) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    public T[] getList() {
        return list;
    }
}
