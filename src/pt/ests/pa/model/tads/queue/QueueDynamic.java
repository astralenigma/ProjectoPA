/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.queue;

import pt.ests.pa.model.exceptions.FullQueueException;
import pt.ests.pa.model.exceptions.EmptyQueueException;
import pt.ests.pa.model.tads.DNode;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @param <E> Classe do Objecto a ser inserido na Fila
 * @author Rui
 */
public class QueueDynamic<E> implements Queue<E> {

    private DNode<E> head;
    private DNode<E> tail;
    private int size;
    private int capacity;

    /**
     *
     */
    public QueueDynamic() {
        this(-1);
    }

    /**
     *
     * @param capacity
     */
    public QueueDynamic(int capacity) {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null);
        head.setNext(tail);
        size = 0;
        this.capacity = capacity;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * @param elem
     * @throws FullQueueException
     */
    @Override
    public void enqueue(E elem) throws FullQueueException {
//        System.out.println(size);
        if (size == capacity) {
            throw new FullQueueException();
        }
        DNode<E> beforeTail = tail.getPrev();
        DNode<E> newDNode = new DNode(elem, beforeTail, tail);
        beforeTail.setNext(newDNode);
        tail.setPrev(newDNode);
        size++;
    }

    /**
     *
     * @return
     * @throws EmptyQueueException
     */
    @Override
    public E dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        DNode<E> rDNode = head.getNext();
        head.setNext(rDNode.getNext());
        rDNode.getNext().setPrev(head);
        size--;
        return rDNode.getElem();
    }

    /**
     *
     * @return
     * @throws EmptyQueueException
     */
    @Override
    public E peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return head.getNext().getElem();
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> getIterator() {
        return new IteratorQueueDynamic();
    }

    private class IteratorQueueDynamic implements Iterator<E> {

        private DNode<E> pos;

        public IteratorQueueDynamic() {
            pos = head.getNext();
        }

        @Override
        public E getNext() {
            E elem = pos.getElem();
            pos = pos.getNext();
            return elem;
        }

        @Override
        public boolean hasNext() {
            return pos != tail;
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
