package clase9ejercicio6;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AVLTDA<Integer> arbol = new AVL<Integer>();

        System.out.println("Ingrese numeros ('.' para finalizar):");
        String entrada = scanner.nextLine();
        while (!entrada.equals(".")) {
            arbol.insert(Integer.parseInt(entrada));
            entrada = scanner.nextLine();
        }

        System.out.println("Arbol por niveles:");
        arbol.mostrarPorNiveles();

        Comparable[] ordenados = arbol.elementosInOrder();
        System.out.print("Arreglo ordenado: ");
        for (int i = 0; i < ordenados.length; i++) {
            System.out.print(ordenados[i] + " ");
        }
        System.out.println();
    }
}
