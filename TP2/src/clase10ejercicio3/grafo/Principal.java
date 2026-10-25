package grafo;

import List.LinkedList;

public class Principal {

	public static void main(String[] args) {
		GrafoDin<String> grafo = new GrafoDin<String>();

		grafo.agregarVertice("A");
		grafo.agregarVertice("B");
		grafo.agregarVertice("C");
		grafo.agregarVertice("D");
		grafo.agregarVertice("E");
		grafo.agregarVertice("F");
		grafo.agregarVertice("G");

		grafo.agregarArista("A", "B", 4);
		grafo.agregarArista("A", "C", 2);
		grafo.agregarArista("B", "D", 5);
		grafo.agregarArista("C", "D", 3);
		grafo.agregarArista("D", "E", 7);
		grafo.agregarArista("F", "A", 1);

		System.out.print("Vertices aislados: ");
		mostrarLista(grafo.verticesAislados());

		System.out.print("Vertices puente entre A y D: ");
		mostrarLista(grafo.verticesPuente("A", "D"));

		System.out.print("Vertices puente entre B y C: ");
		mostrarLista(grafo.verticesPuente("B", "C"));

		grafo.eliminarVertice("D");
		System.out.print("Aislados despues de eliminar D: ");
		mostrarLista(grafo.verticesAislados());
	}

	
	public static <E> void mostrarLista(LinkedList<E> lista) {
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
