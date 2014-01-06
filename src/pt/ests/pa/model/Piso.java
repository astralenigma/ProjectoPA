/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueue;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueueDynamic;

/**
 * Classe dos pisos contem o numero do piso e os passageiros a espera.
 *
 * @author Rui
 */
public class Piso {

    private int nPiso;
    private PriorityQueue<Passageiro> passageiros;

    /**
     * Constructor do piso recebe o numero do piso e gera a fila de passageiros.
     *
     * @param nPiso Numero do piso
     */
    public Piso(int nPiso) {
        this.nPiso = nPiso;
        passageiros = new PriorityQueueDynamic<>();
    }

    /**
     * Método usado para enviar os passageiros para o elevador.
     *
     * @return Passageiro que vai entrar no elevador.
     */
    public Passageiro enviarPassageiro() {
        return passageiros.dequeue();
    }

    @Override
    public String toString() {
        return  passageiros+"";
    }
}