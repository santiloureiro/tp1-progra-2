package ejercicio8;

public class NodoImpl<K,V> {

        EntradaImpl<K, V> entrada;

        NodoImpl<K,V> anterior;
        NodoImpl<K,V> siguiente;

        NodoImpl(K clave, V valor) {
            entrada = new EntradaImpl<K, V>(clave, valor);
        }
    }