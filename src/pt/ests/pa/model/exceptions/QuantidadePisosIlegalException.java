/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author Rui
 */
public class QuantidadePisosIlegalException extends Exception {

    /**
     * Creates a new instance of
     * <code>QuantidadePisosIlegalException</code> without detail message.
     */
    public QuantidadePisosIlegalException() {
        super("Quantidade de Pisos ilegal");
    }

    /**
     * Constructs an instance of
     * <code>QuantidadePisosIlegalException</code> with the specified detail
     * message.
     *
     * @param msg the detail message.
     */
    public QuantidadePisosIlegalException(String msg) {
        super(msg);
    }
}
