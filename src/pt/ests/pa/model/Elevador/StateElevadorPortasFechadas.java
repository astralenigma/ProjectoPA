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

    /**
     *
     * @param elevador
     */
    public StateElevadorPortasFechadas(Elevador elevador) {
        super(elevador);
        getElevador().removerDestinos();
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void subir() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorSubir(getElevador()));
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorPortasAbertas(getElevador()));
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Hmm... Como é que se fecha o que já está fechado?");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void descer() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorDescer(getElevador()));
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Não é possível entrar num elevador com as portas fechadas porque o simulador não aceita fantasmas.");
    }

    /**
     *
     * @throws InvalidStateTransitionException
     */
    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("O elevador já se encontra parado.");
    }

    @Override
    public String toString() {
        return "||";
    }

    @Override
    public String palavras() {
        return "Parado";
    }

    @Override
    public void actualizar() {
        if (getElevador().naoTemDestino()) {
            getElevador().incrementarInactividade();
        } else {
            if (getElevador().getnumPisoActual() == getElevador().getProximoDestino()) {
                abrirPortas();
            } else {
                if (getElevador().getnumPisoActual() < getElevador().getProximoDestino()) {
                    getElevador().subir();
                }
                if (getElevador().getnumPisoActual() > getElevador().getProximoDestino()) {
                    getElevador().descer();
                }
            }
        }
    }
}
