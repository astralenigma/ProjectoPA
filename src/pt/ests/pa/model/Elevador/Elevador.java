
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

    private int piso;
    private StateElevador estado;
    private PriorityQueue<Passageiro> passageiro;
    private ArrayList<Piso> pisos;
    private int nPisosPercorridos;
    private int tempoDeInactividade;

    /**
     * Constructor do Elevador.
     *
     * @param pisos Lista dos pisos do prédio.
     */
    public Elevador(ArrayList<Piso> pisos, int capacidadeElevador) {
        this.pisos = pisos;
        this.piso = 0;
        this.estado = new StateElevadorPortasFechadas(this);
        this.passageiro = new PriorityQueueDynamic<>(capacidadeElevador);
        tempoDeInactividade = 0;
        nPisosPercorridos = 0;
    }

    /**
     * Método de fazer os elevadores subir.
     */
    public void subir() {
        piso++;
        nPisosPercorridos++;
    }

    /**
     * Método de fazer os elevadores descer.
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
     * Altera o estado do Elevador.
     *
     * @param estado Novo estado do elevador.
     */
    public void setEstado(StateElevador estado) {
        this.estado = estado;
    }

    /**
     * Recebe Passageiros dos pisos.
     */
    public void receberPassageiros() {
        passageiro.enqueue(pisos.get(piso).enviarPassageiro());
    }

    @Override
    public String toString() {
        return String.format("|%2s%2s%2s|", estado, passageiro, estado);
    }
}
