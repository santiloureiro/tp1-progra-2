package ejercicio7;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("   VALIDADOR DE PARÉNTESIS CON PILA ENLAZADA     ");
        System.out.println("=================================================");

        System.out.print("Ingrese una cadena de caracteres: ");
        if (scanner.hasNextLine()) {
            String entrada = scanner.nextLine();
            boolean resultado = ValidadorParentesis.validar(entrada);

            System.out.println("\nResultado: " + (resultado ? "verdadero" : "falso"));
            if (resultado) {
                System.out.println("Explicación: Se cerraron correctamente todos los paréntesis abiertos.");
            } else {
                System.out.println("Explicación: Paréntesis desbalanceados (falta cerrar o se cerró un paréntesis sin abrir).");
            }
        }

        scanner.close();
    }
}
