package clase9ejercicio6;

public interface AVLTDA<E extends Comparable<E>> {
    public boolean exists(E elemento);
    public void insert(E elemento);
    public void delete(E elemento);
    public int size();
    public boolean isEmpty();
    public void mostrarPorNiveles();
    public E[] elementosInOrder();
    public String toString();
}
