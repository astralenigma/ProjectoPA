/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author Rui Carvalho
 */
public abstract class StatePassageiro {

    private Passageiro passageiro;

    public StatePassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    public Passageiro getPassageiro() {
        return passageiro;
    }

    public abstract void entrar() throws InvalidStateTransitionException;

    public abstract void sair() throws InvalidStateTransitionException;

    
}
