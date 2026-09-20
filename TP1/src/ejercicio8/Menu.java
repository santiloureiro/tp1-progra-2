package ejercicio8;

import java.util.Scanner;

public class Menu {

    private final LogicaNotas logica;
    private final Scanner scanner;

    public Menu() {
        this.logica = new LogicaNotasImpl();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            mostrarMenu();
            int opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    cargarMapeoMateria();
                    break;
                case 2:
                    mostrarUltimoMapeo();
                    break;
                case 3:
                    agregarUltimoMapeoAlDiccionario();
                    break;
                case 4:
                    agregarNota();
                    break;
                case 5:
                    quitarNota();
                    break;
                case 6:
                    quitarAlumno();
                    break;
                case 7:
                    mostrarNotasAlumno();
                    break;
                case 8:
                    mostrarTodosLosAlumnos();
                    break;
                case 9:
                    mostrarTodosLosAlumnosYPromedio();
                    break;
                case 0:
                    salir = true;
                    System.out.println("\n¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n========================================================");
        System.out.println("                   MENÚ PRINCIPAL                       ");
        System.out.println("========================================================");
        System.out.println("1. Cargar un mapeo con notas de una materia");
        System.out.println("2. Mostrar el último mapeo cargado");
        System.out.println("3. Agregar el último mapeo cargado al Diccionario general");
        System.out.println("4. Agregar una nota para un DNI específico");
        System.out.println("5. Quitar una nota para un DNI específico");
        System.out.println("6. Quitar un alumno");
        System.out.println("7. Mostrar las notas de un alumno");
        System.out.println("8. Mostrar todos los alumnos");
        System.out.println("9. Mostrar todos los alumnos y su promedio de notas");
        System.out.println("0. Salir");
        System.out.println("========================================================");
    }

    // 1
    private void cargarMapeoMateria() {
        Map<Integer, Integer> mapeo = new LinkedMapImpl<Integer, Integer>();
        System.out.println("\n--- Cargar mapeo de materia (ingrese DNI -1 para finalizar) ---");

        while (true) {
            int dni = leerEntero("DNI: ");
            if (dni == -1) {
                break;
            }

            int nota = leerEntero("Nota (0-10): ");
            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                continue;
            }

            mapeo.put(dni, nota);
            System.out.println("Cargado en mapeo: DNI " + dni + " -> Nota " + nota);
        }

        logica.setUltimoMapeo(mapeo);
        System.out.println("Mapeo cargado con éxito (" + mapeo.size() + " alumno/s).");
    }

    // 2
    private void mostrarUltimoMapeo() {
        Map<Integer, Integer> ultimo = logica.getUltimoMapeo();

        if (ultimo == null || ultimo.isEmpty()) {
            System.out.println("No hay ningún mapeo cargado actualmente.");
            return;
        }

        System.out.println("\n--- Último mapeo cargado ---");
        Entry<Integer, Integer>[] entradas = ultimo.entries();

        for (int i = 0; i < entradas.length; i++) {
            System.out.println("DNI: " + entradas[i].getKey() + " | Nota: " + entradas[i].getValue());
        }
    }

    // 3
    private void agregarUltimoMapeoAlDiccionario() {
        if (logica.getUltimoMapeo() == null || logica.getUltimoMapeo().isEmpty()) {
            System.out.println("No hay ningún mapeo cargado para agregar al Diccionario general.");
            return;
        }

        logica.consolidarUltimoMapeo();
        System.out.println("El último mapeo fue consolidado exitosamente en el Diccionario general.");
    }

    // 4
    private void agregarNota() {
        int dni = leerEntero("Ingrese el DNI del alumno: ");
        int nota = leerEntero("Ingrese la nota (0-10): ");

        boolean agregada = logica.agregarNota(dni, nota);

        if (agregada) {
            System.out.println("Nota " + nota + " agregada correctamente al alumno con DNI " + dni + ".");
        } else {
            System.out.println("Error: la nota debe estar comprendida entre 0 y 10.");
        }
    }

    // 5
    private void quitarNota() {
        int dni = leerEntero("Ingrese el DNI del alumno: ");
        int nota = leerEntero("Ingrese la nota a quitar: ");

        boolean quitada = logica.quitarNota(dni, nota);

        if (quitada) {
            System.out.println("Nota " + nota + " eliminada correctamente del alumno con DNI " + dni + ".");
        } else {
            System.out.println("No se encontró la nota " + nota + " para el alumno con DNI " + dni + ".");
        }
    }

    // 6
    private void quitarAlumno() {
        int dni = leerEntero("Ingrese el DNI del alumno a eliminar: ");

        boolean eliminado = logica.quitarAlumno(dni);

        if (eliminado) {
            System.out.println("Alumno con DNI " + dni + " eliminado con éxito del sistema.");
        } else {
            System.out.println("El alumno con DNI " + dni + " no existe en el sistema.");
        }
    }

    // 7
    private void mostrarNotasAlumno() {
        int dni = leerEntero("Ingrese el DNI del alumno: ");
        Integer[] notas = logica.obtenerNotas(dni);

        if (notas == null || notas.length == 0) {
            System.out.println("El alumno con DNI " + dni + " no tiene notas registradas o no existe.");
            return;
        }

        System.out.print("Notas del alumno con DNI " + dni + ": ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
        }
        System.out.println();
    }

    // 8
    private void mostrarTodosLosAlumnos() {
        Integer[] alumnos = logica.obtenerAlumnos();

        if (alumnos == null || alumnos.length == 0) {
            System.out.println("No hay alumnos registrados en el sistema.");
            return;
        }

        System.out.println("\n--- Alumnos registrados ---");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Alumno " + (i + 1) + ": DNI " + alumnos[i]);
        }
    }

    // 9
    private void mostrarTodosLosAlumnosYPromedio() {
        Integer[] alumnos = logica.obtenerAlumnos();

        if (alumnos == null || alumnos.length == 0) {
            System.out.println("No hay alumnos registrados en el sistema.");
            return;
        }

        System.out.println("\n--- Alumnos y sus Promedios ---");
        for (int i = 0; i < alumnos.length; i++) {
            Integer dni = alumnos[i];
            double promedio = logica.calcularPromedio(dni);

            if (promedio == -1) {
                System.out.println("DNI: " + dni + " | Sin notas para calcular promedio");
            } else {
                System.out.printf("DNI: %d | Promedio: %.2f\n", dni, promedio);
            }
        }
    }

    // Checkeo de enteros
    private int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.iniciar();
    }
}
