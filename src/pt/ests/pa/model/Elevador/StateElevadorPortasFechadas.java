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
public class StateElevadorPortasFechadas extends StateElevador {

    public StateElevadorPortasFechadas(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() throws InvalidStateTransitionException {
        
    }

    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        
    }

    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Hmm... Como é que se fecha o que já está fechado?");
    }

    @Override
    public void descer() throws InvalidStateTransitionException {
        //getElevador().
    }

    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Não é possível entrar num elevador com as portas fechadas porque o simulador não aceita fantasmas.");
    }

    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já se encontra parado.");
    }
}
