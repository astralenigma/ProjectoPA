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

    /**
     *
     * @param passageiro
     */
    public StatePassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    /**
     *
     * @return
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void entrar() throws InvalidStateTransitionException;

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void sair() throws InvalidStateTransitionException;
}
