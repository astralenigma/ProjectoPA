/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads.arraylist;

import pt.ests.pa.model.exceptions.EmptyArrayListException;
import pt.ests.pa.model.exceptions.IndexOutOfBoundsException;
import pt.ests.pa.model.exceptions.FullArrayListException;
import pt.ests.pa.model.tads.DNode;
import pt.ests.pa.model.tads.Iterator;

/**
 *
 * @param <E> Classe do Objecto a ser inserido no ArrayList
 * @author Rui
 */
public class ArrayListDNode<E> implements ArrayList<E> {

    private DNode<E> head, tail;
    private int size;
    private int capacity;

    /**
     *
     * @param capacity
     */
    public ArrayListDNode(int capacity) {
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null);
        head.setNext(tail);
        size = 0;
        this.capacity = capacity;
    }

    /**
     *
     */
    public ArrayListDNode() {
        this(-1);
    }

    private DNode<E> nodeAtIndex(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("" + i);
        }
        int ind;
        DNode<E> node;
        if (i < size / 2) {
            ind = 0;
            node = head.getNext();
            while (node != null) {
                if (ind == i) {
                    return node;
                } else {
                    ind++;
                    node = node.getNext();
                }
            }
        } else {
            ind = size;
            node = tail;
            while (node != null) {
                if (ind == i) {
                    return node;
                } else {
                    ind--;
                    node = node.getPrev();
                }
            }
        }
        return null;
    }

    @Override
    public void add(int i, E elem) throws IndexOutOfBoundsException, FullArrayListException {
        DNode node = nodeAtIndex(i);
        if (size == capacity) {
            throw new FullArrayListException();
        }
        DNode newNode = new DNode(elem, node.getPrev(), node);
        node.getPrev().setNext(newNode);
        node.setPrev(newNode);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E set(int i, E elem) throws IndexOutOfBoundsException, EmptyArrayListException {
        DNode<E> node = nodeAtIndex(i);
        if (isEmpty()) {
            throw new EmptyArrayListException();
        }
        DNode<E> newNode = new DNode(elem, node.getPrev(), node.getNext());
        newNode.getPrev().setNext(newNode);
        newNode.getNext().setPrev(newNode);
        return node.getElem();
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        DNode<E> node = nodeAtIndex(i);
        if (isEmpty()) {
            throw new EmptyArrayListException();
        }
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        size--;
        return node.getElem();
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException, EmptyArrayListException {
        E elem = nodeAtIndex(i).getElem();
        if (isEmpty()) {
            throw new EmptyArrayListException();
        }
        return elem;
    }

    @Override
    public int size() {
        return size;
    }

//    @Override
//    public String toString() {
//        String str="[";
//        int i=0;
//        while (i!=(size()-1)) {
//            str+=(nodeAtIndex(i)+",");
//        }
//        str+=(nodeAtIndex(size-1)+"]");
//        return str; 
//    }
    /**
     *
     * @return
     */
    @Override
    public Iterator<E> getIterator() {
        return new IteratorDNodeArrayList();
    }

    private class IteratorDNodeArrayList implements Iterator<E> {

        private DNode<E> pos;

        public IteratorDNodeArrayList() {
            pos = head.getNext();
        }

        @Override
        public E getNext() {
            E elem = pos.getElem();
            pos = pos.getNext();
            return elem;
        }

        @Override
        public boolean hasNext() {
            return pos != tail;
        }
    }

    /**
     *
     * @return
     */
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
