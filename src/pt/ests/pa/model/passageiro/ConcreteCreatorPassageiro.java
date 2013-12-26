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

    /**
     *
     * @param tipoDePassageiro
     * @param nmrMaxPisos
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Passageiro factoryMethod(int tipoDePassageiro,int nmrMaxPisos) throws IllegalArgumentException {
        switch (tipoDePassageiro) {
            case DEFICIENTE:
                return new Deficiente(nmrMaxPisos);
            case CRIANCA:
                return new Crianca(nmrMaxPisos);
            case ADULTO:
                return new Adulto(nmrMaxPisos);
            default:
                throw new IllegalArgumentException("Erro");
        }
    }
}
