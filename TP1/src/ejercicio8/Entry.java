package ejercicio8;

public interface Entry<K,V> {

    public K getKey();

    public V getValue();

    public void setValue(V valor);

    public String toString();
}
