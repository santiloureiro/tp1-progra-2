package clase8Ejercicio7;

public interface ArbolABB<E extends Comparable<E>> {
    public boolean buscar(E elemento);
    public void insertar(E elemento);
    public E eliminar(E elemento);
    public int size();
    public boolean isEmpty();
    public E[] elementosInOrder();
    public String toString();
}
