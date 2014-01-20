/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 * Classe da Crianca
 *
 * @author Rui
 */
public class Crianca extends Passageiro {

    
    public Crianca(int nmrMaxPisos) {
        super(nmrMaxPisos);
    }

    
    @Override
    public String toString() {
        return "C(" + getOrigem() + "," + getDestino() + ")";
    }
}
