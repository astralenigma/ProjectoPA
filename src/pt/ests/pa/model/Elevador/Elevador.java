
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import java.util.Observable;
import java.util.Observer;
import pt.ests.pa.controller.GestorDoPredio;
import pt.ests.pa.model.Piso;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueue;
import pt.ests.pa.model.tads.priorityqueue.PriorityQueueDynamic;

/**
 * Classe Do Elevador
 *
 * @author Rui
 */
public class Elevador implements Observer {

    private int pisoActual;
    private int pisoDestino;
    private int proximoDestino;
    private StateElevador estado;
    private PriorityQueue<Passageiro> passageiro;
    private ArrayList<Piso> pisos;
    private int nPisosPercorridos;
    private int tempoDeInactividade;

    //private ArrayList<Piso> listaPedidos;
    /**
     *
     * Constructor do Elevador.
     *
     * @param pisos Lista dos pisos do prédio.
     * @param capacidadeElevador
     */
    public Elevador(ArrayList<Piso> pisos, int capacidadeElevador) {
        this.pisos = pisos;
        this.pisoActual = 0;
        this.estado = new StateElevadorPortasFechadas(this);
        this.passageiro = new PriorityQueueDynamic<>(capacidadeElevador);
        tempoDeInactividade = 0;
        nPisosPercorridos = 0;
        pisoDestino = 0;
        proximoDestino = 0;
    }

    /**
     * Faz coisas porreiras relacionadas com
     */
    public void atualizar() {
        estado.actualizar();
    }

    /**
     * Método de fazer os elevadores subir.
     */
    public void subir() {
        pisoActual++;
        nPisosPercorridos++;
        getEstado().subir();
    }

    /**
     * Método da verificacao se a capacidade do elevador foi atingida.
     *
     * @return True se o elevador esta cheio, False se a capacidade do elevador
     * ainda nao foi atingida
     */
    public boolean isFull() {
        return passageiro.size() > GestorDoPredio.getInstance().getPredio().getCapacidadeElevador();
    }

    /**
     * Método de fazer os elevadores descer.
     *
     */
    public void descer() {
        pisoActual--;
        nPisosPercorridos++;
        getEstado().descer();
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
     * Comunica o estado do Elevador
     *
     * @return Estado Actual do elevador
     */
    public StateElevador getEstado() {
        return estado;
    }

    public void incrementarInactividade() {
        tempoDeInactividade++;
    }

    public int getProximoDestino() {
        return proximoDestino;
    }

    public int getPisoDestino() {
        return pisoDestino;
    }

    public boolean elevadorEstaASubir() {
        return pisoDestino > pisoActual;
    }

    /**
     * Mostra o piso actual do Elevador.
     *
     * @return Piso Actual do Elevador
     */
    public int getnumPisoActual() {
        return pisoActual;
    }

    /**
     * Envia Numero de passageiros no elevador.
     *
     * @return Numero de passageiros no elevador
     */
    public int getNmrPassageiros() {
        return passageiro.size();
    }

    /**
     * Envia o tempo de Inactividade do elevador.
     *
     * @return Inteiro que representa o tempo de inactividade do elevador em
     * segundos.
     */
    public int getTempoDeInactividade() {
        return tempoDeInactividade;
    }

    /**
     * Devolve o numero de pisos o elevador percorreu.
     *
     * @return Numero de pisos que o elevador percorreu.
     */
    public int getnPisosPercorridos() {
        return nPisosPercorridos;
    }

    /**
     * Recebe Passageiros dos pisos.
     */
    public void receberPassageiros() {
        while (getPisoActual().existemPassageiros(pisoDestino - pisoActual) && !isFull()) {
            passageiro.enqueue(getPisoActual().enviarPassageiro(pisoDestino));
        }
        if (!passageiro.isEmpty()) {
            alterarDestino(passageiro.peek().getDestino());
        }
    }

    public Piso getPisoActual() {
        return pisos.get(pisoActual);
    }

    public void alterarDestino(int novoDestino) {
        if (pisoDestino > pisoActual) {
            pisoDestino = Math.max(novoDestino, pisoDestino);
            if (proximoDestino == pisoActual) {
                proximoDestino = novoDestino;
                pisoDestino =Math.max(novoDestino, pisoDestino);
            } else {
                proximoDestino = Math.max(pisoDestino, novoDestino);
            }
        } else if (pisoDestino < pisoActual) {
            pisoDestino = Math.min(novoDestino, pisoDestino);
            if (proximoDestino == pisoActual) {
                proximoDestino = novoDestino;
            } else {
                proximoDestino = Math.min(pisoDestino, novoDestino);
            }
        } else {
            pisoDestino = proximoDestino = novoDestino;
        }
    }

    @Override
    public String toString() {
        return String.format("|%2s%02d%2s|", estado, passageiro.size(), estado);
    }

    @Override
    public void update(Observable o, Object o1) {
        //
    }

    public boolean isEmpty() {
        return passageiro.isEmpty();
    }

    public int verificarProximo(int piso) {
        return (piso > pisoActual) ? piso - pisoActual : pisoActual - piso;
    }

    public boolean existemPassageirosParaApanhar() {
        return getPisoActual().existemPassageiros(getPisoDestino() - getnumPisoActual());
    }

    public void largarPassageiros() {
        if (!isEmpty()) {
            while (passageiro.peek().getDestino() == pisoActual) {
                passageiro.dequeue();
                if (isEmpty()) {
                    break;
                } else {
                    alterarDestino(passageiro.peek().getDestino());
                }
            }
        }
    }
}
