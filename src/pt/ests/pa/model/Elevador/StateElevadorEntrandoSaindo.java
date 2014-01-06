/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author Rui
 */
public class StateElevadorEntrandoSaindo extends StateElevador {

    /**
     *
     * @param elevador
     */
    public StateElevadorEntrandoSaindo(Elevador elevador) {
        super(elevador);
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void subir() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Está a tentar matar alguém?");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Se as portas não estão abertas como é que as pessoas estão a entrar? Queres ver que há fantasmas no prédio?");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorPortasFechadas(getElevador()));
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void descer() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Está a tentar matar alguém?");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Já se encontram pessoas a sair e a entrar, não sei porque estás a chamar outra vez este estado.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Se o Elevador não está parado então as pessoas neste prédio são loucas.");
    }

    @Override
    public String toString() {
        return "OO"; 
    }

    @Override
    public String palavras() {
        return "Passageiros A Entrar\\Sair";
    }
    
}
