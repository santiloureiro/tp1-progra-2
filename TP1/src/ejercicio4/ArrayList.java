package ejercicio4;

public class ArrayList<T> implements ListaTDA<T> {
    private Object[] elementos;
    private int cantidad;
    private static final int CAPACIDAD_INICIAL = 4;

    public ArrayList() {
        this.elementos = new Object[CAPACIDAD_INICIAL];
        this.cantidad = 0;
    }

    
    public void agregar(T elemento) {
        if (cantidad == elementos.length) {
            redimensionar();
        }
        elementos[cantidad] = elemento;
        cantidad++;
    }

    private void redimensionar() {
        int nuevaCapacidad = elementos.length * 2;
        System.out.println("[Aviso] Se lleno el arreglo. Agrandando de " 
                + elementos.length + " a " + nuevaCapacidad + " lugares.");
        
        Object[] nuevoArreglo = new Object[nuevaCapacidad];
        for (int i = 0; i < cantidad; i++) {
            nuevoArreglo[i] = elementos[i];
        }
        elementos = nuevoArreglo;
    }

    
    public boolean eliminar(T elemento) {
        for (int i = 0; i < cantidad; i++) {
            if (elementos[i].equals(elemento)) {
                for (int j = i; j < cantidad - 1; j++) {
                    elementos[j] = elementos[j + 1];
                }
                elementos[cantidad - 1] = null;
                cantidad--;
                return true;
            }
        }
        return false; 
    }
    
    public T obtener(int indice) {
        if (indice < 0 || indice >= cantidad) {
            return null;
        }
        return (T) elementos[indice];
    }

    
    public int size() {
        return cantidad;
    }

    
    public boolean estaVacia() {
        return cantidad == 0;
    }
}