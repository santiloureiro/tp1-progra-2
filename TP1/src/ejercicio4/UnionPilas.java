package clase4ejercicio4;

import ejercicio7.Pila;
import ejercicio7.PilaEnlazada;

public class UnionPilas {

    public static Pila<Cola<Integer>> unir(Pila<Cola<Integer>> p1,
                                          Pila<Cola<Integer>> p2) {
        Pila<Cola<Integer>> copia1 = copiarPila(p1);
        Pila<Cola<Integer>> copia2 = copiarPila(p2);
        Pila<Cola<Integer>> auxiliar = new PilaEnlazada<>();
        Pila<Cola<Integer>> pout = new PilaEnlazada<>();

        // Pasamos primero la cola de mayor tamaño.
        while (!copia1.isEmpty() && !copia2.isEmpty()) {
            if (copia1.top().size() >= copia2.top().size()) {
                auxiliar.push(copia1.pop());
            } else {
                auxiliar.push(copia2.pop());
            }
        }

        while (!copia1.isEmpty()) {
            auxiliar.push(copia1.pop());
        }

        while (!copia2.isEmpty()) {
            auxiliar.push(copia2.pop());
        }

        // Invertimos para dejar las colas de mayor tamaño en el tope.
        while (!auxiliar.isEmpty()) {
            pout.push(auxiliar.pop());
        }

        return pout;
    }

    private static Pila<Cola<Integer>> copiarPila(Pila<Cola<Integer>> original) {
        Pila<Cola<Integer>> auxiliar = new PilaEnlazada<>();
        Pila<Cola<Integer>> copia = new PilaEnlazada<>();

        while (!original.isEmpty()) {
            auxiliar.push(original.pop());
        }

        while (!auxiliar.isEmpty()) {
            Cola<Integer> cola = auxiliar.pop();
            original.push(cola);
            copia.push(cola);
        }

        return copia;
    }
}
