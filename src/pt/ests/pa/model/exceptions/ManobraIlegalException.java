/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class ManobraIlegalException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>ManobraIlegalException</code> without detail message.
     */
    public ManobraIlegalException() {
    }

    /**
     * Constructs an instance of
     * <code>ManobraIlegalException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ManobraIlegalException(String msg) {
        super(msg);
    }
}
