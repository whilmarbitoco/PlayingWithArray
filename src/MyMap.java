import Classes.ChildNode;
import Classes.MapNode;

public class MyMap<K, V> {

    final private int size = 30;
    final private MapNode<K, V>[] maps = new MapNode[size];
    private int currentSize = 0;

    public void put(K key, V value) {
        currentSize++;
        int index = key.hashCode() % size;
        MapNode<K, V> newNode = new MapNode<>(key, value, null, null);

        if (maps[index] == null || maps[index].key == key) {
            maps[index] = newNode;
            return;
        }

        MapNode<K, V> tmp = maps[index];
        tmp.prev = newNode;
        newNode.next = tmp;
        maps[index] = newNode;

    }

    public V get(K key) {
        int index = key.hashCode() % size;

        if (maps[index] == null) {
            return null;
        }

        if (maps[index].key.equals(key)) {
            return maps[index].value;
        }

        MapNode<K, V> tmp = maps[index].next;
        while (tmp != null) {
            if (tmp.key.equals(key)) return tmp.value;
            tmp = tmp.next;
        }

        return  null;
    }

    public Boolean containsKey(K key) {
        return this.get(key) != null;
    }

    public Boolean containsValue(V value) {

        for (int i = 0; i < size; i++) {
            if (maps[i] != null && maps[i].value == value) return true;

            if (maps[i] != null && maps[i].value != null && maps[i].next != null) {
                MapNode<K, V> tmp = maps[i].next;
                while (tmp != null) {
                    if (tmp.value == value) {
                        return true;
                    }
                    tmp = tmp.next;
                }
            }

        }
        return false;
    }

    public void delete(K key) {
        int index = key.hashCode() % size;

        if (maps[index] != null && maps[index].key.equals(key)) {
             maps[index] = maps[index].next;
             currentSize--;
             return;
        }

        if (maps[index].next != null) {
            MapNode<K, V> curr = maps[index].next;
            while (curr != null) {
                if (curr.key.equals(key)) {
                    if (curr.next == null) {
                        curr.prev.next = null;
                        currentSize--;
                        return;
                    }
                    curr.prev = curr.next.prev;
                    curr.next = curr.prev.next;
                    currentSize--;
                    return;
                }
                curr = curr.next;
            }
        }
    }


    public void display() {
        for (int i = 0; i < size; i++) {
            if (maps[i] != null) {
                System.out.print(maps[i].value + " ");

                if (maps[i].next != null) {
                    MapNode<K, V> tmp = maps[i].next;
                    while (tmp != null) {
                        System.out.print(tmp.value + " ");
                        tmp = tmp.next;
                    }
                }

            }
           }
    }

    public int getSize() {
        return this.currentSize;
    }


}
