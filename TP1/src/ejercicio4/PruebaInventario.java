package ejercicio4;

public class PruebaInventario {
    public static void main(String[] args) {
        Inventario inv = new Inventario();

        System.out.println("Vacio: " + inv.estaVacio());

        inv.agregarProducto(new Producto(1, "Teclado", "Perifericos", 15000, 10));
        inv.agregarProducto(new Producto(2, "Mouse", "Perifericos", 8000, 3));
        inv.agregarProducto(new Producto(3, "Monitor", "Pantallas", 120000, 5));
        inv.agregarProducto(new Producto(4, "Notebook", "Computadoras", 900000, 2));

        System.out.println("Productos cargados: " + inv.size());
        System.out.println("Busco id 2: " + inv.buscarPorId(2));
        System.out.println("Busco nombre Monitor: " + inv.buscarPorNombre("Monitor"));

        System.out.println("Perifericos:");
        ListaTDA<Producto> perifericos = inv.filtrarPorCategoria("Perifericos");
        for (int i = 0; i < perifericos.size(); i++) {
            System.out.println(perifericos.obtener(i));
        }

        System.out.println("Stock bajo (menos de 5):");
        ListaTDA<Producto> stockBajo = inv.productosConStockBajo(5);
        for (int i = 0; i < stockBajo.size(); i++) {
            System.out.println(stockBajo.obtener(i));
        }

        System.out.println("Valor total: " + inv.valorTotal());

        inv.eliminarProducto(1);
        System.out.println("Elimine el id 1, quedan: " + inv.size());
        System.out.println("Valor total ahora: " + inv.valorTotal());
    }
}
