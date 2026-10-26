package clase10ejercicio2;

public class Principal {

	public static void main(String[] args) {
		GrafoEst<String> grafo = new GrafoEst<String>();

		grafo.agregarVertice("A");
		grafo.agregarVertice("B");
		grafo.agregarVertice("C");
		grafo.agregarVertice("D");
		grafo.agregarVertice("E");
		grafo.agregarVertice("F");
		grafo.agregarVertice("G");

		grafo.agregarArista("A", "B", 4);
		grafo.agregarArista("A", "C", 2);
		grafo.agregarArista("A", "D", 9);
		grafo.agregarArista("B", "D", 5);
		grafo.agregarArista("C", "D", 3);
		grafo.agregarArista("D", "E", 7);
		grafo.agregarArista("F", "A", 1);

		System.out.println("Matriz de adyacencia:");
		mostrarMatriz(grafo);

		System.out.println();
		System.out.println("Mayor costo saliente de A: " + grafo.mayorCostoSaliente("A"));
		System.out.println("Mayor costo saliente de D: " + grafo.mayorCostoSaliente("D"));
		System.out.println("Mayor costo saliente de E (no tiene salientes): " + grafo.mayorCostoSaliente("E"));

		System.out.print("Predecesores de D: ");
		mostrarLista(grafo.predecesores("D"));
		System.out.print("Predecesores de A: ");
		mostrarLista(grafo.predecesores("A"));
		System.out.print("Predecesores de G (aislado): ");
		mostrarLista(grafo.predecesores("G"));

		// Al eliminar B, el último vértice (G) pasa a ocupar su fila y su columna
		grafo.eliminarVertice("B");
		System.out.println();
		System.out.println("Matriz despues de eliminar B:");
		mostrarMatriz(grafo);

		System.out.print("Predecesores de D sin B: ");
		mostrarLista(grafo.predecesores("D"));

		grafo.eliminarArista("A", "D");
		System.out.println("Mayor costo saliente de A sin la arista A->D: " + grafo.mayorCostoSaliente("A"));
	}

	// Muestra la matriz usando solo operaciones del TDA (lado usuario).
	public static <E> void mostrarMatriz(GrafoTDA<E> g) {
		E[] vs = g.vertices();
		System.out.print("\t");
		for (int j = 0; j < vs.length; j++) {
			System.out.print(vs[j] + "\t");
		}
		System.out.println();
		for (int i = 0; i < vs.length; i++) {
			System.out.print(vs[i] + "\t");
			for (int j = 0; j < vs.length; j++) {
				int peso = 0;
				if (g.existeArista(vs[i], vs[j])) {
					peso = g.pesoArista(vs[i], vs[j]);
				}
				System.out.print(peso + "\t");
			}
			System.out.println();
		}
	}

	public static <E> void mostrarLista(List<E> lista) {
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
