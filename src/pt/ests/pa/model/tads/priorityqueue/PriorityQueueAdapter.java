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
 * @author Rui
 */
public class PriorityQueueAdapter<E extends Comparable<E>> implements PriorityQueue<E> {

    private ArrayList<E> pQueue;
    private int capacity;

    public PriorityQueueAdapter() {
        pQueue = new ArrayListDNode();
        capacity = -1;

    }

    public PriorityQueueAdapter(int capacity) {
        pQueue = new ArrayListDNode<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return pQueue.size();
    }

    @Override
    public boolean isEmpty() {
        return pQueue.isEmpty();
    }

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

    @Override
    public E peek() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return pQueue.get(0);
    }

    @Override
    public E dequeue() throws EmptyPriorityQueueException {
        if (isEmpty()) {
            throw new EmptyPriorityQueueException();
        }
        return pQueue.remove(0);
    }

    @Override
    public Iterator<E> getIterator() {
        return pQueue.getIterator();
    }

    @Override
    public String toString() {
        String string = "[";
        for (Iterator it = getIterator(); it.hasNext();) {
            string += it.getNext();
            string += (it.hasNext()) ? ", " : "";
        }
        string += "]";
        return string; //To change body of generated methods, choose Tools | Templates.
    }
}
