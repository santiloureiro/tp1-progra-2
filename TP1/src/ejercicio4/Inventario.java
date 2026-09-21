package ejercicio4;

public class Inventario {
    private ListaTDA<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.agregar(producto);
    }

    public boolean eliminarProducto(int id) {
        Producto producto = buscarPorId(id);
        if (producto == null) {
            return false;
        }
        return productos.eliminar(producto);
    }

    public Producto buscarPorId(int id) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.obtener(i);
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public Producto buscarPorNombre(String nombre) {
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.obtener(i);
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public ListaTDA<Producto> filtrarPorCategoria(String categoria) {
        ListaTDA<Producto> resultado = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.obtener(i);
            if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.agregar(producto);
            }
        }
        return resultado;
    }

    public ListaTDA<Producto> productosConStockBajo(int umbral) {
        ListaTDA<Producto> resultado = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.obtener(i);
            if (producto.getCantidad() < umbral) {
                resultado.agregar(producto);
            }
        }
        return resultado;
    }

    public double valorTotal() {
        double total = 0;
        for (int i = 0; i < productos.size(); i++) {
            Producto producto = productos.obtener(i);
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    public ListaTDA<Producto> getProductos() {
        return productos;
    }

    public int size() {
        return productos.size();
    }

    public boolean estaVacio() {
        return productos.estaVacia();
    }
}
