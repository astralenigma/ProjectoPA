/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 * Classe do Adulto
 *
 * @author Rui
 */
public class Adulto extends Passageiro {

    /**
     *
     * @param nmrMaxPisos
     */
    public Adulto(int nmrMaxPisos) {
        super(nmrMaxPisos);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "A(" + getOrigem() + "," + getDestino() + ")";
    }
}
