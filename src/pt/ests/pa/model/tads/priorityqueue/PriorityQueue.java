/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.priorityqueue;

import pt.ests.pa.model.exceptions.FullPriorityQueueException;
import pt.ests.pa.model.exceptions.EmptyPriorityQueueException;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @param <E> Classe do Objecto a ser inserido na Fila De Prioridade
 * @author Rui
 */
public interface PriorityQueue <E>{
    /**
     *
     * @return
     */
    public int size();
    /**
     *
     * @return
     */
    public boolean isEmpty();
    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    public E dequeue() throws EmptyPriorityQueueException;
    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    public E peek() throws EmptyPriorityQueueException;
    /**
     *
     * @param elem
     * @throws FullPriorityQueueException
     */
    public void enqueue(E elem) throws FullPriorityQueueException;
    /**
     *
     * @return
     */
    public Iterator<E> getIterator();
}
