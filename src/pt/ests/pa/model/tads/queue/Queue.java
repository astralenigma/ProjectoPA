/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.queue;

import pt.ests.pa.model.exceptions.FullQueueException;
import pt.ests.pa.model.exceptions.EmptyQueueException;
import pt.ests.pa.model.tads.Iterator;

/**
 * Usada para apoio ao projecto.
 *
 * @param <E> Classe do Objecto a ser inserido na Fila
 * @author Rui
 */
public interface Queue<E> {

    /**
     * Devolve o tamanho da fila.
     *
     * @return Tamanho da Fila
     */
    public int size();

    /**
     * Verifica se a fila está vazia
     *
     * @return True se a fila estiver vazia e False se a fila estiver cheia.
     */
    public boolean isEmpty();

    /**
     * Insere um elemento na fila.
     *
     * @param elem O elemento a ser inserido.
     * @throws FullQueueException Excepção a ser atirada se a fila estiver
     * cheia.
     */
    public void enqueue(E elem) throws FullQueueException;

    /**
     * Remove um elemento da fila.
     *
     * @return O elemento a ser removido.
     * @throws EmptyQueueException Excepção a ser atirada se a fila estiver
     * vazia.
     */
    public E dequeue() throws EmptyQueueException;

    /**
     * Espreita o próximo elemento a sair da fila.
     *
     * @return O elemento prestes a sair.
     * @throws EmptyQueueException Excepção a ser atirada se a fila estiver
     * cheia.
     */
    public E peek() throws EmptyQueueException;

    /**
     * Devolve o iterador da fila usado para mover-se na fila sem remover os
     * elementos.
     *
     * @return Iterador da fila.
     */
    public Iterator<E> getIterator();
}
