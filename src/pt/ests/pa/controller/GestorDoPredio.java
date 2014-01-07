/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.controller;

import java.util.Observable;
import java.util.Random;
import java.util.Scanner;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.Predio;
import pt.ests.pa.model.exceptions.CapacidadeElevadorIlegalException;
import pt.ests.pa.model.exceptions.QuantidadeElevadoresIlegalException;
import pt.ests.pa.model.exceptions.QuantidadePisosIlegalException;
import pt.ests.pa.model.passageiro.ConcreteCreatorPassageiro;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;

/**
 *
 * @author Rui
 */
public class GestorDoPredio extends Observable {

    private static int nmrPisos = 8;
    private static int nmrElevadores = 2;
    private static int capacidadeElevador = 10;
    private ConcreteCreatorPassageiro ccp = new ConcreteCreatorPassageiro();
//    public static void criarPredio() throws QuantidadePisosIlegalException, QuantidadeElevadoresIlegalException, CapacidadeElevadorIlegalException {
//        //doSomething
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Quantos Pisos tem o prédio?");
//        int nmrPisos = sc.nextInt();
//        if (7 > nmrPisos || nmrPisos > 15) {
//            throw new QuantidadePisosIlegalException();
//        }
//        System.out.println("Quantos Elevadores tem o prédio?");
//        sc.nextLine();
//        int nmrElevadores = sc.nextInt();
//        if (1 > nmrElevadores || nmrElevadores > 5) {
//            throw new QuantidadeElevadoresIlegalException();
//        }
//        System.out.println("Qual a capacidade dos Elevadores do prédio?");
//        sc.nextLine();
//        int capacidadeElevador = sc.nextInt();
//        if (capacidadeElevador < 1) {
//            throw new CapacidadeElevadorIlegalException();
//        }
//    }

    /**
     * Método que cria os passageiros.
     */
    public void criarPassageiros() {
        Random rd = new Random();
        if (rd.nextBoolean()) {
            notifyObservers();
            int tipoPassageiro = rd.nextInt() % 3;
            Passageiro p = ccp.factoryMethod(tipoPassageiro, nmrPisos);
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantos Pisos tem o prédio?");
        nmrPisos = sc.nextInt();
        if (7 > nmrPisos || nmrPisos > 15) {
            throw new QuantidadePisosIlegalException();
        }
        System.out.println("Quantos Elevadores tem o prédio?");
        sc.nextLine();
        nmrElevadores = sc.nextInt();
        if (1 > nmrElevadores || nmrElevadores > 5) {
            throw new QuantidadeElevadoresIlegalException();
        }
        System.out.println("Qual a capacidade dos Elevadores do prédio?");
        sc.nextLine();
        capacidadeElevador = sc.nextInt();
        if (capacidadeElevador < 1) {
            throw new CapacidadeElevadorIlegalException();
        }
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
