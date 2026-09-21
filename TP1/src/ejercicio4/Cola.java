package clase4ejercicio4;

public interface Cola<T> {

    int size();

    boolean isEmpty();

    void enqueue(T elemento);

    T dequeue();

    T front();
}
