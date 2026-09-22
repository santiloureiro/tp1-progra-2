package clase4Ejercicio4;

import ejercicio7.Nodo;

public class ColaEnlazada<T> implements Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> ultimo;
    private int size;

    public ColaEnlazada() {
        frente = null;
        ultimo = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T elemento) {
        Nodo<T> nuevo = new Nodo<T>(elemento);

        if (isEmpty()) {
            frente = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
        }

        ultimo = nuevo;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola esta vacia");
        }

        T elemento = frente.getDato();
        frente = frente.getSiguiente();
        size--;

        if (isEmpty()) {
            ultimo = null;
        }

        return elemento;
    }

    @Override
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("La cola esta vacia");
        }
        return frente.getDato();
    }
}
