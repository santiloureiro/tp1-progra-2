package clase9ejercicio6;

public class ComparatorImpl<E extends Comparable<E>> implements Comparator<E> {
    public int compare(E a, E b) {
        return a.compareTo(b);
    }
}
