package Classes;

public class MapNode<K, V> {
    public K key;
    public V value;
    public MapNode<K, V> next;
    public MapNode<K, V> prev;

    public MapNode(K key, V value, MapNode<K, V> next, MapNode<K, V> prev) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
