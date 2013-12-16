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
 * @author Rui
 */
public class PriorityQueueDynamic<E extends Comparable<E>> implements PriorityQueue<E> {

    private DNode<E> head, tail;
    private int size;
    private int capacity;

    public PriorityQueueDynamic(int capacity) {
        this.head = new DNode(null, null, null);
        this.tail = new DNode(null, head, null);
        this.head.setNext(tail);
        this.size = 0;
        this.capacity = capacity;
    }

    public PriorityQueueDynamic() {
        this(-1);
    }

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

    @Override
    public E peek() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return head.getNext().getElem();
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return size == 0;
    }

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