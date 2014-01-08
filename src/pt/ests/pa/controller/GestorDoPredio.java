/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.controller;

import java.util.Observable;
import java.util.Random;
import pt.ests.pa.model.Predio;
import pt.ests.pa.model.passageiro.ConcreteCreatorPassageiro;
import pt.ests.pa.model.passageiro.Passageiro;

/**
 *
 * @author Rui
 */
public class GestorDoPredio extends Observable {

    private static int nmrPisos;
    private static int nmrElevadores;
    private static int capacidadeElevador;
    private ConcreteCreatorPassageiro ccp = new ConcreteCreatorPassageiro();

    public GestorDoPredio(int nmrPisos, int nmrElevadores, int capacidadeElevador) {
        GestorDoPredio.capacidadeElevador = capacidadeElevador;
        GestorDoPredio.nmrElevadores = nmrElevadores;
        GestorDoPredio.nmrPisos = nmrPisos;
    }

    /**
     * Método que cria os passageiros.
     */
    public void criarPassageiros() {
        Random rd = new Random();
        if (rd.nextBoolean()) {
            notifyObservers();
            Passageiro p = ccp.factoryMethod(rd.nextInt(3), nmrPisos);
            Predio.getInstance().gerarPassageiro(p.getOrigem(), p);
        }
    }

    /**
     *
     */
    public void accaoElevadores() {
//        ArrayList<Elevador> al=Predio.getInstance().getElevadores();
//        for (int i = 0; i < al.size(); i++) {
//            al.get(i).;
//        }
    }

    public void criarPredio() {
        Predio.getInstance();
    }

    public static int getNmrElevadores() {
        return nmrElevadores;
    }

    public static int getCapacidadeElevador() {
        return capacidadeElevador;
    }

    public static int getNmrPisos() {
        return nmrPisos;
    }
}
