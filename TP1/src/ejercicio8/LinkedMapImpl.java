package ejercicio8;

public class LinkedMapImpl<K, V> implements Map<K, V> {


    private NodoImpl<K,V> head;
    private NodoImpl<K,V> tail;

    private int size;

    public LinkedMapImpl() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private NodoImpl<K,V> buscarNodo(K clave) {

        NodoImpl<K,V> actual = head;

        while (actual != null) {

            if (actual.entrada.getKey().equals(clave)) {
                return actual;
            }

            actual = actual.siguiente;
        }

        return null;
    }

    public V get(K clave) {

        NodoImpl<K,V> nodo = buscarNodo(clave);

        if (nodo == null) {
            return null;
        }

        return nodo.entrada.getValue();
    }

    public V put(K clave, V valor) {

        NodoImpl<K,V> nodo = buscarNodo(clave);

        // La clave ya existe
        if (nodo != null) {

            V viejoValor = nodo.entrada.getValue();

            nodo.entrada.setValue(valor);

            return viejoValor;
        }

        // La clave no existe
        NodoImpl<K,V> nuevo = new NodoImpl(clave, valor);

        if (head == null) {

            head = nuevo;
            tail = nuevo;

        } else {

            tail.siguiente = nuevo;
            nuevo.anterior = tail;

            tail = nuevo;
        }

        size++;

        return null;
    }

    public V remove(K clave) {

        NodoImpl<K,V> nodo = buscarNodo(clave);

        if (nodo == null) {
            return null;
        }

        V valor = nodo.entrada.getValue();

        if (nodo.anterior != null) {
            nodo.anterior.siguiente = nodo.siguiente;
        } else {
            head = nodo.siguiente;
        }

        if (nodo.siguiente != null) {
            nodo.siguiente.anterior = nodo.anterior;
        } else {
            tail = nodo.anterior;
        }

        size--;

        return valor;
    }

    public EntradaImpl<K, V>[] entries() {

        EntradaImpl<K, V>[] auxArray =
                (EntradaImpl<K, V>[]) new EntradaImpl[size];

        NodoImpl<K,V> actual = head;

        for (int i = 0; i < size && actual != null; i++) {

            auxArray[i] = actual.entrada;

            actual = actual.siguiente;
        }

        return auxArray;
    }
}
