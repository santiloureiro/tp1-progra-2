package ejercicio8;

public interface Dictionary<K, V> {

    public int size();

    public boolean isEmpty();

    public void put(K clave, V valor);

    public V[] get(K clave);

    public V remove(K clave, V valor);

    public V[] remove(K clave);

    public K[] keys();
}
