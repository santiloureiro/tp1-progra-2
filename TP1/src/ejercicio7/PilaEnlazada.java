package ejercicio7;

public class PilaEnlazada<T> implements Pila<T> {

    private Nodo<T> tope;
    private int size;

    public PilaEnlazada() {
        this.tope = null;
        this.size = 0;
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
    public void push(T elemento) {
        Nodo<T> nuevo = new Nodo<T>(elemento, tope);
        tope = nuevo;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T elemento = tope.getDato();
        tope = tope.getSiguiente();
        size--;
        return elemento;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return tope.getDato();
    }

    @Override
    public void apilar(T elemento) {
        push(elemento);
    }

    @Override
    public T desapilar() {
        return pop();
    }

    @Override
    public T tope() {
        return top();
    }

    @Override
    public boolean esVacia() {
        return isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> actual = tope;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }
}
