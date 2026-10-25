package ejercicioArbol;

public class TreeNode<T> {
    private T valor;
    private List<TreeNode<T>> hijos;
    private TreeNode<T> padre;

    public TreeNode(T valor, TreeNode<T> padre) {
        this.valor = valor;
        this.hijos = new LinkedList<TreeNode<T>>();
        this.padre = padre;
    }

    public TreeNode(T valor) {
        this(valor, null);
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public List<TreeNode<T>> getHijos() {
        return hijos;
    }

    public void setHijos(List<TreeNode<T>> hijos) {
        this.hijos = hijos;
    }

    public TreeNode<T> getPadre() {
        return padre;
    }

    public void setPadre(TreeNode<T> padre) {
        this.padre = padre;
    }
}
