package ejercicio8;

public interface Map<K, V> {

    public int size();

    public boolean isEmpty();

    public V get(K clave);

    public V put(K clave, V valor);

    public V remove(K clave);

    public Entry<K, V>[] entries();
}
