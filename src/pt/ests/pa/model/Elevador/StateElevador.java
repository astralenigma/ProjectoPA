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
     * Constructor do estado do elevador
     * 
     * @param elevador O elevador ao qual pertence o estado.
     */
    public StateElevador(Elevador elevador) {
        this.elevador = elevador;
    }

    /**
     *Devolve o elevador ao qual pertence o estado.
     * 
     * @return Elevador ao qual pertence o estado.
     */
    public Elevador getElevador() {
        return elevador;
    }

    /**
     * A acção do elevador a subir.
     *
     * @throws InvalidStateTransitionException Se o elevador não puder subir.
     */
    public abstract void subir() throws InvalidStateTransitionException;

    /**
     * A acção do elevador a abrir portas.
     *
     * @throws InvalidStateTransitionException Se o elevador não puder abrir as
     * portas.
     */
    public abstract void abrirPortas() throws InvalidStateTransitionException;

    /**
     * A acção do elevador a fechar portas.
     *
     * @throws InvalidStateTransitionException Se o elevador não puder fechar as
     * portas.
     */
    public abstract void fecharPortas() throws InvalidStateTransitionException;

    /**
     * A acção do elevador a descer.
     *
     * @throws InvalidStateTransitionException Se o elevador não puder descer.
     */
    public abstract void descer() throws InvalidStateTransitionException;

    /**
     * A acção do elevador a receber ou largar passageiros.
     *
     * @throws InvalidStateTransitionException Se o elevador não puder receber
     * ou largar os passageiros.
     */
    public abstract void entradaSaidaDePassageiros() throws InvalidStateTransitionException;

    /**
     * A acção do elevador a parar.
     *
     * @throws InvalidStateTransitionException Se o elevador não puder parar.
     */
    public abstract void pararElevador() throws InvalidStateTransitionException;

    /**
     * Apresenta o estado actual do Elevador
     *
     * @return Estado Actual do Elevador por palavras.
     */
    public abstract String palavras();

    /**
     * Actualiza o estado do elevador.
     */
    public abstract void actualizar();
}
