/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 *
 * @author Rui
 */
public class ConcreteCreatorPassageiro extends CreatorPassageiro {

    @Override
    public Passageiro factoryMethod(int tipoDePassageiro) throws IllegalArgumentException {
        switch (tipoDePassageiro) {
            case DEFICIENTE:
                return new Deficiente();
            case CRIANCA:
                return new Crianca();
            case ADULTO:
                return new Adulto();
            default:
                throw new IllegalArgumentException("Erro");
        }
    }
}
