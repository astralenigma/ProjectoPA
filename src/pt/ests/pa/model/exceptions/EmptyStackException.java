/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class EmptyStackException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>EmptyStackException</code> without detail message.
     */
    public EmptyStackException() {
        super("!!!!!A pilha está vazia!!!!!");
    }

    /**
     * Constructs an instance of
     * <code>EmptyStackException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyStackException(String msg) {
        super(msg);
    }
}
