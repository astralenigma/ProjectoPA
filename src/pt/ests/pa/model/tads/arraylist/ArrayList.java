/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.arraylist;

import pt.ests.pa.model.exceptions.EmptyArrayListException;
import pt.ests.pa.model.exceptions.IndexOutOfBoundsException;
import pt.ests.pa.model.exceptions.FullArrayListException;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @param <E>
 * @author Rui
 */
public interface ArrayList<E> {

    /**
     * Retorna o número de elementos na lista.
     */
    public int size();

    /**
     * Retorna true se a lista estiver vazia e false se ela não estiver.
     */
    public boolean isEmpty();

    /**
     * Insere um elemento no índice i, movendo os elementos após este.
     */
    public void add(int i, E elem) throws IndexOutOfBoundsException,FullArrayListException;

    /**
     * Remove e retorna o elemento no índice i, movendo os elementos após este.
     */
    public E remove(int i) throws IndexOutOfBoundsException;

    /**
     * Substítui o elemento no índice i, retornando o antigo.
     */
    public E set(int i, E elem) throws IndexOutOfBoundsException, EmptyArrayListException;

    /**
     * Retorna o elemento no índice i, sem removê-lo
     */
    public E get(int i) throws IndexOutOfBoundsException, EmptyArrayListException;
    
    
    public Iterator<E> getIterator();
}
