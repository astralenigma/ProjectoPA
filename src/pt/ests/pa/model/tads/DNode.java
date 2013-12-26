/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.tads;

/** Classe do No Duplo usado nos TADs
 *
 * @param <E> Classe do Objecto a ser inserido no No Duplo
 * @author Rui
 */
public class DNode<E> {

    private E elem;
    private DNode<E> next;
    private DNode<E> prev;

    /**
     *
     * @param elem
     * @param prev
     * @param next
     */
    public DNode(E elem, DNode<E> prev, DNode<E> next) {
        this.elem = elem;
        this.next = next;
        this.prev = prev;
    }

    /**
     *
     * @param elem
     */
    public void setElem(E elem) {
        this.elem = elem;
    }

    /**
     *
     * @return
     */
    public E getElem() {
        return elem;
    }

    /**
     *
     * @return
     */
    public DNode<E> getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(DNode<E> next) {
        this.next = next;
    }

    /**
     *
     * @return
     */
    public DNode<E> getPrev() {
        return prev;
    }

    /**
     *
     * @param prev
     */
    public void setPrev(DNode<E> prev) {
        this.prev = prev;
    }
    
}
