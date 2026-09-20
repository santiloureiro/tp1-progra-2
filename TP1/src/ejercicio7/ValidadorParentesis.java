package ejercicio7;

public class ValidadorParentesis {

    /**
     * Valida si se cerraron todos los paréntesis que se abrieron utilizando una PilaEnlazada.
     *
     * @param cadena Cadena de caracteres a validar.
     * @return true si los paréntesis están balanceados y todos los abiertos se cerraron, false de lo contrario.
     */
    public static boolean validar(String cadena) {
        if (cadena == null) {
            return false;
        }

        PilaEnlazada<Character> pila = new PilaEnlazada<Character>();

        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);

            if (caracter == '(') {
                pila.push(caracter);
            } else if (caracter == ')') {
                // Si encontramos un ')' pero la pila está vacía,
                // significa que se cerró un paréntesis sin haber uno abierto previo.
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            }
        }

        // Si la pila está vacía, todos los paréntesis que se abrieron fueron cerrados.
        return pila.isEmpty();
    }
}
