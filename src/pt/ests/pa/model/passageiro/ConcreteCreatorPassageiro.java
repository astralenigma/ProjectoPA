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

    /**
     * Fábrica de passageiros
     *
     * @param tipoDePassageiro Recebe um inteiro para decidir o tipo de
     * passageiro.
     * @param nmrMaxPisos Recebe o Numero de pisos do Predio.
     * @return Passageiro Devolve um passageiro.
     * @throws IllegalArgumentException Para precaver
     */
    @Override
    public Passageiro factoryMethod(int tipoDePassageiro, int nmrMaxPisos) throws IllegalArgumentException {
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
