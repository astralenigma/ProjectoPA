/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class IndexOutOfBoundsException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>IndexOutOfBoundsException</code> without detail message.
     */
    public IndexOutOfBoundsException() {
    }

    /**
     * Constructs an instance of
     * <code>IndexOutOfBoundsException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public IndexOutOfBoundsException(String msg) {
        super("O índice " +msg+" está fora dos limites");
    }
}
