/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

import java.util.Random;
import pt.ests.pa.model.Elevador.Elevador;

/**
 *
 * @author Rui
 */
public class Passageiro implements Comparable<Passageiro> {

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
     *
     */
    public void incrementarTempoDeEspera() {
        tempoDeEspera++;
    }

    /**
     *
     * @return
     */
    public int getOrigem() {
        return origem;
    }

    /**
     *
     * @return
     */
    public int getDestino() {
        return destino;
    }
    public Passageiro aEntrar(){
        getEstado().entrar();
        return this;
    }
    
    public StatePassageiro getEstado() {
        return estado;
    }

    /**
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Passageiro t) {
//        Precisamos de 2 compareTos dependendo do estado do Passageiro talvez tenhamos que verificar o estado do elevador
        if (estado instanceof StatePassageiroEmTransporte) {
            if (destino>origem) {
                return destino-t.destino;
            }else{
                return t.destino-destino;
            }
        }
        return compare(this) - compare(t);
    }
}
