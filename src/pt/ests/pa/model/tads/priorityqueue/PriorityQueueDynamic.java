/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.priorityqueue;

import pt.ests.pa.model.exceptions.FullPriorityQueueException;
import pt.ests.pa.model.exceptions.EmptyPriorityQueueException;
import pt.ests.pa.model.tads.DNode;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @param <E> Classe do Objecto a ser inserido na Fila De Prioridade
 * @author Rui
 */
public class PriorityQueueDynamic<E extends Comparable<E>> implements PriorityQueue<E> {

    private DNode<E> head, tail;
    private int size;
    private int capacity;

    /**
     *
     * @param capacity
     */
    public PriorityQueueDynamic(int capacity) {
        this.head = new DNode(null, null, null);
        this.tail = new DNode(null, head, null);
        this.head.setNext(tail);
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     *
     */
    public PriorityQueueDynamic() {
        this(-1);
    }

    /**
     *
     * @param elem
     * @throws FullPriorityQueueException
     */
    @Override
    public void enqueue(E elem) throws FullPriorityQueueException {
        if (capacity == size) {
            throw new FullPriorityQueueException();
        }
        if (isEmpty()) {
            DNode<E> newNode = new DNode(elem, head, tail);
            head.setNext(newNode);
            tail.setPrev(newNode);
        } else {
            DNode<E> aux = tail.getPrev();
            while (aux != head) {
                if (aux.getElem().compareTo(elem) > 0) {
                    aux = aux.getPrev();
                } else {
                    break;
                }
            }
            DNode<E> newNode = new DNode(elem, aux, aux.getNext());
            aux.getNext().setPrev(newNode);
            aux.setNext(newNode);
        }
        size++;
    }

    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    @Override
    public E dequeue() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        E elem = head.getNext().getElem();
        DNode aux = head.getNext();
        head.setNext(aux.getNext());
        aux.getNext().setPrev(head);
        size--;
        return elem;
    }

    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    @Override
    public E peek() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return head.getNext().getElem();
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> getIterator() {
        return new IteratorPriorityQueueDynamic();
    }

    private class IteratorPriorityQueueDynamic implements Iterator<E> {

        private DNode<E> pos;

        public IteratorPriorityQueueDynamic() {
            pos = head.getNext();
        }

        @Override
        public E next() {
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
        String string = "";
        for (Iterator it = getIterator(); it.hasNext();) {
            string += it.next();
            string += (it.hasNext()) ? ", " : "";
        }
        return string;
    }
}