/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class QuantidadeElevadoresIlegalException extends Exception {

    /**
     * Creates a new instance of
     * <code>QuantidadeElevadoresIlegalException</code> without detail message.
     */
    public QuantidadeElevadoresIlegalException() {
        super("Quantidade de Elevadores ilegal");
    }

    /**
     * Constructs an instance of
     * <code>QuantidadeElevadoresIlegalException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public QuantidadeElevadoresIlegalException(String msg) {
        super(msg);
    }
}
