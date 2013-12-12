/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import pt.ests.pa.model.Elevador.*;
import pt.ests.pa.model.exceptions.InvalidStateTransitionException;

/**
 *
 * @author brunomnsilva
 */
public abstract class StatePassageiro {

    private Passageiro machine;

    public StatePassageiro(Passageiro machine) {
        this.machine = machine;
    }

    public Passageiro getPassageiro() {
        return machine;
    }

    public abstract void servido() throws InvalidStateTransitionException;

    public abstract void emEspera() throws InvalidStateTransitionException;

    public abstract void emTransporte() throws InvalidStateTransitionException;
}
