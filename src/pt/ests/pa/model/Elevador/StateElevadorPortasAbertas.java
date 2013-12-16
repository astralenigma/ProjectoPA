
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
public class StateElevadorPortasAbertas extends StateElevador {

    public StateElevadorPortasAbertas(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador tem as portas abertas.");
    }

    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já tem as portas abertas.");
    }

    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorPortasFechadas(getElevador()));
    }

    @Override
    public void descer() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador tem as portas abertas.");
    }

    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorEntrandoSaindo(getElevador()));
    }

    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador ja se encontra parado.");
    }
}
