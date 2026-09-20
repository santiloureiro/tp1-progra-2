package ejercicio8;

public class PrincipalPrueba {

    public static void main(String[] args) {

        LogicaNotas logica =
                new LogicaNotasImpl();

        // MATERIA 1

        Map<Integer, Integer>
            materia1 = new LinkedMapImpl
            <Integer, Integer>();

        materia1.put(111, 8);
        materia1.put(222, 5);
        materia1.put(333, 7);

        logica.setUltimoMapeo(materia1);

        logica.consolidarUltimoMapeo();

        // MATERIA 2

        Map<Integer, Integer>
            materia2 = new LinkedMapImpl
            <Integer, Integer>();

        materia2.put(111, 6);
        materia2.put(222, 9);
        materia2.put(333, 8);

        logica.setUltimoMapeo(materia2);

        logica.consolidarUltimoMapeo();

        // AGREGAR UNA NOTA EXTRA

        logica.agregarNota(111, 10);

        // MOSTRAR TODOS

        System.out.println(
                "===== ALUMNOS =====");

        Integer[] alumnos =
                logica.obtenerAlumnos();

        for (int i = 0; i < alumnos.length; i++) {

            Integer dni = alumnos[i];

            System.out.print(
                    "DNI: " + dni);

            System.out.print(
                    " | Notas: ");

            Integer[] notas =
                    logica.obtenerNotas(dni);

            for (int j = 0; j < notas.length; j++) {

                System.out.print(
                        notas[j] + " ");
            }

            System.out.println(
                    "| Promedio: "
                    + logica.calcularPromedio(dni));
        }

        // QUITAR UNA NOTA

        System.out.println();

        System.out.println(
                "Quitamos la nota 6 del DNI 111");

        logica.quitarNota(111, 6);

        System.out.print(
                "Notas actuales: ");

        Integer[] notas111 =
                logica.obtenerNotas(111);

        for (int i = 0; i < notas111.length; i++) {

            System.out.print(
                    notas111[i] + " ");
        }

        System.out.println();

        System.out.println(
                "Nuevo promedio: "
                + logica.calcularPromedio(111));

        // QUITAR ALUMNO

        System.out.println();

        System.out.println(
                "Eliminamos DNI 222");

        logica.quitarAlumno(222);

        System.out.println();

        System.out.println(
                "===== ALUMNOS FINALES =====");

        Integer[] alumnosFinales =
                logica.obtenerAlumnos();

        for (int i = 0; i < alumnosFinales.length; i++) {

            Integer dni = alumnosFinales[i];

            System.out.println(
                    "DNI: "
                    + dni
                    + " | Promedio: "
                    + logica.calcularPromedio(dni));
        }
    }
}
