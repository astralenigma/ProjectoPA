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
 * @param <E> Classe do Objecto a ser inserido na Pilha
 * @author Rui
 */
public class StackDynamic<E> implements Stack<E> {

    private int size;
    private Node<E> top;
    private int maxCapacity;

    /**
     *
     * @param capacity
     */
    public StackDynamic(int capacity) {
        this.maxCapacity = capacity;
        this.size = 0;
        this.top = null;
    }

    /**
     *
     */
    public StackDynamic() {
        this(-1);
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     *
     * @return
     * @throws EmptyStackException
     */
    @Override
    public E peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.getElement();

    }

    /**
     *
     * @param elem
     * @throws FullStackException
     */
    @Override
    public void push(E elem) throws FullStackException {
        if (isFull()) {
            throw new FullStackException();
        }
        Node<E> newNode = new Node<>(elem, top);
        top = newNode;
        size++;
    }

    /**
     *
     * @return
     * @throws EmptyStackException
     */
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

    /**
     *
     * @return
     */
    public boolean isFull() {
        return (size == maxCapacity);
    }

    /**
     *
     * @return
     */
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
        public E next() {
            E elem = pos.getElement();
            pos = pos.getNext();
            return elem;
        }

        @Override
        public boolean hasNext() {
            return pos != null;
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String string = "";
        for (Iterator it = getIterator(); it.hasNext();) {
            string += it.next();
            string += (it.hasNext()) ? ", " : "";
        }
        string += "";
        return string; 
    }
}
