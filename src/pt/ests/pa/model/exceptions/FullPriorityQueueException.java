/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class FullPriorityQueueException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>FullQueueException</code> without detail message.
     */
    public FullPriorityQueueException() {
        super("!!!!!A fila está cheia!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>FullQueueException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public FullPriorityQueueException(String msg) {
        super(msg);
    }
}
