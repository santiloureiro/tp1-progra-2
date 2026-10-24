package ejercicioArbol;

public class NodoArbol<T> {
    private T valor;
    private List<NodoArbol<T>> hijos;
    private NodoArbol<T> padre;

    public NodoArbol(T valor, NodoArbol<T> padre) {
        this.valor = valor;
        this.hijos = new LinkedList<NodoArbol<T>>();
        this.padre = padre;
    }

    public NodoArbol(T valor) {
        this(valor, null);
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public List<NodoArbol<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<NodoArbol<T>> hijos) {
        this.hijos = hijos;
    }

    public NodoArbol<T> getPadre() {
        return padre;
    }

    public void setPadre(NodoArbol<T> padre) {
        this.padre = padre;
    }
}
