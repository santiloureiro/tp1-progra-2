package ejercicioArbol;

public interface List<E> {
    public void addFirst(E newElement);
    public void addLast(E newElement);
    public void removeFirst();
    public void removeLast();
    public void remove(E element);
    public void First();
    public void advance();
    public E getCurrent();
    public boolean atEnd();
    public int getSize();
    public E elementAt(int pos);
    public E removeAt(int pos);
}
