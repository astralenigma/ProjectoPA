/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.controller;

import java.util.Observable;
import java.util.Random;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.Predio;
import pt.ests.pa.model.passageiro.ConcreteCreatorPassageiro;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;

/**
 *
 * @author Rui
 */
public class GestorDoPredio  {

    //singleton
    private static GestorDoPredio instance;       
    private Predio predio;     
    
    public static GestorDoPredio getInstance() {
        if(instance == null) {
            instance = new GestorDoPredio();
        }
        return instance;
    }

    /**
     * Cria o predio
     * 
     * @param nmrPisos
     * @param nmrElevadores
     * @param capacidadeElevador 
     */
    public void create(int nmrPisos, int nmrElevadores, int capacidadeElevador) {
        predio = new Predio(nmrPisos, nmrElevadores, capacidadeElevador);
    }

    public Predio getPredio() {
        return predio;
    }
}