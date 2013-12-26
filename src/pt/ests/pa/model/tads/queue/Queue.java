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
 * @param <E> Classe do Objecto a ser inserido na Fila
 * @author Rui
 */
public interface Queue<E> {

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
     * @param elem
     * @throws FullQueueException
     */
    public void enqueue(E elem) throws FullQueueException;

    /**
     *
     * @return
     * @throws EmptyQueueException
     */
    public E dequeue() throws EmptyQueueException;

    /**
     *
     * @return
     * @throws EmptyQueueException
     */
    public E peek() throws EmptyQueueException;
    
    /**
     *
     * @return
     */
    public Iterator<E> getIterator();
}
