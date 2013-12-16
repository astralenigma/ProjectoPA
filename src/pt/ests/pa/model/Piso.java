/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueue;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueueDynamic;

/**
 *
 * @author Rui
 */
public class Piso {
    private int nPiso;
    private PriorityQueue<Passageiro> passageiros;

    public Piso(int nPiso) {
        this.nPiso=nPiso;
        passageiros=new PriorityQueueDynamic<>();
    }
}