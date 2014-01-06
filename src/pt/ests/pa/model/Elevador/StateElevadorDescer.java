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
public class StateElevadorDescer extends StateElevador {

    /**
     *
     * @param elevador
     */
    public StateElevadorDescer(Elevador elevador) {
        super(elevador);
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void subir() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já se encontra em movimento.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador encontra-se em movimento.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Se o elevador tem as portas abertas neste momento estamos despedidos.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void descer() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já se encontra em movimento.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador encontra-se em movimento.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorPortasFechadas(getElevador()));
    }

    @Override
    public String toString() {
        return "\\/"; //To change body of generated methods, choose Tools | Templates.
    }
}