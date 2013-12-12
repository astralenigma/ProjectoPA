/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class EmptyQueueException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>EmptyQueueException</code> without detail message.
     */
    public EmptyQueueException() {
        super("!!!!!A fila está vazia!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>EmptyQueueException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyQueueException(String msg) {
        super(msg);
    }
}
