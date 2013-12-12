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
 * @author Rui
 */
public interface PriorityQueue <E>{
    public int size();
    public boolean isEmpty();
    public E dequeue() throws EmptyPriorityQueueException;
    public E peek() throws EmptyPriorityQueueException;
    public void enqueue(E elem) throws FullPriorityQueueException;
    public Iterator<E> getIterator();
}
