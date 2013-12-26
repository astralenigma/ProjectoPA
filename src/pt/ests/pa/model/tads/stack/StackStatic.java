/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.stack;

import pt.ests.pa.model.exceptions.FullStackException;
import pt.ests.pa.model.exceptions.EmptyStackException;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @param <E> Classe do Objecto a ser inserido na Pilha
 * @author Rui
 */
public class StackStatic<E> implements Stack<E> {

    private int top;
    private E[] stack;
    private int capacity;
    private static final int DEFAUlTCAPACITY = 100;

    /**
     *
     * @param capacity
     */
    public StackStatic(int capacity) {
        this.capacity = capacity;
        stack = (E[]) new Object[capacity];
        top = 0;
    }

    /**
     *
     */
    public StackStatic() {
        this(DEFAUlTCAPACITY);
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return top;
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
        return stack[top - 1];
    }

    /**
     *
     * @param elem
     * @throws FullStackException
     */
    @Override
    public void push(E elem) throws FullStackException {
        if (top == capacity) {
            throw new FullStackException();
        }
        stack[top++] = elem;
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
        E elem = stack[--top];
        stack[top] = null;
        return elem;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> getIterator() {
        return new IteratorStackStatic();
    }

    private class IteratorStackStatic implements Iterator<E> {

        private int pos;

        public IteratorStackStatic() {
            pos = 0;
        }

        @Override
        public E getNext() {
            E elem = stack[pos++];
            return elem;
        }

        @Override
        public boolean hasNext() {
            return pos != top;
        }
    }

    /**
     *
     * @return
     */
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
