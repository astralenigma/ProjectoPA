/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.priorityqueue;

import pt.ests.pa.model.exceptions.FullPriorityQueueException;
import pt.ests.pa.model.exceptions.EmptyPriorityQueueException;
import pt.ests.pa.model.tads.Iterator;
import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.arraylist.ArrayListDNode;
import pt.ests.pa.model.exceptions.FullArrayListException;

/**
 *
 * @param <E> Classe do Objecto a ser inserido na Fila De Prioridade
 * @author Rui
 */
public class PriorityQueueAdapter<E extends Comparable<E>> implements PriorityQueue<E> {

    private ArrayList<E> pQueue;
    private int capacity;

    /**
     *
     */
    public PriorityQueueAdapter() {
        pQueue = new ArrayListDNode();
        capacity = -1;

    }

    /**
     *
     * @param capacity
     */
    public PriorityQueueAdapter(int capacity) {
        pQueue = new ArrayListDNode<>(capacity);
        this.capacity = capacity;
    }

    /**
     *
     * @return
     */
    @Override
    public int size() {
        return pQueue.size();
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return pQueue.isEmpty();
    }

    /**
     *
     * @param elem
     * @throws FullPriorityQueueException
     */
    @Override
    public void enqueue(E elem) throws FullPriorityQueueException {
        if (size() == capacity) {
            throw new FullPriorityQueueException();
        }
        ArrayList<E> array = new ArrayListDNode<>(capacity);
        //Vai procurar o espaco onde inserir
        while (!isEmpty() && pQueue.get(0).compareTo(elem) < 0) {
            array.add(array.size(), pQueue.remove(0));
        }
        //verifica o tamanho e insere naquele com maior tamanho
        if (pQueue.size() >= array.size()) {
            //O Adaptee é o maior.
            pQueue.add(0, elem);
            while (!array.isEmpty()) {
                pQueue.add(0, array.remove(array.size() - 1));
            }
        } else {
            //O ArrayList auxiliar é o maior.
            array.add(array.size(), elem);
            while (!isEmpty()) {
                array.add(array.size(), pQueue.remove(0));
            }
            pQueue = array;
        }

    }

    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    @Override
    public E peek() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return pQueue.get(0);
    }

    /**
     *
     * @return
     * @throws EmptyPriorityQueueException
     */
    @Override
    public E dequeue() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return pQueue.remove(0);
    }

    /**
     *
     * @return
     */
    @Override
    public Iterator<E> getIterator() {
        return pQueue.getIterator();
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String string = "[";
        for (Iterator it = getIterator(); it.hasNext();) {
            string += it.next();
            string += (it.hasNext()) ? ", " : "";
        }
        string += "]";
        return string; //To change body of generated methods, choose Tools | Templates.
    }
}
