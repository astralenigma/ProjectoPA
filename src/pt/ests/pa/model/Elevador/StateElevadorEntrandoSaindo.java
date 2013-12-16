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
public class StateElevadorEntrandoSaindo extends StateElevador {
    
    public StateElevadorEntrandoSaindo(Elevador elevador) {
        super(elevador);
    }
    
    @Override
    public void subir() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Está a tentar matar alguém?");
    }
    
    @Override
    public void abrirPortas() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Se as portas não estão abertas como é que as pessoas estão a entrar? Queres ver que há fantasmas no prédio?");
    }
    
    @Override
    public void fecharPortas() throws InvalidStateTransitionException {
        getElevador().setEstado(new StateElevadorPortasFechadas(getElevador()));
    }
    
    @Override
    public void descer() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Está a tentar matar alguém?");
    }
    
    @Override
    public void entradaSaidaDePassageiros() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Já se encontram pessoas a sair e a entrar, não sei porque estás a chamar outra vez este estado.");
    }
    
    @Override
    public void pararElevador() throws InvalidStateTransitionException {
        throw new InvalidStateTransitionException("Se o Elevador não está parado então as pessoas neste prédio são loucas.");
    }
}
