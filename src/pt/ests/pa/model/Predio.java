/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import java.util.Observable;
import java.util.Random;
import pt.ests.pa.controller.GestorDoPredio;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.passageiro.ConcreteCreatorPassageiro;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.arraylist.ArrayListDNode;
import pt.ests.pa.model.tads.queue.Queue;
import pt.ests.pa.model.tads.queue.QueueDynamic;

/**
 * Classe do predio cola todos as classes.
 *
 * @author Rui
 */
public class Predio extends Observable implements Runnable {

    //private static Predio instance;
    private ArrayList<Piso> pisos;
    private ArrayList<Elevador> elevadores;
    private ConcreteCreatorPassageiro ccp = new ConcreteCreatorPassageiro();
    private int nmrPisos;
    private int nmrElevadores;
    private int capacidadeElevador;

    /**
     * Método constructor do prédio.
     *
     * @param nmrPisos O número de pisos do prédio.
     * @param nmrElevadores O número de elevadores do prédio.
     * @param capacidadeElevador A capacidade dos elevadores do prédio.
     */
    public Predio(int nmrPisos, int nmrElevadores, int capacidadeElevador) {
        this.nmrPisos = nmrPisos;
        this.nmrElevadores = nmrElevadores;
        this.capacidadeElevador = capacidadeElevador;

        pisos = new ArrayListDNode<>();
        for (int i = 0; i < nmrPisos; i++) {
            pisos.add(i, new Piso(i));
        }
        elevadores = new ArrayListDNode<>();
        for (int i = 0; i < nmrElevadores; i++) {
            elevadores.add(i, new Elevador(pisos, capacidadeElevador));
        }
    }

    /**
     * Simula uma iteração no prédio.
     */
    public void simulaIteracao() {

        criarPassageiros();
        atualizarElevadores();

        //atualizarEstatisticas();

        setChanged();
        notifyObservers();
    }

    @Override
    public void run() {
        while (true) {
            simulaIteracao();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /**
     * Devolve a lista de elevadores no prédio.
     *
     * @return A lista de elevadores no prédio.
     */
    public ArrayList<Elevador> getElevadores() {
        return elevadores;
    }

    /**
     * Devolve o nmr maximo de pisos.
     *
     * @return Inteiro com o tamanho do prédio
     */
    public int getMaxPisos() {
        return pisos.size();
    }

    /**
     * Método que cria os passageiros.
     */
    private void criarPassageiros() {
        Random rd = new Random();
        if (rd.nextBoolean()) {
            Passageiro p = ccp.factoryMethod(rd.nextInt(3), nmrPisos);
            gerarPassageiro(p.getOrigem(), p);
            setChanged();
        }
    }

    /**
     * Insere um passageiro no seu piso de origem.
     *
     * @param nmrPiso Numero do piso onde o passageiro tem origem.
     * @param p Passageiro a ser inserido.
     */
    public void gerarPassageiro(int nmrPiso, Passageiro p) {
        pisos.get(nmrPiso).gerarPassageiros(p);
        Queue<Elevador> queue = listaElevadoresDisponiveis(p.getDestino() - p.getOrigem());
        if (!(queue.isEmpty())) {
            elevadorMaisProximo(nmrPiso, queue).alterarDestino(nmrPiso);
        }

    }

    @Override
    public String toString() {
        String str = "---------------------------------------------------------------------\n"
                + "-------------------------------Predio--------------------------------\n"
                + "---------------------------------------------------------------------\n";
        for (int i = pisos.size() - 1; i >= 0; i--) {
            str += String.format("%02d", i) + String.format("%30s|", pisos.get(i));
            for (int j = 0; j < elevadores.size(); j++) {
                str += String.format("%8s", (elevadores.get(j).getnumPisoActual() == i) ? elevadores.get(j) : "");
            }
            str += "|" + pisos.get(i).passageirosAtendidos() + "\n";
        }
        for (int i = 0; i < elevadores.size(); i++) {
            str += ("Numero do elevador: " + (i + 1) + "\n");
            str += ("Numero de passageiros no elevador: " + elevadores.get(i).getNmrPassageiros() + "\n");
            str += ("Estado do Elevador: " + elevadores.get(i).getEstado().palavras() + "\n");
            str += ("Distancia Percorrida: " + elevadores.get(i).getnPisosPercorridos() + "\n");
        }
        return str;
    }

    /**
     * Elevador mais próximo do piso actual.
     *
     * @param pisoActual O número do piso actual.
     * @param elevadores Recebe a lista de elevadores dísponíveis.
     * @return Devolve o elevador mais próximo do passageiro.
     */
    public Elevador elevadorMaisProximo(int pisoActual, Queue<Elevador> elevadores) {
        Elevador maisProximo = elevadores.dequeue();
        for (int i = 1; !elevadores.isEmpty(); i++) {
            maisProximo = (elevadores.peek().verificarProximo(pisoActual) > maisProximo.verificarProximo(pisoActual)) ? elevadores.peek() : maisProximo;
            elevadores.dequeue();
        }
        return maisProximo;
    }

    /**
     * Devolve o número de elevadores no prédio.
     *
     * @return O número de elevadores no prédio.
     */
    public int getNmrElevadores() {
        return nmrElevadores;
    }

    /**
     * Devolve a capacidade máxima de elevadores.
     *
     * @return capacidade dos elevadores.
     */
    public int getCapacidadeElevador() {
        return capacidadeElevador;
    }

    /**
     * Método que actualiza os elevadores.
     */
    private void atualizarElevadores() {
        for (int i = 0; i < nmrElevadores; i++) {
            elevadores.get(i).actualizar();
        }
    }

    /**
     * Cria uma lista com todos os elevadores que estão a subir.
     *
     * @return Devolve um Queue de elevadores
     */
    private Queue<Elevador> listaElevadoresASubir() {
        Queue<Elevador> listaElevadores = new QueueDynamic<>();
        for (int i = 0; i < nmrElevadores; i++) {
            if (!elevadores.get(i).naoTemDestino()) {
                if (elevadores.get(i).getnumPisoActual() < elevadores.get(i).getPisoDestino()) {
                    listaElevadores.enqueue(elevadores.get(i));
                }
            }
        }
        return listaElevadores;
    }

    /**
     * Cria uma lista com todos os elevadores que estão a descer.
     *
     * @return Devolve um Queue de elevadores
     */
    private Queue<Elevador> listaElevadoresADescer() {
        Queue<Elevador> listaElevadores = new QueueDynamic<>();
        for (int i = 0; i < nmrElevadores; i++) {
            if (!elevadores.get(i).naoTemDestino()) {
                if (elevadores.get(i).getnumPisoActual() > elevadores.get(i).getPisoDestino()) {
                    listaElevadores.enqueue(elevadores.get(i));
                }
            }
        }
        return listaElevadores;
    }

    /**
     * Cria uma lista com todos os elevadores que Parados.
     *
     * @return Devolve um Queue de elevadores
     */
    private Queue<Elevador> listaElevadoresParados() {
        Queue<Elevador> listaElevadores = new QueueDynamic<>();
        for (int i = 0; i < nmrElevadores; i++) {
            if (elevadores.get(i).naoTemDestino()) {
                listaElevadores.enqueue(elevadores.get(i));
            }
        }
        return listaElevadores;
    }

    /**
     * Cria uma lista de todos os elevadores disponiveis.
     *
     * @return Devolve um Queue de elevadores
     */
    private Queue<Elevador> listaElevadoresDisponiveis(int direcao) {
        Queue<Elevador> listaElevadores = new QueueDynamic<>();
        if (direcao > 0) {
            listaElevadores = listaElevadoresASubir();
        }
        if (direcao < 0) {
            listaElevadores = listaElevadoresADescer();
        }
        Queue<Elevador> listaElevadoresParados = listaElevadoresParados();
        while (!listaElevadoresParados.isEmpty()) {
            listaElevadores.enqueue(listaElevadoresParados.dequeue());
        }
        return listaElevadores;
    }

    private void atualizarEstatisticas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Piso> getPisos() {
        return pisos;
    }
    
}
