package clase4ejercicio4;

import ejercicio7.Pila;
import ejercicio7.PilaEnlazada;

public class Principal {

    public static void main(String[] args) {
        Pila<Cola<Integer>> p1 = new PilaEnlazada<>();
        Pila<Cola<Integer>> p2 = new PilaEnlazada<>();

        Cola<Integer> cola1 = new ColaEnlazada<>();
        cola1.enqueue(10);

        Cola<Integer> cola2 = new ColaEnlazada<>();
        cola2.enqueue(20);
        cola2.enqueue(30);
        cola2.enqueue(40);

        Cola<Integer> cola3 = new ColaEnlazada<>();
        cola3.enqueue(50);
        cola3.enqueue(60);

        Cola<Integer> cola4 = new ColaEnlazada<>();
        cola4.enqueue(70);
        cola4.enqueue(80);
        cola4.enqueue(90);
        cola4.enqueue(100);

        // Se apilan de menor a mayor tamaño.
        p1.push(cola1);
        p1.push(cola2);
        p2.push(cola3);
        p2.push(cola4);

        System.out.println("P1 (desde el tope):");
        mostrarPila(p1);
        System.out.println("P2 (desde el tope):");
        mostrarPila(p2);

        Pila<Cola<Integer>> pout = UnionPilas.unir(p1, p2);

        System.out.println("Pout (desde el tope):");
        mostrarPila(pout);

        System.out.println("P1 despues de la union:");
        mostrarPila(p1);
        System.out.println("P2 despues de la union:");
        mostrarPila(p2);
    }

    private static void mostrarPila(Pila<Cola<Integer>> pila) {
        Pila<Cola<Integer>> auxiliar = new PilaEnlazada<>();

        while (!pila.isEmpty()) {
            Cola<Integer> cola = pila.pop();
            System.out.print("Tamaño " + cola.size() + ": ");
            mostrarCola(cola);
            auxiliar.push(cola);
        }

        while (!auxiliar.isEmpty()) {
            pila.push(auxiliar.pop());
        }
    }

    private static void mostrarCola(Cola<Integer> cola) {
        int cantidad = cola.size();
        System.out.print("[");

        // Una vuelta completa deja los elementos en su orden original.
        for (int i = 0; i < cantidad; i++) {
            int numero = cola.dequeue();
            System.out.print(numero);
            if (i < cantidad - 1) {
                System.out.print(", ");
            }
            cola.enqueue(numero);
        }

        System.out.println("]");
    }
}
