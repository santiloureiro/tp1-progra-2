package grafo;
import List.LinkedList;

public class GrafoDin<E> implements GrafoTDA<E> {
	private NodoVertice<E> origen;
	private int vertices;
	
	public GrafoDin() {
		origen = null;
		vertices = 0;
	}
	
	public void agregarVertice(E v) { 
		NodoVertice<E> aux = new NodoVertice<E>();
		aux.setVertice(v);
		aux.setAristas(null);
		aux.setSigVertice(origen);
		origen = aux;
		vertices++;
	}
	
	public void eliminarVertice(E v) {
		
		if (origen.getVertice().equals(v)) {
			origen = origen.getSigVertice();
		} else {
			NodoVertice<E> aux = origen;
			while (!aux.getSigVertice().getVertice().equals(v)) {
				aux = aux.getSigVertice();
			}
			aux.setSigVertice(aux.getSigVertice().getSigVertice());
		}
		vertices--;

		
		NodoVertice<E> aux = origen;
		while (aux != null) {
			eliminarAristaNodo(aux, v);
			aux = aux.getSigVertice();
		}
	}

	private void eliminarAristaNodo(NodoVertice<E> nodo, E v) {
		NodoArista<E> aux = nodo.getAristas();
		if (aux != null) {
			if (aux.getVerticeDestino().getVertice().equals(v)) { 
				nodo.setAristas(aux.getSigArista());
			}
			else { 
				while (aux.getSigArista() != null && !aux.getSigArista().getVerticeDestino().getVertice().equals(v))
					aux = aux.getSigArista();
				if (aux.getSigArista() != null) { 
					aux.setSigArista(aux.getSigArista().getSigArista());
				}
			}
		}
	}
	
	public E[] vertices() {
		E[] salida = (E[])new Object[vertices];
		NodoVertice<E> aux = origen;
		int i = 0;
		while (aux != null) {
			salida[i]=aux.getVertice();
			i++;
			aux = aux.getSigVertice();
		}
		return salida;
	}
	
	public void agregarArista(E v1, E v2, int peso ) {
		NodoVertice<E> n1 = vert2Nodo(v1); 
		NodoVertice<E> n2 = vert2Nodo(v2); 
		NodoArista<E> aux = new NodoArista<E>(); 
		aux.setPeso(peso); 
		aux.setVerticeDestino(n2);
		aux.setSigArista(n1.getAristas());
		n1.setAristas(aux);
	}
	
	private NodoVertice<E> vert2Nodo(E v) { 
		NodoVertice<E> aux = origen;
		while (aux != null && !aux.getVertice().equals(v))
			aux = aux.getSigVertice();
		return aux;
	}
	
	public void eliminarArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		eliminarAristaNodo(n1, v2);
	}
	
	public boolean existeArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (aux != null && !aux.getVerticeDestino().getVertice().equals(v2)) {
			aux = aux.getSigArista();
		}
		
		return aux != null;
	}
	
	public int pesoArista(E v1, E v2) {
		NodoVertice<E> n1 = vert2Nodo(v1);
		NodoArista<E> aux = n1.getAristas();
		while (!aux.getVerticeDestino().getVertice().equals(v2))
			aux = aux.getSigArista(); 
		return aux.getPeso();
	}

	
	public LinkedList<E> verticesAislados() {
		LinkedList<E> resultado = new LinkedList<E>();
		NodoVertice<E> actual = origen;

		while (actual != null) {
			
			boolean aislado = actual.getAristas() == null;

			
			NodoVertice<E> otro = origen;
			while (aislado && otro != null) {
				if (existeArista(otro.getVertice(), actual.getVertice())) {
					aislado = false;
				}
				otro = otro.getSigVertice();
			}

			if (aislado) {
				resultado.addLast(actual.getVertice());
			}
			actual = actual.getSigVertice();
		}
		return resultado;
	}

	
	public LinkedList<E> verticesPuente(E v1, E v2) {
		LinkedList<E> resultado = new LinkedList<E>();
		NodoVertice<E> nodoOrigen = vert2Nodo(v1);
		NodoArista<E> arista = nodoOrigen.getAristas();

		while (arista != null) {
			E candidato = arista.getVerticeDestino().getVertice();
			if (existeArista(candidato, v2)) {
				resultado.addLast(candidato);
			}
			arista = arista.getSigArista();
		}
		return resultado;
	}
}
