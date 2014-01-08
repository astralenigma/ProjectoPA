
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
    private StateElevador estado;
    private PriorityQueue<Passageiro> passageiro;
    private ArrayList<Piso> pisos;
    private int nPisosPercorridos;
    private int tempoDeInactividade;
    private int destino;

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
        destino = 0;
    }

    /**
     * Método de fazer os elevadores subir.
     */
    public void subir() {
        getEstado().subir();
        pisoActual++;
        nPisosPercorridos++;
    }

    /**
     * Método da verificacao se a capacidade do elevador foi atingida.
     *
     * @return True se o elevador esta cheio, False se a capacidade do elevador
     * ainda nao foi atingida
     */
    public boolean isFull() {
        return passageiro.size() > GestorDoPredio.getCapacidadeElevador();
    }

    /**
     * Método de fazer os elevadores descer.
     *
     */
    public void descer() {
        getEstado().descer();
        pisoActual--;
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
     * Comunica o estado do Elevador
     *
     * @return Estado Actual do elevador
     */
    public StateElevador getEstado() {
        return estado;
    }

    public boolean elevadorEstaASubir() {
        return destino > pisoActual;
    }

    /**
     * Mostra o piso actual do Elevador.
     *
     * @return Piso Actual do Elevador
     */
    public int getPisoActual() {
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

    public void entrarPassageiros() {
        getEstado().entradaSaidaDePassageiros();
        receberPassageiros();
    }

    /**
     * Recebe Passageiros dos pisos.
     */
    public void receberPassageiros() {
        if (elevadorEstaASubir()) {
            while (pisos.get(pisoActual).existePassageiroSubir()&&!isFull()) {
                passageiro.enqueue(pisos.get(pisoActual).enviarPassageiro(elevadorEstaASubir()));
            }
        }else{
            while (pisos.get(pisoActual).existePassageiroDescer()&&!isFull()) {
                passageiro.enqueue(pisos.get(pisoActual).enviarPassageiro(elevadorEstaASubir()));
            }
        }
        if (!passageiro.isEmpty()) {
            alterarDestino(passageiro.peek().getDestino());
        }
    }

    public void alterarDestino(int novoDestino) {
        destino = novoDestino;
    }

    public void locomoverElevador() {
        if (pisoActual != passageiro.peek().getDestino()) {
            if (pisoActual < passageiro.peek().getDestino()) {
                subir();
            }
            if (pisoActual > passageiro.peek().getDestino()) {
                descer();
            }
        } else {
            parar();
        }
    }

    public void parar() {
        getEstado().pararElevador();
    }

    public void elevadorAAgir() {
        //verificacoes
        alterarDestino(1337);
        //accoes
        
    }
    public void accaoDoElevador(){
        
    }
    public void elevadorAbrirFecharPortas(){
        
    }
    @Override
    public String toString() {
        return String.format("|%2s%02d%2s|", estado, passageiro.size(), estado);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (o instanceof GestorDoPredio) {
        }
    }

    public int verificarProximo(int piso) {
        return (piso > pisoActual) ? piso - pisoActual : pisoActual - piso;
    }
}
