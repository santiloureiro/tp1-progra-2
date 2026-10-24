package clase8Ejercicio7;

public interface Dictionary<K, V extends Comparable<V>> {
    public int size();
    public boolean isEmpty();
    public void put(K clave, V valor);
    public V[] get(K clave);
    public V remove(K clave, V valor);
    public V[] remove(K clave);
    public K[] keys();
    public Entry<K, V[]>[] entries();
}
