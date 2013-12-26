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
     *
     */
    public static final int DEFICIENTE = 1;
    /**
     *
     */
    public static final int CRIANCA = 2;
    /**
     *
     */
    public static final int ADULTO = 3;

    /**
     *
     * @param tipoDePassageiro
     * @param nmrMaxPisos
     * @return
     * @throws IllegalArgumentException
     */
    public abstract Passageiro factoryMethod(int tipoDePassageiro,int nmrMaxPisos) throws IllegalArgumentException;
}
