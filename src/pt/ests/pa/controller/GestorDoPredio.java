/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.controller;

import java.util.Random;
import pt.ests.pa.model.Predio;
import pt.ests.pa.model.passageiro.ConcreteCreatorPassageiro;
import pt.ests.pa.model.passageiro.Passageiro;

/**
 *
 * @author Rui
 */
public class GestorDoPredio {
    private int nmrPisos = 8;
    private int nmrElevadores = 2;
    private int capacidadeElevador = 10;
    private ConcreteCreatorPassageiro ccp =new ConcreteCreatorPassageiro();
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

    
    public void criarPassageiros() {
        Random rd = new Random();
        if (rd.nextBoolean()) {
            int tipoPassageiro=rd.nextInt()%3;
            Passageiro p= ccp.factoryMethod(tipoPassageiro, nmrPisos);
            Predio.getInstance().gerarPassageiro(p.getOrigem(), p);
        }
    }
    //public static void criarPredio()
}
