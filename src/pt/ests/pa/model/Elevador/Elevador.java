
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
import pt.ests.pa.model.tads.arraylist.ArrayListDNode;
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
    private ArrayList<Integer> listaPedidos;

    /**
     * Constructor do Elevador.
     *
     * @param pisos Lista dos pisos do prédio.
     * @param capacidadeElevador
     */
    public Elevador(ArrayList<Piso> pisos, int capacidadeElevador) {
        this.pisos = pisos;
        this.pisoActual = 0;
        this.passageiro = new PriorityQueueDynamic<>(capacidadeElevador);
        tempoDeInactividade = 0;
        nPisosPercorridos = 0;
        listaPedidos = new ArrayListDNode<>();
        this.estado = new StateElevadorPortasFechadas(this);
    }

    /**
     * Actualiza o estado do elevador.
     */
    public void actualizar() {
        estado.actualizar();
    }

    /**
     * Método de fazer os elevadores subir.
     */
    public void subir() {
        pisoActual++;
        nPisosPercorridos++;
    }

    /**
     * Método da verificacao se a capacidade do elevador foi atingida.
     *
     * @return True se o elevador esta cheio, False se a capacidade do elevador
     * ainda nao foi atingida
     */
    public boolean estaCheio() {
        return passageiro.size() == GestorDoPredio.getInstance().getPredio().getCapacidadeElevador();
    }

    /**
     * Método de fazer os elevadores descer.
     *
     */
    public void descer() {
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

    /**
     * Incrementa o tempo que o elevador esta Parado.
     */
    public void incrementarInactividade() {
        tempoDeInactividade++;
    }

    public int getProximoDestino() {
        if (listaPedidos.isEmpty()) {
            return -1;
        }
        return listaPedidos.get(0);
    }

    public int getPisoDestino() {
        if (listaPedidos.isEmpty()) {
            return -1;
        }
        return listaPedidos.get(listaPedidos.size() - 1);
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
        while (getPisoActual().existemPassageiros(getPisoDestino() - pisoActual) && !estaCheio()) {
            passageiro.enqueue(getPisoActual().enviarPassageiro(getPisoDestino()));
            alterarDestino(pisos.get(passageiro.peek().getDestino()));
        }
    }

    public Piso getPisoActual() {
        return pisos.get(pisoActual);
    }

    /**
     * Compara o destino com a lista de destinos e adiciona.
     *
     * @param novoDestino novo destino a ser acrescentado à lista.
     */
    public void alterarDestino(int novoDestino) {
        if (listaPedidos.isEmpty()) {
            listaPedidos.add(0, novoDestino);
        } else {
            if (listaPedidos.get(listaPedidos.size() - 1).getnPiso() > pisoActual) {
                for (int i = 0; i < listaPedidos.size(); i++) {
                    if (listaPedidos.get(i) <= novoDestino) {
                        listaPedidos.add(i, novoDestino);
                        break;
                    }
                }
            } else {
                for (int i = 0; i < listaPedidos.size(); i++) {
                    if (listaPedidos.get(i).getnPiso() >= novoDestino.getnPiso()) {
                        listaPedidos.add(i, novoDestino);
                        break;
                    }
                }
            }
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

    /**
     * Verifica se existem passageiros.
     *
     * @return Retorna um boolean dependendo da quantidade de passageiros.
     */
    public boolean estaVazio() {
        return passageiro.isEmpty();
    }

    /**
     * Método que remove um pedido.
     */
    public void removerPedido() {
        for (int i = listaPedidos.size(); i > 0; i--) {
            if (listaPedidos.get(i) == getPisoActual()) {
                listaPedidos.remove(i);
            }
        }
    }

    /**
     * Método que compara a distancia entre o elevador e um piso.
     *
     * @param piso Piso a comparar
     * @return Devolve a distancia entre o elevador e o piso.
     */
    public int verificarProximo(int piso) {
        return (piso > pisoActual) ? piso - pisoActual : pisoActual - piso;
    }

    /**
     * Verifica se existem passageiros no piso com destino a subir ou a descer.
     *
     * @return
     */
    public boolean existemPassageirosParaApanhar() {
        return getPisoActual().existemPassageiros(getPisoDestino() - getnumPisoActual());
    }

    /**
     * Método que envia os passageiros do elevador para o piso.
     */
    public void largarPassageiros() {
        if (!estaVazio()) {
            while (passageiro.peek().getDestino() == pisoActual) {
                pisos.get(pisoActual).receberPassageiro(passageiro.dequeue());
            }
        }
    }

    /**
     * Verifica se o elevador tem pedidos.
     *
     * @return Devolve false se tiver destino e true se não tiver.
     */
    public boolean naoTemDestino() {
        return listaPedidos.isEmpty();
    }
}
