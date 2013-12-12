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
public interface Queue<E> {

    public int size();

    public boolean isEmpty();

    public void enqueue(E elem) throws FullQueueException;

    public E dequeue() throws EmptyQueueException;

    public E peek() throws EmptyQueueException;
    
    public Iterator<E> getIterator();
}
