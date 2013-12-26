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
 * @param <E> Classe do Objecto a ser inserido no ArrayList
 * @author Rui
 */
public interface ArrayList<E> {

    /**
     * Retorna o número de elementos na lista.
     * @return 
     */
    public int size();

    /**
     * Retorna true se a lista estiver vazia e false se ela não estiver.
     * @return 
     */
    public boolean isEmpty();

    /**
     * Insere um elemento no índice i, movendo os elementos após este.
     * @param i
     * @param elem 
     * @throws IndexOutOfBoundsException
     * @throws FullArrayListException  
     */
    public void add(int i, E elem) throws IndexOutOfBoundsException,FullArrayListException;

    /**
     * Remove e retorna o elemento no índice i, movendo os elementos após este.
     * @param i 
     * @return
     * @throws IndexOutOfBoundsException  
     */
    public E remove(int i) throws IndexOutOfBoundsException;

    /**
     * Substítui o elemento no índice i, retornando o antigo.
     * @param i 
     * @param elem 
     * @return 
     * @throws IndexOutOfBoundsException
     * @throws EmptyArrayListException  
     */
    public E set(int i, E elem) throws IndexOutOfBoundsException, EmptyArrayListException;

    /**
     * Retorna o elemento no índice i, sem removê-lo
     * @param i
     * @return 
     * @throws IndexOutOfBoundsException 
     * @throws EmptyArrayListException  
     */
    public E get(int i) throws IndexOutOfBoundsException, EmptyArrayListException;
    
    
    /**
     *
     * @return
     */
    public Iterator<E> getIterator();
}
