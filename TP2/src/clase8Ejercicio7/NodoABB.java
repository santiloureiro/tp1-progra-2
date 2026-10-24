package clase8Ejercicio7;

public class NodoABB<E> {
    E data;
    NodoABB<E> left;
    NodoABB<E> right;

    public NodoABB(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
