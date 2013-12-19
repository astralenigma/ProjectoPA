
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.model.ElevadorNoPisoZeroException;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueue;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueueDynamic;

/**
 *
 * @author Rui
 */
public class Elevador {
//    private static final int pisoMax;

    private static final int CAPACIDADEELEVADOR = 10;
    private int piso;
    private StateElevador estado;
    private boolean estadoDasPortas;
    private PriorityQueue<Passageiro> passageiro;
    private int nPisosPercorridos = 0;

    public Elevador(int piso) {
        this.piso = piso;
        this.estado = new StateElevadorPortasFechadas(this);
        this.passageiro = new PriorityQueueDynamic<>(CAPACIDADEELEVADOR);
    }

    public void subir() {
        piso++;
        nPisosPercorridos++;
    }

    public void descer() throws ElevadorNoPisoZeroException {
        if (piso == 0) {
            throw new ElevadorNoPisoZeroException();
        }
        piso--;
        nPisosPercorridos++;
    }

    public void setEstado(StateElevador estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("|%2s%2s%2s|",estado, passageiro,estado);
    }
}
