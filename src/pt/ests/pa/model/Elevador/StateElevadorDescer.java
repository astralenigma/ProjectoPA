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

    public StateElevadorDescer(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já se encontra em movimento.");
    }

    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador encontra-se em movimento.");
    }

    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Se o elevador tem as portas abertas neste momento estamos despedidos.");
    }

    @Override
    public void descer() throws InvalidStateTransitionException {
    }

    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador encontra-se em movimento.");
    }

    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorPortasFechadas(getElevador()));
    }

    @Override
    public String toString() {
        return "\\/";
    }

    @Override
    public String palavras() {
        return "A Descer";
    }

    @Override
    public void actualizar() {
        if (getElevador().getnumPisoActual() < getElevador().getPisoDestino()) {
            getElevador().descer();
        } else if (getElevador().getnumPisoActual() == getElevador().getPisoDestino()) {
            pararElevador();
        }
    }
}