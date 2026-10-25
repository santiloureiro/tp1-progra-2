package ejercicioArbol;

public class DinTree<T> implements Tree<T> {
    private TreeNode<T> raiz;
    private int tamanio;

    public DinTree() {
        this.raiz = null;
        this.tamanio = 0;
    }

    private TreeNode<T> buscarNodo(TreeNode<T> actual, T valor) {
        if (actual == null || valor == null) {
            return null;
        }
        if (actual.getValor().equals(valor)) {
            return actual;
        }
        List<TreeNode<T>> hijos = actual.getHijos();
        hijos.First();
        while (!hijos.atEnd()) {
            TreeNode<T> encontrado = buscarNodo(hijos.getCurrent(), valor);
            if (encontrado != null) {
                return encontrado;
            }
            hijos.advance();
        }
        return null;
    }

    private int contarNodos(TreeNode<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        int cantidad = 1;
        List<TreeNode<T>> hijos = nodo.getHijos();
        hijos.First();
        while (!hijos.atEnd()) {
            cantidad += contarNodos(hijos.getCurrent());
            hijos.advance();
        }
        return cantidad;
    }

    public void agregarRaiz(T valor) {
        if (raiz != null || valor == null) {
            return;
        }
        raiz = new TreeNode<T>(valor, null);
        tamanio = 1;
    }

    public void agregarHijo(T padre, T hijo) {
        if (padre == null || hijo == null || raiz == null) {
            return;
        }
        TreeNode<T> nodoPadre = buscarNodo(raiz, padre);
        if (nodoPadre == null || buscarNodo(raiz, hijo) != null) {
            return;
        }
        TreeNode<T> nuevoHijo = new TreeNode<T>(hijo, nodoPadre);
        nodoPadre.getHijos().addLast(nuevoHijo);
        tamanio++;
    }

    public void eliminar(T valor) {
        if (valor == null || raiz == null) {
            return;
        }
        TreeNode<T> nodoEliminar = buscarNodo(raiz, valor);
        if (nodoEliminar == null) {
            return;
        }
        if (nodoEliminar == raiz) {
            raiz = null;
            tamanio = 0;
            return;
        }
        int cantidadEliminada = contarNodos(nodoEliminar);
        TreeNode<T> nodoPadre = nodoEliminar.getPadre();
        if (nodoPadre != null) {
            nodoPadre.getHijos().remove(nodoEliminar);
        }
        nodoEliminar.setPadre(null);
        tamanio -= cantidadEliminada;
    }

    public boolean esVacio() {
        return tamanio == 0;
    }

    public T raiz() {
        return (raiz != null) ? raiz.getValor() : null;
    }

    public int tamanio() {
        return tamanio;
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(TreeNode<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        int mayorAlturaHijo = -1;
        List<TreeNode<T>> hijos = nodo.getHijos();
        hijos.First();
        while (!hijos.atEnd()) {
            mayorAlturaHijo = Math.max(mayorAlturaHijo, altura(hijos.getCurrent()));
            hijos.advance();
        }
        return mayorAlturaHijo + 1;
    }

    public boolean contiene(T valor) {
        return buscarNodo(raiz, valor) != null;
    }

    public T padre(T valor) {
        return null;
    }

    public List<T> hijos(T valor) {
        return null;
    }

    public int grado(T valor) {
        return 0;
    }

    public boolean esHoja(T valor) {
        return false;
    }

    public int profundidad(T valor) {
        return 0;
    }

    public List<T> preorden() {
        return null;
    }

    public List<T> postorden() {
        return null;
    }

    public List<T> porNiveles() {
        return null;
    }
}
