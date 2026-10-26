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
        System.out.println("¿Tiene 'E'?: " + arbol.contiene("E"));
        System.out.println("¿Tiene 'Z'?: " + arbol.contiene("Z"));

        System.out.println("\nConsultas sobre un nodo");
        System.out.println("Padre de 'D': " + arbol.padre("D"));
        System.out.println("Padre de 'A' (raíz): " + arbol.padre("A"));
        System.out.print("Hijos de 'A': ");
        mostrarLista(arbol.hijos("A"));
        System.out.print("Hijos de 'B': ");
        mostrarLista(arbol.hijos("B"));
        System.out.print("Hijos de 'F' (hoja): ");
        mostrarLista(arbol.hijos("F"));
        System.out.println("Grado de 'A': " + arbol.grado("A"));
        System.out.println("Grado de 'C': " + arbol.grado("C"));
        System.out.println("¿'E' es hoja?: " + arbol.esHoja("E"));
        System.out.println("¿'B' es hoja?: " + arbol.esHoja("B"));
        System.out.println("Profundidad de 'A' (raíz): " + arbol.profundidad("A"));
        System.out.println("Profundidad de 'C': " + arbol.profundidad("C"));
        System.out.println("Profundidad de 'E': " + arbol.profundidad("E"));

        List<String> copia = arbol.hijos("A");
        copia.addLast("Z");
        System.out.println("Grado de 'A' después de modificar la copia: " + arbol.grado("A"));

        System.out.println("\nRecorridos");
        System.out.print("Preorden:    ");
        mostrarLista(arbol.preorden());
        System.out.print("Postorden:   ");
        mostrarLista(arbol.postorden());
        System.out.print("Por niveles: ");
        mostrarLista(arbol.porNiveles());
        System.out.println();

        arbol.eliminar("B"); // Elimina B, D y E
        System.out.println("Tamaño tras eliminar subárbol 'B' (B, D, E): " + arbol.tamanio());
        System.out.println("¿Tiene 'E' tras eliminar 'B'?: " + arbol.contiene("E"));
        System.out.print("Hijos de 'A' tras eliminar 'B': ");
        mostrarLista(arbol.hijos("A"));

        arbol.eliminar("A"); // Elimina la raiz
        System.out.println("Tamaño tras eliminar raíz 'A': " + arbol.tamanio());
        System.out.println("¿Vacío tras eliminar raíz?: " + arbol.esVacio());
    }

    private static <T> void mostrarLista(List<T> lista) {
        lista.First();
        System.out.print("[");
        while (!lista.atEnd()) {
            System.out.print(lista.getCurrent());
            lista.advance();
            if (!lista.atEnd()) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
