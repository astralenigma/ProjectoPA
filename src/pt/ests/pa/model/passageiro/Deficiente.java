/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 * Classe do Deficiente
 *
 * @author Rui
 */
public class Deficiente extends Passageiro {

    /**
     *
     * @param nmrMaxPisos
     */
    public Deficiente(int nmrMaxPisos) {
        super(nmrMaxPisos);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "D(" + getOrigem() + "," + getDestino() + ")";
    }
}
