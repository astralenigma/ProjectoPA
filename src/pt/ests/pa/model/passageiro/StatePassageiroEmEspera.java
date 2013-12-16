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
public class StatePassageiroEmEspera extends StatePassageiro {

    public StatePassageiroEmEspera(Passageiro passageiro) {
        super(passageiro);
    }

    @Override
    public void entrar() throws InvalidStateTransitionException {
        getPassageiro().setEstado(new StatePassageiroEmTransporte(getPassageiro()));
    }

    @Override
    public void sair() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O passageiro encontra-se fora do elevador");
    }
}
