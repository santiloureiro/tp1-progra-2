package ejercicio7;

public interface Pila<T> {

    int size();

    boolean isEmpty();

    void push(T elemento);

    T pop();

    T top();

    // Métodos en español por compatibilidad
    void apilar(T elemento);

    T desapilar();

    T tope();

    boolean esVacia();
}
