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
    public static final int DEFICIENTE = 0;
    /**
     *
     */
    public static final int CRIANCA = 1;
    /**
     *
     */
    public static final int ADULTO = 2;

    /**
     *
     * @param tipoDePassageiro
     * @param nmrMaxPisos
     * @return
     * @throws IllegalArgumentException
     */
    public abstract Passageiro factoryMethod(int tipoDePassageiro,int nmrMaxPisos) throws IllegalArgumentException;
}
