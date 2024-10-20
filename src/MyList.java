import java.util.Arrays;

public class MyList<T> {

    private int size = 5;
    private T[] list;
    private int currentSize = 0;

    @SuppressWarnings("unchecked")
    public MyList() {
        list = (T[]) new Object[this.size];
    }

    private void grow() {
        size = (size * 3)/2 + 1;
        list = Arrays.copyOf(list, size);
    }

    public void add(T item) {
        currentSize++;
        if(currentSize > size) {
           grow();
        }

        for (int i = 0; i < size; i++) {
            if (list[i] == null) {
                list[i] = item;
                return;
            }
        }
    }

    public void add(T item, int index) {
        if (index > size) {
            System.err.println("MyList out of index");
            return;
        }
        currentSize++;
        if (currentSize > size) {
            grow();
        }

        if (list[index] == null) {
            list[index] = item;
            return;
        }

        for (int i = size - 1; i > index ; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;

    }

    public void delete(int index) {
        if (index > size) {
            System.err.println("Index is more than size");
            return;
        }
//        delete(list[index]);
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        currentSize--;
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
