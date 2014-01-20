/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 *
 * @author Rui
 */
public abstract class CreatorPassageiro {

    /**
     * Constante do deficiente.
     */
    public static final int DEFICIENTE = 0;
    /**
     * Constante da criança.
     */
    public static final int CRIANCA = 1;
    /**
     * Constante do Adulto.
     */
    public static final int ADULTO = 2;

    /**
     * Fábrica de passageiros
     *
     * @param tipoDePassageiro Recebe um inteiro para decidir o tipo de
     * passageiro.
     * @param nmrMaxPisos Recebe o Numero de pisos do Predio.
     * @return Passageiro Devolve um passageiro.
     * @throws IllegalArgumentException Para precaver
     */
    public abstract Passageiro factoryMethod(int tipoDePassageiro,int nmrMaxPisos) throws IllegalArgumentException;
}
