package ejercicio8;

import java.lang.reflect.Array;

public class LinkedDictionaryImpl<K, V> implements Dictionary<K, V> {

    private class NodoValor {

        V valor;

        NodoValor anterior;
        NodoValor siguiente;

        NodoValor(V valor) {
            this.valor = valor;
        }
    }

    private class NodoClave {

        K clave;

        NodoValor primerValor;
        NodoValor ultimoValor;

        NodoClave anterior;
        NodoClave siguiente;

        NodoClave(K clave) {
            this.clave = clave;
        }
    }

    private NodoClave head;
    private NodoClave tail;

    private int size;

    public LinkedDictionaryImpl() {

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

    // BUSCAR ALUMNO

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

    // AGREGAR NOTA

    public void put(K clave, V valor) {

        NodoClave nodoClave = buscarClave(clave);

        // Si el alumno no existe
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

        // Agregar la nota
        NodoValor nuevoValor =
                new NodoValor(valor);

        if (nodoClave.primerValor == null) {

            nodoClave.primerValor = nuevoValor;
            nodoClave.ultimoValor = nuevoValor;

        } else {

            nodoClave.ultimoValor.siguiente =
                    nuevoValor;

            nuevoValor.anterior =
                    nodoClave.ultimoValor;

            nodoClave.ultimoValor =
                    nuevoValor;
        }
    }

    // OBTENER NOTAS

    @SuppressWarnings("unchecked")
    public V[] get(K clave) {

        NodoClave nodo = buscarClave(clave);

        if (nodo == null || nodo.primerValor == null) {
            return null;
        }

        int cantidad = 0;
        NodoValor actual = nodo.primerValor;

        while (actual != null) {
            cantidad++;
            actual = actual.siguiente;
        }

        V[] valores = (V[]) Array.newInstance(
                nodo.primerValor.valor.getClass(), cantidad);

        actual = nodo.primerValor;

        for (int i = 0; i < cantidad; i++) {
            valores[i] = actual.valor;
            actual = actual.siguiente;
        }

        return valores;
    }

    // ELIMINAR UNA NOTA

    public V remove(K clave, V valor) {

        NodoClave nodoClave =
                buscarClave(clave);

        if (nodoClave == null) {
            return null;
        }

        NodoValor actual =
                nodoClave.primerValor;

        while (actual != null &&
               !actual.valor.equals(valor)) {

            actual = actual.siguiente;
        }

        if (actual == null) {
            return null;
        }

        if (actual.anterior != null) {

            actual.anterior.siguiente =
                    actual.siguiente;

        } else {

            nodoClave.primerValor =
                    actual.siguiente;
        }

        if (actual.siguiente != null) {

            actual.siguiente.anterior =
                    actual.anterior;

        } else {

            nodoClave.ultimoValor =
                    actual.anterior;
        }

        V eliminado = actual.valor;

        // Si quedó sin notas,
        // también se elimina el alumno
        if (nodoClave.primerValor == null) {

            eliminarNodoClave(nodoClave);
        }

        return eliminado;
    }

    // ELIMINAR ALUMNO

    public V[] remove(K clave) {

        NodoClave nodo =
                buscarClave(clave);

        if (nodo == null) {
            return null;
        }

        V[] valores = get(clave);

        eliminarNodoClave(nodo);

        return valores;
    }

    private void eliminarNodoClave(
            NodoClave nodo) {

        if (nodo.anterior != null) {

            nodo.anterior.siguiente =
                    nodo.siguiente;

        } else {

            head = nodo.siguiente;
        }

        if (nodo.siguiente != null) {

            nodo.siguiente.anterior =
                    nodo.anterior;

        } else {

            tail = nodo.anterior;
        }

        size--;
    }

    // OBTENER TODOS LOS DNI

    @SuppressWarnings("unchecked")
    public K[] keys() {

        if (size == 0 || head == null) {
            return null;
        }

        K[] claves = (K[]) Array.newInstance(
                head.clave.getClass(), size);

        NodoClave actual = head;

        for (int i = 0; i < size; i++) {
            claves[i] = actual.clave;
            actual = actual.siguiente;
        }

        return claves;
    }
}
