/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class FullQueueException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>FullQueueException</code> without detail message.
     */
    public FullQueueException() {
        super("!!!!!A fila está cheia!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>FullQueueException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public FullQueueException(String msg) {
        super(msg);
    }
}
