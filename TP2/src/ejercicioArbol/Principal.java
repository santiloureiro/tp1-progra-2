package ejercicioArbol;

public class Principal {
    public static void main(String[] args) {
        Arbol<String> arbol = new DinArbol<String>();

        arbol.agregarRaiz("A");
        arbol.agregarHijo("A", "B");
        arbol.agregarHijo("A", "C");
        arbol.agregarHijo("B", "D");
        arbol.agregarHijo("B", "E");
        arbol.agregarHijo("C", "F");

        System.out.println("Raíz: " + arbol.raiz());
        System.out.println("Tamaño tras insertar 6 nodos: " + arbol.tamanio());

        arbol.eliminar("B"); // Elimina B, D y E (3 nodos)
        System.out.println("Tamaño tras eliminar subárbol 'B' (B, D, E): " + arbol.tamanio());

        arbol.eliminar("A"); // Elimina la raíz, queda vacío
        System.out.println("Tamaño tras eliminar raíz 'A': " + arbol.tamanio());
    }
}
