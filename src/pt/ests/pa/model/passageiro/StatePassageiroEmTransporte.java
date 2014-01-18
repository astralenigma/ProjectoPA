/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author Rui
 */
public class StatePassageiroEmTransporte extends StatePassageiro {

    /**
     *
     * @param passageiro
     */
    public StatePassageiroEmTransporte(Passageiro passageiro) {
        super(passageiro);
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void entrar() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O passageiro já se encontra dentro."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void sair() throws InvalidStateTransitionException {
        //Eliminar o Passageiro Quem sabe.
    }
}
