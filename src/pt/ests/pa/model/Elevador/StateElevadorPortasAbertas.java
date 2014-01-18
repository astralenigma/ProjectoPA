
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

    /**
     *
     * @param elevador
     */
    public StateElevadorPortasAbertas(Elevador elevador) {
        super(elevador);
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void subir() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador tem as portas abertas.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já tem as portas abertas.");
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
        throw new InvalidStateTransitionException("O elevador tem as portas abertas.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorEntrandoSaindo(getElevador()));
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador ja se encontra parado.");
    }

    @Override
    public String toString() {
        return "  ";
    }

    @Override
    public String palavras() {
        return "Com as Portas Abertas";
    }

    @Override
    public void actualizar() {
        if (!getElevador().estaVazio()||getElevador().getPisoActual().existemPassageiros(getElevador().getPisoDestino()-getElevador().getnumPisoActual())) {
            entradaSaidaDePassageiros();
        } else {
            fecharPortas();
        }
    }
    
}
