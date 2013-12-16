/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.stack;

import pt.ests.pa.model.exceptions.FullStackException;
import pt.ests.pa.model.exceptions.EmptyStackException;
import pt.ests.pa.model.tads.Iterator;
import pt.ests.pa.model.tads.Node;

/**
 *
 * @author Rui
 */
public class StackDynamic<E> implements Stack<E> {

    private int size;
    private Node<E> top;
    private int maxCapacity;

    public StackDynamic(int capacity) {
        this.maxCapacity = capacity;
        this.size = 0;
        this.top = null;
    }

    public StackDynamic() {
        this(-1);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getElement();

    }

    @Override
    public void push(E elem) throws FullStackException {
        if (isFull()) {
            throw new FullStackException();
        }
        Node<E> newNode = new Node<>(elem, top);
        top = newNode;
        size++;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        E elemRemoved = top.getElement();
        top = top.getNext();
        size--;
        return elemRemoved;
    }

    public boolean isFull() {
        return (size == maxCapacity);
    }

    @Override
    public Iterator<E> getIterator() {
        return new IteratorStackDynamic();
    }

    private class IteratorStackDynamic implements Iterator<E> {

        private Node<E> pos;

        public IteratorStackDynamic() {
            pos = top;
        }

        @Override
        public E getNext() {
            E elem = pos.getElement();
            pos = pos.getNext();
            return elem;
        }

        @Override
        public boolean hasNext() {
            return pos != null;
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
