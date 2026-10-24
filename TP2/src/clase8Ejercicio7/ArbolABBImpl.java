package clase8Ejercicio7;

public class ArbolABBImpl<E extends Comparable<E>> implements ArbolABB<E> {
    private NodoABB<E> root;
    private int size;

    public ArbolABBImpl() {
        this.root = null;
        this.size = 0;
    }

    
    public int size() {
        return size;
    }

    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public boolean buscar(E elemento) {
        if (elemento == null) {
            return false;
        }
        return buscar(root, elemento);
    }

    private boolean buscar(NodoABB<E> node, E value) {
        if (node == null) {
            return false;
        }
        int cmp = value.compareTo(node.data);
        if (cmp == 0) {
            return true;
        }
        return (cmp < 0) ? buscar(node.left, value) : buscar(node.right, value);
    }

    
    public void insertar(E elemento) {
        if (elemento == null) {
            return;
        }
        root = insertar(root, elemento);
    }

    private NodoABB<E> insertar(NodoABB<E> node, E data) {
        if (node == null) {
            size++;
            return new NodoABB<E>(data);
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = insertar(node.left, data);
        } else if (cmp > 0) {
            node.right = insertar(node.right, data);
        }
        return node;
    }

    
    public E eliminar(E elemento) {
        if (elemento == null || !buscar(elemento)) {
            return null;
        }
        root = eliminar(root, elemento);
        size--;
        return elemento;
    }

    private NodoABB<E> eliminar(NodoABB<E> node, E data) {
        if (node == null) {
            return null;
        }
        int cmp = data.compareTo(node.data);
        if (cmp < 0) {
            node.left = eliminar(node.left, data);
        } else if (cmp > 0) {
            node.right = eliminar(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            NodoABB<E> min = minValueNode(node.right);
            node.data = min.data;
            node.right = eliminar(node.right, min.data);
        }
        return node;
    }

    private NodoABB<E> minValueNode(NodoABB<E> node) {
        NodoABB<E> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    
    @SuppressWarnings("unchecked")
    public E[] elementosInOrder() {
        if (size == 0) {
            return null;
        }
        E[] resultado = (E[]) new Comparable[size];
         cargarInOrder(root, resultado, 0);
        return resultado;
    }

    private int cargarInOrder(NodoABB<E> node, E[] arreglo, int index) {
        if (node == null) {
            return index;
        }
        index = cargarInOrder(node.left, arreglo, index);
        arreglo[index++] = node.data;
        index = cargarInOrder(node.right, arreglo, index);
        return index;
    }

    
    public String toString() {
        if (root == null) {
            return "";
        }
        return inOrderTraversalString(root);
    }

    private String inOrderTraversalString(NodoABB<E> node) {
        if (node != null) {
            return "( " + inOrderTraversalString(node.left) + node.data + " " + inOrderTraversalString(node.right) + " )";
        }
        return "";
    }
}
