/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.Iterator;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueue;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueueDynamic;
import pt.ests.pa.model.tads.queue.Queue;
import pt.ests.pa.model.tads.queue.QueueDynamic;

/**
 * Classe dos pisos contem o numero do piso e os passageiros a espera.
 *
 * @author Rui
 */
public class Piso {

    private int nPiso;
    private PriorityQueue<Passageiro> passageirosASubir;
    private PriorityQueue<Passageiro> passageirosADescer;
    private Queue<Passageiro> passageirosAtendidos;

    /**
     * Constructor do piso recebe o numero do piso e gera a fila de passageiros.
     *
     * @param nPiso Numero do piso
     */
    public Piso(int nPiso) {
        this.nPiso = nPiso;
        passageirosADescer = new PriorityQueueDynamic<>();
        passageirosASubir = new PriorityQueueDynamic<>();
        passageirosAtendidos = new QueueDynamic<>();
    }

    /**
     * Método usado para enviar os passageiros para o elevador.
     *
     * @param pisoDestino o destino do elevador
     * @return Passageiro que vai entrar no elevador.
     */
    public Passageiro enviarPassageiro(int pisoDestino) {
        if (pisoDestino == nPiso) {
            if (!passageirosASubir.isEmpty()) {
                return passageirosASubir.dequeue();
            } else {
                return passageirosADescer.dequeue();
            }
        }
        if (pisoDestino > nPiso) {
            return passageirosASubir.dequeue().aEntrar();
        } else {
            return passageirosADescer.dequeue().aEntrar();
        }
    }

    public boolean existemPassageiros(int direccao) {
        if (direccao>0) {
            return existePassageiroSubir();
        } if (direccao<0) {
            return existePassageiroDescer();
        }
        return (existePassageiroDescer() || existePassageiroSubir());
    }

    /**
     * Metodo que verifica a existencia de passageiros a descer.
     *
     * @return Devolve true se existerem passageiros na fila para descer.
     */
    public boolean existePassageiroDescer() {
        return !passageirosADescer.isEmpty();
    }

    /**
     * Metodo que verifica a existencia de passageiros a subir.
     *
     * @return Devolve true se existerem passageiros na fila para subir.
     */
    public boolean existePassageiroSubir() {
        return !passageirosASubir.isEmpty();
    }

    /**
     * Método usado para receber os passageiros do elevador.
     *
     * @param p
     */
    public void receberPassageiro(Passageiro p) {
        passageirosAtendidos.enqueue(p);
    }

    /**
     * Método usado para gerar os passageiros no piso.
     *
     * @param p Passageiro a ser criado.
     */
    public void gerarPassageiros(Passageiro p) {
        if (p.getOrigem() > p.getDestino()) {
            passageirosADescer.enqueue(p);
        } else {
            passageirosASubir.enqueue(p);
        }
    }

    @Override
    public String toString() {
        PriorityQueue<Passageiro> passsageiros = new PriorityQueueDynamic<>();
        Iterator<Passageiro> it = passageirosADescer.getIterator();
        while (it.hasNext()) {
            passsageiros.enqueue(it.next());
        }
        it = passageirosASubir.getIterator();
        while (it.hasNext()) {
            passsageiros.enqueue(it.next());
        }
        return passsageiros + "";
    }
}