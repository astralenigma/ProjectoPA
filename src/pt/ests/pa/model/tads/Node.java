/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads;

/**
 *
 * @author Rui
 */
public class Node<E> {
    private E elem;
    private Node<E> next;

    public Node(E elem, Node<E> next) {
        this.elem = elem;
        this.next = next;
    }

    public void setElement(E elem) {
        this.elem = elem;
    }

    public E getElement() {
        return elem;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
    
    
    
}
