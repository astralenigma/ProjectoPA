/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.exceptions;

/**
 *
 * @author brunomnsilva
 */
public class InvalidStateTransitionException extends RuntimeException {

    /**
     *
     * @param message
     */
    public InvalidStateTransitionException(String message) {
        super(message);
    }
    
}
