package ejercicio7;

public class PilaEnlazada<T> implements Pila<T> {

    private Nodo<T> tope;
    private int size;

    public PilaEnlazada() {
        this.tope = null;
        this.size = 0;
    }

    
    public int size() {
        return size;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public void push(T elemento) {
        Nodo<T> nuevo = new Nodo<T>(elemento, tope);
        tope = nuevo;
        size++;
    }

    
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T elemento = tope.getDato();
        tope = tope.getSiguiente();
        size--;
        return elemento;
    }

    
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return tope.getDato();
    }

    
    public void apilar(T elemento) {
        push(elemento);
    }

    
    public T desapilar() {
        return pop();
    }

    
    public T tope() {
        return top();
    }

    
    public boolean esVacia() {
        return isEmpty();
    }

    
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
