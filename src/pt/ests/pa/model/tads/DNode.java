/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads;

/**
 *
 * @author Rui
 */
public class DNode<E> {

    private E elem;
    private DNode<E> next;
    private DNode<E> prev;

    public DNode(E elem, DNode<E> prev, DNode<E> next) {
        this.elem = elem;
        this.next = next;
        this.prev = prev;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public E getElem() {
        return elem;
    }

    public DNode<E> getNext() {
        return next;
    }

    public void setNext(DNode<E> next) {
        this.next = next;
    }

    public DNode<E> getPrev() {
        return prev;
    }

    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }
    
}
