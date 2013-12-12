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
 * @author Rui
 */
public interface Stack<E> {

    public int size();

    public boolean isEmpty();

    public E peek() throws EmptyStackException;

    public void push(E elem) throws FullStackException;

    public E pop() throws EmptyStackException;
    
    public Iterator<E> getIterator();
}
