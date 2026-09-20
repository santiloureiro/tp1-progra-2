package ejercicio8;

public class LogicaNotasImpl implements LogicaNotas {

    private Map<Integer, Integer>
            ultimoMapeo;

    private Dictionary<Integer, Integer>
            diccionarioGeneral;

    public LogicaNotasImpl() {

        ultimoMapeo = null;

        diccionarioGeneral =
                new LinkedDictionaryImpl
                <Integer, Integer>();
    }

    // ÚLTIMO MAPEO

    public void setUltimoMapeo(
            Map<Integer, Integer> mapeo) {

        ultimoMapeo = mapeo;
    }

    public Map<Integer, Integer>
        getUltimoMapeo() {

        return ultimoMapeo;
    }

    // CONSOLIDAR MAPEO

    public void consolidarUltimoMapeo() {

        if (ultimoMapeo == null) {
            return;
        }

        Entry<Integer, Integer>[] entradas =
                ultimoMapeo.entries();

        for (int i = 0; i < entradas.length; i++) {

            Entry<Integer, Integer> entrada =
                    entradas[i];

            int dni = entrada.getKey();

            int nota = entrada.getValue();

            diccionarioGeneral.put(
                    dni,
                    nota);
        }
    }

    // AGREGAR NOTA

    public boolean agregarNota(
            int dni,
            int nota) {

        if (!notaValida(nota)) {
            return false;
        }

        diccionarioGeneral.put(
                dni,
                nota);

        return true;
    }

    // QUITAR NOTA

    public boolean quitarNota(
            int dni,
            int nota) {

        Integer eliminada =
                diccionarioGeneral.remove(
                        dni,
                        nota);

        return eliminada != null;
    }

    // QUITAR ALUMNO

    public boolean quitarAlumno(int dni) {

        Integer[] eliminado =
                diccionarioGeneral.remove(dni);

        return eliminado != null;
    }

    // OBTENER NOTAS

    public Integer[] obtenerNotas(int dni) {

        return diccionarioGeneral.get(dni);
    }

    // OBTENER ALUMNOS

    public Integer[] obtenerAlumnos() {

        return diccionarioGeneral.keys();
    }

    // PROMEDIO

    public double calcularPromedio(int dni) {

        Integer[] notas =
                diccionarioGeneral.get(dni);

        if (notas == null || notas.length == 0) {
            return -1;
        }

        int suma = 0;
        int cantidad = 0;

        for (int i = 0; i < notas.length; i++) {

            suma = suma + notas[i];

            cantidad++;
        }

        if (cantidad == 0) {
            return -1;
        }

        return (double) suma / cantidad;
    }

    // VALIDAR NOTA

    private boolean notaValida(int nota) {

        return nota >= 0 &&
               nota <= 10;
    }
}