package clase8Ejercicio7;

public interface Entry<K, V> {
    public K getKey();
    public V getValue();
    public void setKey(K clave);
    public void setValue(V valor);
    public String toString();
}
