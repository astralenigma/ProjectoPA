/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class ElevadorNoPisoZeroException extends Exception {

    /**
     * Creates a new instance of
     * <code>PisoZeroException</code> without detail message.
     */
    public ElevadorNoPisoZeroException() {
    }

    /**
     * Constructs an instance of
     * <code>PisoZeroException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ElevadorNoPisoZeroException(String msg) {
        super(msg);
    }
}
