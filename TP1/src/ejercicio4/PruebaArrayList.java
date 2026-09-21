package ejercicio4;

public class Principal {
    public static void main(String[] args) {
        ListaTDA<String> lista = new ArrayList<>();

        System.out.println("¿Está vacía?: " + lista.estaVacia());

        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("C");
        lista.agregar("D");
        lista.agregar("E");

        System.out.println("Tamaño: " + lista.size());
        System.out.println("Elemento en índice 2: " + lista.obtener(2));

        System.out.println("Eliminado 'B': " + lista.eliminar("B"));
        System.out.println("Tamaño tras eliminar: " + lista.size());
        System.out.println("¿Está vacía?: " + lista.estaVacia());
    }
}
