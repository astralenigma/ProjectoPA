/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.arraylist;

import pt.ests.pa.model.exceptions.EmptyArrayListException;
import pt.ests.pa.model.exceptions.IndexOutOfBoundsException;
import pt.ests.pa.model.exceptions.FullArrayListException;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @author Rui
 */
public class ArrayListStatic<E> implements ArrayList<E> {

    private E array[];
    private int size;
    private static final int DEFAUlTCAPACITY = 100;

    public ArrayListStatic(int capacity) {
        array = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayListStatic() {
        this(DEFAUlTCAPACITY);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int i, E elem) throws IndexOutOfBoundsException, FullArrayListException {
        if (size == array.length) {
            throw new FullArrayListException();
        }
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int j = size; j > i; j--) {
            array[j] = array[j - 1];
        }
        array[i] = elem;
        size++;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException, EmptyArrayListException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new EmptyArrayListException();
        }
        return array[i];
    }

    @Override
    public E set(int i, E elem) throws IndexOutOfBoundsException, EmptyArrayListException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new EmptyArrayListException();
        }
        E remElem = array[i];
        array[i] = elem;
        return remElem;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new EmptyArrayListException();
        }
        E remElem = array[i];
        for (int j = i; j < size - 1; j++) {
            array[j] = array[j + 1];
        }
        array[size] = null;
        size--;
        return remElem;
    }

    @Override
    public Iterator<E> getIterator() {
        return new IteratorArrayListStatic();
    }

    private class IteratorArrayListStatic implements Iterator<E> {

        private int pos;

        public IteratorArrayListStatic() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos != size;
        }

        @Override
        public E getNext() {
            E elem = array[pos];
            pos++;
            return elem;
        }
    }

    @Override
    public String toString() {
        String string = "[";
        for (Iterator it = getIterator(); it.hasNext();) {
            string += it.getNext();
            string += (it.hasNext()) ? ", " : "";
        }
        string += "]";
        return string; //To change body of generated methods, choose Tools | Templates.
    }
}
