/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 * Classe do estado do Passageiro.
 *
 * @author Rui Carvalho
 */
public abstract class StatePassageiro {

    private Passageiro passageiro;

    /**
     * Constructor da classe estado do passageiro.
     *
     * @param passageiro Recebe o passageiro ao qual pertence o estado.
     */
    public StatePassageiro(Passageiro passageiro) {
        this.passageiro = passageiro;
    }

    /**
     * Devolve o passageiro ao qual pertence o estado.
     *
     * @return Passageiro.
     */
    public Passageiro getPassageiro() {
        return passageiro;
    }

    /**
     * Acção de entrar no elevador.
     *
     * @throws InvalidStateTransitionException É atirado quando não for possível
     * entrar.
     */
    public abstract void entrar() throws InvalidStateTransitionException;

    /**
     * Acção de sair do elevador.
     *
     * @throws InvalidStateTransitionException É atirado quando não for possível
     * sair.
     */
    public abstract void sair() throws InvalidStateTransitionException;
}
