/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 *
 * @author Rui
 */
public class Crianca extends Passageiro {

    @Override
    public String toString() {
        return "C("+getOrigem()+","+getDestino()+")";
    }
}
