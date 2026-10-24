package clase8Ejercicio7;

public class ABBDictionaryImpl<K, V extends Comparable<V>> implements Dictionary<K, V> {

    private class NodoClave {
        K clave;
        ArbolABB<V> valores;
        NodoClave anterior;
        NodoClave siguiente;

        NodoClave(K clave) {
            this.clave = clave;
            this.valores = new ArbolABBImpl<V>();
        }
    }

    private NodoClave head;
    private NodoClave tail;
    private int size;

    public ABBDictionaryImpl() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private NodoClave buscarClave(K clave) {
        NodoClave actual = head;
        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public void put(K clave, V valor) {
        if (clave == null || valor == null) {
            return;
        }

        NodoClave nodoClave = buscarClave(clave);

        if (nodoClave == null) {
            nodoClave = new NodoClave(clave);

            if (head == null) {
                head = nodoClave;
                tail = nodoClave;
            } else {
                tail.siguiente = nodoClave;
                nodoClave.anterior = tail;
                tail = nodoClave;
            }

            size++;
        }

        nodoClave.valores.insertar(valor);
    }

    public V[] get(K clave) {
        NodoClave nodo = buscarClave(clave);
        if (nodo == null || nodo.valores.isEmpty()) {
            return null;
        }
        return nodo.valores.elementosInOrder();
    }

    public V remove(K clave, V valor) {
        NodoClave nodoClave = buscarClave(clave);
        if (nodoClave == null) {
            return null;
        }

        V eliminado = nodoClave.valores.eliminar(valor);
        if (eliminado == null) {
            return null;
        }

        if (nodoClave.valores.isEmpty()) {
            eliminarNodoClave(nodoClave);
        }

        return eliminado;
    }

    public V[] remove(K clave) {
        NodoClave nodo = buscarClave(clave);
        if (nodo == null) {
            return null;
        }

        V[] valores = nodo.valores.elementosInOrder();
        eliminarNodoClave(nodo);
        return valores;
    }

    private void eliminarNodoClave(NodoClave nodo) {
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
    }

    @SuppressWarnings("unchecked")
    public K[] keys() {
        if (size == 0 || head == null) {
            return null;
        }

        K[] claves = (K[]) new Object[size];
        NodoClave actual = head;

        for (int i = 0; i < size; i++) {
            claves[i] = actual.clave;
            actual = actual.siguiente;
        }

        return claves;
    }

    @SuppressWarnings("unchecked")
    public Entry<K, V[]>[] entries() {
        if (size == 0 || head == null) {
            return null;
        }

        Entry<K, V[]>[] entradas = (Entry<K, V[]>[]) new Entry[size];
        NodoClave actual = head;

        for (int i = 0; i < size; i++) {
            entradas[i] = new EntradaImpl<K, V[]>(actual.clave, actual.valores.elementosInOrder());
            actual = actual.siguiente;
        }

        return entradas;
    }
}
