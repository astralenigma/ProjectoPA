/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 * Classe do Crianca
 *
 * @author Rui
 */
public class Crianca extends Passageiro {

    /**
     *
     * @param nmrMaxPisos
     */
    public Crianca(int nmrMaxPisos) {
        super(nmrMaxPisos);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "C(" + getOrigem() + "," + getDestino() + ")";
    }
}
