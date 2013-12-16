/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class EmptyArrayListException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>EmptyArrayListException</code> without detail message.
     */
    public EmptyArrayListException() {
        super("!!!!!A lista está vazia!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>EmptyArrayListException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyArrayListException(String msg) {
        super(msg);
    }
}
