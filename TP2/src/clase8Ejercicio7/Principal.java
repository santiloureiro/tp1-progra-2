package clase8Ejercicio7;

public class Principal {
    public static void main(String[] args) {
        Dictionary<String, Integer> dicc = new ABBDictionaryImpl<String, Integer>();

        dicc.put("AlumnoA", 8);
        dicc.put("AlumnoA", 4);
        dicc.put("AlumnoA", 10);
        dicc.put("AlumnoA", 6);
        dicc.put("AlumnoB", 7);
        dicc.put("AlumnoB", 9);

        System.out.println("Cantidad de claves: " + dicc.size());

        Comparable[] valoresA = dicc.get("AlumnoA");
        System.out.print("Valores de AlumnoA (ordenados en ABB): ");
        for (int i = 0; i < valoresA.length; i++) {
            System.out.print(valoresA[i] + " ");
        }
        System.out.println();

        dicc.remove("AlumnoA", 8);
        valoresA = dicc.get("AlumnoA");
        System.out.print("Valores de AlumnoA tras eliminar 8: ");
        for (int i = 0; i < valoresA.length; i++) {
            System.out.print(valoresA[i] + " ");
        }
        System.out.println();

        dicc.remove("AlumnoB");
        System.out.println("Cantidad de claves tras eliminar AlumnoB: " + dicc.size());
    }
}
