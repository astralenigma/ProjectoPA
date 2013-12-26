/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads;

/**
 *
 * @param <E> Classe do Objecto a ser inserido no No
 * @author Rui
 */
public class Node<E> {

    private E elem;
    private Node<E> next;

    /**
     *
     * @param elem
     * @param next
     */
    public Node(E elem, Node<E> next) {
        this.elem = elem;
        this.next = next;
    }

    /**
     *
     * @param elem
     */
    public void setElement(E elem) {
        this.elem = elem;
    }

    /**
     *
     * @return
     */
    public E getElement() {
        return elem;
    }

    /**
     *
     * @return
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}
