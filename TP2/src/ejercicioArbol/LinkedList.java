package ejercicioArbol;

public class LinkedList<E> implements List<E> {
    private Node<E> head;
    private int size;
    private Node<E> current;

    public LinkedList() {
        head = null;
        size = 0;
        current = null;
    }

    
    public void addFirst(E newElement) {
        Node<E> n = new Node<E>(newElement);
        n.setNext(head);
        head = n;
        size++;
    }

    
    public void addLast(E newElement) {
        Node<E> n = new Node<E>(newElement);
        if (head == null) {
            head = n;
        } else {
            Node<E> i = head;
            while (i.getNext() != null) {
                i = i.getNext();
            }
            i.setNext(n);
        }
        size++;
    }

    
    public void removeFirst() {
        if (head == null) {
            return;
        }
        Node<E> aux = head.getNext();
        head.setNext(null);
        head = aux;
        size--;
    }

    
    public void removeLast() {
        if (head == null) {
            return;
        }
        if (size == 1) {
            head = null;
        } else {
            Node<E> aux = head;
            Node<E> aux2 = aux.getNext();
            while (aux2.getNext() != null) {
                aux = aux2;
                aux2 = aux2.getNext();
            }
            aux.setNext(null);
        }
        size--;
    }

    
    public void remove(E element) {
        if (head == null || element == null) {
            return;
        }
        if (element.equals(head.getElement())) {
            removeFirst();
            return;
        }
        Node<E> aux = head;
        while (aux.getNext() != null && !aux.getNext().getElement().equals(element)) {
            aux = aux.getNext();
        }
        if (aux.getNext() == null) {
            return;
        }
        Node<E> aEliminar = aux.getNext();
        aux.setNext(aEliminar.getNext());
        aEliminar.setNext(null);
        size--;
    }

    
    public void First() {
        current = head;
    }

    
    public void advance() {
        if (current != null) {
            current = current.getNext();
        }
    }

    
    public E getCurrent() {
        if (current == null) {
            return null;
        }
        return current.getElement();
    }

    
    public boolean atEnd() {
        return current == null;
    }

    
    public int getSize() {
        return size;
    }

    
    public E elementAt(int pos) {
        if (pos < 0 || pos >= size) {
            return null;
        }
        Node<E> aux = head;
        for (int i = 0; i < pos; i++) {
            aux = aux.getNext();
        }
        return aux.getElement();
    }

    
    public E removeAt(int pos) {
        if (pos < 0 || pos >= size || head == null) {
            return null;
        }
        if (pos == 0) {
            E element = head.getElement();
            removeFirst();
            return element;
        }
        Node<E> anterior = head;
        for (int i = 0; i < pos - 1; i++) {
            anterior = anterior.getNext();
        }
        Node<E> aEliminar = anterior.getNext();
        anterior.setNext(aEliminar.getNext());
        aEliminar.setNext(null);
        size--;
        return aEliminar.getElement();
    }
}
