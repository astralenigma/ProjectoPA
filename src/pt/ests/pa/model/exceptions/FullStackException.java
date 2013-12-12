/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class FullStackException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>FullStackException</code> without detail message.
     */
    public FullStackException() {
        super("!!!!!Está cheio!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>FullStackException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public FullStackException(String msg) {
        super(msg);
    }
}
