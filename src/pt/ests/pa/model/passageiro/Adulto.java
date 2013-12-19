/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 *
 * @author Rui
 */
public class Adulto extends Passageiro {

    @Override
    public String toString() {
        return "A("+getOrigem()+","+getDestino()+")";
    }
}
