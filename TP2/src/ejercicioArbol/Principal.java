package ejercicioArbol;

public class Principal {
    public static void main(String[] args) {
        Tree<String> arbol = new DinTree<String>();

        System.out.println("¿Vacío al inicio?: " + arbol.esVacio());

        arbol.agregarRaiz("A");
        arbol.agregarHijo("A", "B");
        arbol.agregarHijo("A", "C");
        arbol.agregarHijo("B", "D");
        arbol.agregarHijo("B", "E");
        arbol.agregarHijo("C", "F");

        System.out.println("¿Vacío tras insertar?: " + arbol.esVacio());
        System.out.println("Raíz: " + arbol.raiz());
        System.out.println("Tamaño tras insertar 6 nodos: " + arbol.tamanio());
        System.out.println("Altura: " + arbol.altura());
        System.out.println("¿Contiene 'E'?: " + arbol.contiene("E"));
        System.out.println("¿Contiene 'Z'?: " + arbol.contiene("Z"));

        arbol.eliminar("B"); // Elimina B, D y E (3 nodos)
        System.out.println("Tamaño tras eliminar subárbol 'B' (B, D, E): " + arbol.tamanio());
        System.out.println("¿Contiene 'E' tras eliminar 'B'?: " + arbol.contiene("E"));

        arbol.eliminar("A"); // Elimina la raíz, queda vacío
        System.out.println("Tamaño tras eliminar raíz 'A': " + arbol.tamanio());
        System.out.println("¿Vacío tras eliminar raíz?: " + arbol.esVacio());
    }
}
