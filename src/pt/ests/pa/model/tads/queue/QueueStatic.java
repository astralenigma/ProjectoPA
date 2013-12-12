/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.queue;

import pt.ests.pa.model.exceptions.FullQueueException;
import pt.ests.pa.model.exceptions.EmptyQueueException;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @author Rui
 */
public class QueueStatic<E> implements Queue<E> {

    private int begin, end;
    private int capacity;
    private E[] queue;
    private static final int DEFAUlTCAPACITY=100;

    @Override
    public int size() {
        if (isFull()) {
            return capacity;
        } else {
            return (capacity - begin + end) % capacity;
        }
    }

    public QueueStatic(int capacity) {
        queue=(E[]) new Object[capacity];
        begin=end=0;
        this.capacity=capacity;
    }
    public QueueStatic() {
        this(DEFAUlTCAPACITY);
    }

    private boolean isFull() {
        return (begin == end && queue[begin] != null);
    }

    @Override
    public boolean isEmpty() {
        return (begin == end && queue[begin] == null);
    }

    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            E elem = queue[begin];
            return elem;
        }
    }

    @Override
    public void enqueue(E elem) throws FullQueueException {
        if (!isFull()) {
            queue[end] = elem;
            end = (end + 1) % capacity;
        } else {
            throw new FullQueueException();
        }
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        } else {
            E elem = queue[begin];
            queue[begin] = null;
            begin = (begin + 1) % capacity;
            return elem;
        }
    }

    @Override
    public Iterator<E> getIterator() {
        return new IteratorQueueStatic();
    }

    private class IteratorQueueStatic implements Iterator<E> {

        private int pos;

        public IteratorQueueStatic() {
            pos = begin;
        }

        @Override
        public boolean hasNext() {
            return pos != end;
        }

        @Override
        public E getNext() {
            E elem = queue[pos];
            pos = (pos + 1) % capacity;
            return elem;
        }
    }

    @Override
    public String toString() {
        String string = "[";
        for (Iterator it = getIterator(); it.hasNext();) {
            string += it.getNext();
            string += (it.hasNext()) ? ", " : "]";
        }
        return string; //To change body of generated methods, choose Tools | Templates.
    }
}
