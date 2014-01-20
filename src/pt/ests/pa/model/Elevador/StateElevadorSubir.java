/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.controller.GestorDoPredio;
import pt.ests.pa.model.exceptions.InvalidStateTransitionException;
import pt.ests.pa.model.exceptions.ManobraIlegalException;

/**
 *
 * @author Rui
 */
public class StateElevadorSubir extends StateElevador {

    /**
     *
     * @param elevador
     */
    public StateElevadorSubir(Elevador elevador) {
        super(elevador);
    }

    @Override
    public void subir() throws InvalidStateTransitionException {
        getElevador().subir();
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
        throw new InvalidStateTransitionException("O elevador já se encontra em movimento.");
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
        return "/\\";
    }

    @Override
    public String palavras() {
        return "A Subir";
    }

    @Override
    public void actualizar() {
        if (getElevador().getnumPisoActual() < getElevador().getProximoDestino()) {
            subir();
        } else {
            if (getElevador().getnumPisoActual() == getElevador().getProximoDestino()) {
                pararElevador();
            }
        }
        //Código de imprevistos.
        if(getElevador().getnumPisoActual() > getElevador().getProximoDestino()){
            for (int i = 0; i < GestorDoPredio.getInstance().getPredio().getNmrElevadores(); i++) {
                if (getElevador() == GestorDoPredio.getInstance().getPredio().getElevadores().get(i)) {
                    throw new ManobraIlegalException("O elevador criminoso é " + (i + 1));
                }
            }
            
        }
    }
    //NAO DEVE ACONTECER a situacao restante
}
