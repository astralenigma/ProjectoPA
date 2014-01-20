/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import java.util.Random;

/**
 * Classe Abstracta do passageiro.
 *
 * @author Rui
 */
public abstract class Passageiro implements Comparable<Passageiro> {

    private int destino, origem;
    private StatePassageiro estado;
    private int tempoDeEspera;

    /**
     * Constructor do Passageiro
     *
     * @param nmrMaxPisos Recebe o numero maximo dos pisos para gerar o destino
     * e a origem.
     */
    public Passageiro(int nmrMaxPisos) {
        Random rd = new Random();
        origem = rd.nextInt(nmrMaxPisos);
        do {
            destino = rd.nextInt(nmrMaxPisos);
        } while (origem == destino);
        estado = new StatePassageiroEmEspera(this);
        tempoDeEspera = 0;
    }

    /**
     * Altera o estado do Passageiro
     *
     * @param estado Espaço que se altera
     */
    public void setEstado(StatePassageiro estado) {
        this.estado = estado;
    }

    private static int compare(Passageiro passageiro) {
        if (passageiro instanceof Deficiente) {
            return 1;
        }
        if (passageiro instanceof Crianca) {
            return 0;
        }
        return -1;
    }

    /**
     * Incrementa o tempo de espera do elevador.
     */
    public void incrementarTempoDeEspera() {
        tempoDeEspera++;
    }

    /**
     * Devolve a origem do passageiro.
     *
     * @return Origem do passageiro.
     */
    public int getOrigem() {
        return origem;
    }

    /**
     * Devolve o destino do passageiro.
     *
     * @return Destino do passageiro.
     */
    public int getDestino() {
        return destino;
    }

    /**
     * Altera o estado do passageiro para em transporte.
     *
     * @return Devolve-se com o novo estado.
     */
    public Passageiro aEntrar() {
        getEstado().entrar();
        return this;
    }

    /**
     * Envia os estado do Passageiro.
     *
     * @return Estado do Passageiro.
     */
    public StatePassageiro getEstado() {
        return estado;
    }

    @Override
    public int compareTo(Passageiro t) {
//        Precisamos de 2 compareTos dependendo do estado do Passageiro talvez tenhamos que verificar o estado do elevador
        if (estado instanceof StatePassageiroEmTransporte) {
            if (destino > origem) {
                return destino - t.destino;
            } else {
                return t.destino - destino;
            }
        }
        return compare(this) - compare(t);
    }
}
