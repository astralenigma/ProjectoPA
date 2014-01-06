/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads;

/**
 *
 * @param <E> Classe do Objecto a ser inserido no Iterador
 * @author Rui
 */
public interface Iterator<E> {
    /**
     *
     * @return
     */
    public E next();
    /**
     *
     * @return
     */
    public boolean hasNext();
    
}
