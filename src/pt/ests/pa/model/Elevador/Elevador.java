
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.model.Piso;
import pt.ests.pa.model.exceptions.ElevadorNoPisoZeroException;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueue;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueueDynamic;

/**
 * Classe Do Elevador
 *
 * @author Rui
 */
public class Elevador {
//    private static final int pisoMax;

    private static final int CAPACIDADEELEVADOR = 10;
    private int piso;
    private StateElevador estado;
    private PriorityQueue<Passageiro> passageiro;
    private ArrayList<Piso> pisos;
    private int nPisosPercorridos;
    private int tempoDeInactividade;

    /**
     *
     * @param pisos
     */
    public Elevador(ArrayList<Piso> pisos) {
        this.pisos = pisos;
        this.piso = 0;
        this.estado = new StateElevadorPortasFechadas(this);
        this.passageiro = new PriorityQueueDynamic<>(CAPACIDADEELEVADOR);
        tempoDeInactividade = 0;
        nPisosPercorridos = 0;
    }

    /**
     *
     */
    public void subir() {
        piso++;
        nPisosPercorridos++;
    }

    /**
     *
     * @throws ElevadorNoPisoZeroException
     */
    public void descer() throws ElevadorNoPisoZeroException {
        if (piso == 0) {
            throw new ElevadorNoPisoZeroException();
        }
        piso--;
        nPisosPercorridos++;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(StateElevador estado) {
        this.estado = estado;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("|%2s%2s%2s|", estado, passageiro, estado);
    }
}
