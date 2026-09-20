package ejercicio8;

public interface LogicaNotas {

    public void setUltimoMapeo(Map<Integer, Integer> mapeo);

    public Map<Integer, Integer> getUltimoMapeo();

    public void consolidarUltimoMapeo();

    public boolean agregarNota(int dni, int nota);

    public boolean quitarNota(int dni, int nota);

    public boolean quitarAlumno(int dni);

    public Integer[] obtenerNotas(int dni);

    public Integer[] obtenerAlumnos();

    public double calcularPromedio(int dni);
}
