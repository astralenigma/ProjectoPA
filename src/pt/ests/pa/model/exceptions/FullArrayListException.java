/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class FullArrayListException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>FullArrayListException</code> without detail message.
     */
    public FullArrayListException() {
        super("!!!!!A lista está cheia!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>FullArrayListException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public FullArrayListException(String msg) {
        super(msg);
    }
}
