package clase10ejercicio2;

/*
 * Implementación estática del TDA Grafo con matriz de adyacencia.
 * - etiquetas[i] guarda el vértice que corresponde a la fila i y a la columna i.
 * - mAdy[i][j] guarda el peso de la arista etiquetas[i] -> etiquetas[j].
 *   Un 0 significa que NO hay arista, por eso se asume que todo peso es > 0.
 */
public class GrafoEst<E> implements GrafoTDA<E> {
	private static final int MAX = 100;
	private int[][] mAdy;
	private E[] etiquetas;
	private int cantVertices;

	@SuppressWarnings("unchecked")
	public GrafoEst() {
		mAdy = new int[MAX][MAX];
		etiquetas = (E[]) new Object[MAX];
		cantVertices = 0;
	}

	// Precondición: v no existe y hay lugar (cantVertices < MAX).
	public void agregarVertice(E v) {
		etiquetas[cantVertices] = v;
		// la fila y la columna nuevas arrancan sin aristas
		for (int i = 0; i <= cantVertices; i++) {
			mAdy[cantVertices][i] = 0;
			mAdy[i][cantVertices] = 0;
		}
		cantVertices++;
	}

	// Precondición: v existe.
	// Como en ArrayMap: en vez de correr todo, el último vértice pasa a ocupar
	// la fila, la columna y la etiqueta del vértice eliminado.
	public void eliminarVertice(E v) {
		int ind = vert2Indice(v);
		int ultimo = cantVertices - 1;
		for (int k = 0; k < cantVertices; k++) {
			mAdy[k][ind] = mAdy[k][ultimo];
		}
		for (int k = 0; k < cantVertices; k++) {
			mAdy[ind][k] = mAdy[ultimo][k];
		}
		etiquetas[ind] = etiquetas[ultimo];
		etiquetas[ultimo] = null;
		cantVertices--;
	}

	// Devuelve la posición de v en etiquetas, o -1 si no está.
	private int vert2Indice(E v) {
		int i = cantVertices - 1;
		while (i >= 0 && !etiquetas[i].equals(v)) {
			i--;
		}
		return i;
	}

	// Devuelve una copia: el usuario no puede tocar el arreglo interno.
	@SuppressWarnings("unchecked")
	public E[] vertices() {
		E[] salida = (E[]) new Object[cantVertices];
		for (int i = 0; i < cantVertices; i++) {
			salida[i] = etiquetas[i];
		}
		return salida;
	}

	// Precondición: v1 y v2 existen y peso > 0.
	public void agregarArista(E v1, E v2, int peso) {
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		mAdy[o][d] = peso;
	}

	// Precondición: v1 y v2 existen.
	public void eliminarArista(E v1, E v2) {
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		mAdy[o][d] = 0;
	}

	// Precondición: v1 y v2 existen.
	public boolean existeArista(E v1, E v2) {
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		return mAdy[o][d] != 0;
	}

	// Precondición: existe la arista v1 -> v2.
	public int pesoArista(E v1, E v2) {
		int o = vert2Indice(v1);
		int d = vert2Indice(v2);
		return mAdy[o][d];
	}

	// --- Métodos agregados (Clase 10 - Ejercicio 2) ---

	// Mayor costo de las aristas que SALEN de v.
	// Las aristas salientes de v están en su FILA: se recorre la fila buscando el máximo.
	// Precondición: v existe. Si v no tiene aristas salientes devuelve 0.
	public int mayorCostoSaliente(E v) {
		int fila = vert2Indice(v);
		int mayor = 0;
		for (int j = 0; j < cantVertices; j++) {
			if (mAdy[fila][j] > mayor) {
				mayor = mAdy[fila][j];
			}
		}
		return mayor;
	}

	// Predecesores de v: todos los vértices x que tienen una arista x -> v.
	// Las aristas que LLEGAN a v están en su COLUMNA: se recorre la columna.
	// Precondición: v existe. Devuelve una lista nueva (vacía si no tiene predecesores).
	public List<E> predecesores(E v) {
		int columna = vert2Indice(v);
		List<E> resultado = new LinkedList<E>();
		for (int i = 0; i < cantVertices; i++) {
			if (mAdy[i][columna] != 0) {
				resultado.addLast(etiquetas[i]);
			}
		}
		return resultado;
	}
}
