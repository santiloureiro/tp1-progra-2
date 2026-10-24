package ejercicio8;

public class EntradaImpl<K, V> implements Entry<K,V> {

    private K clave;
    private V valor;

    public EntradaImpl(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getKey() {
        return clave;
    }

    public V getValue() {
        return valor;
    }

    public void setValue(V valor) {
        this.valor = valor;
    }

    
    public String toString() {
        return "(" + clave + ", " + valor + ")";
    }
}
