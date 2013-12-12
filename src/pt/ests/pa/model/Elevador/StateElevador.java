/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author brunomnsilva
 */
public abstract class StateElevador {

    private Elevador machine;

    public StateElevador(Elevador machine) {
        this.machine = machine;
    }

    public Elevador getElevador() {
        return machine;
    }

    public abstract void subir() throws InvalidStateTransitionException;

    public abstract void paradoPortaAberta() throws InvalidStateTransitionException;

    public abstract void paradoPortaFechada() throws InvalidStateTransitionException;

    public abstract void descer() throws InvalidStateTransitionException;

    public abstract void entradaSaida() throws InvalidStateTransitionException;
}
