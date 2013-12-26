/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author Rui Carvalho
 */
public abstract class StateElevador {

    private Elevador elevador;

    /**
     *
     * @param elevador
     */
    public StateElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    /**
     *
     * @return
     */
    public Elevador getElevador() {
        return elevador;
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void subir() throws InvalidStateTransitionException;

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void abrirPortas() throws InvalidStateTransitionException;

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void fecharPortas() throws InvalidStateTransitionException;

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void descer() throws InvalidStateTransitionException;

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void entradaSaidaDePassageiros() throws InvalidStateTransitionException;

    /**
     *
     * @throws InvalidStateTransitionException
     */
    public abstract void pararElevador() throws InvalidStateTransitionException;
}
