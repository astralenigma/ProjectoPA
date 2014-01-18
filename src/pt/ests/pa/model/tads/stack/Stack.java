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
public interface Stack<E> {

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
     * @throws EmptyStackException
     */
    public E peek() throws EmptyStackException;

    /**
     *
     * @param elem
     * @throws FullStackException
     */
    public void push(E elem) throws FullStackException;

    /**
     *
     * @return
     * @throws EmptyStackException
     */
    public E pop() throws EmptyStackException;
    
    /**
     *
     * @return
     */
    public Iterator<E> getIterator();
}
