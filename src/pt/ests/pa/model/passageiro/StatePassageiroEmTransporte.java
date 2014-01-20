/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 * Estado do Passageiro em transporte.
 * @author Rui
 */
public class StatePassageiroEmTransporte extends StatePassageiro {

   
    public StatePassageiroEmTransporte(Passageiro passageiro) {
        super(passageiro);
    }

   
    @Override
    public void entrar() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O passageiro já se encontra dentro."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public void sair() throws InvalidStateTransitionException {
        //Eliminar o Passageiro Quem sabe.
    }
}
