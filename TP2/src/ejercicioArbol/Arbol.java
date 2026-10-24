package ejercicioArbol;

public interface Arbol<T> {

    // --- Construcción y modificación ---
    void agregarRaiz(T valor);
    void agregarHijo(T padre, T hijo);
    void eliminar(T valor);

    // --- Consultas sobre el árbol ---
    boolean esVacio();
    T raiz();
    int tamanio();
    int altura();
    boolean contiene(T valor);

    // --- Consultas sobre un nodo ---
    T padre(T valor);
    List<T> hijos(T valor);
    int grado(T valor);
    boolean esHoja(T valor);
    int profundidad(T valor);

    // --- Recorridos ---
    List<T> preorden();
    List<T> postorden();
    List<T> porNiveles();
}
