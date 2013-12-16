/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.elevador;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author Rui Carvalho
 */
public abstract class StateElevador {

    private Elevador elevador;

    public StateElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    public Elevador getElevador() {
        return elevador;
    }

    public abstract void subir() throws InvalidStateTransitionException;

    public abstract void paradoPortaAberta() throws InvalidStateTransitionException;

    public abstract void paradoPortaFechada() throws InvalidStateTransitionException;

    public abstract void descer() throws InvalidStateTransitionException;

    public abstract void entradaSaida() throws InvalidStateTransitionException;
}
