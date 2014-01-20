/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 * Classe Concreta do factory de passageiros.
 *
 * @author Rui
 */
public class ConcreteCreatorPassageiro extends CreatorPassageiro {

    
    @Override
    public Passageiro factoryMethod(int tipoDePassageiro, int nmrMaxPisos) throws IllegalArgumentException {
        switch (tipoDePassageiro) {
            default:
                return new Deficiente(nmrMaxPisos);
            case CRIANCA:
                return new Crianca(nmrMaxPisos);
            case ADULTO:
                return new Adulto(nmrMaxPisos);
        }
    }
}
