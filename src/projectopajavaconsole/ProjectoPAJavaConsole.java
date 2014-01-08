/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopajavaconsole;

import java.util.Scanner;
import pt.ests.pa.controller.GestorDoPredio;
import pt.ests.pa.model.Predio;
import pt.ests.pa.view.VisualizadorDoPredio;

/**
 *
 * @author Rui
 */
public class ProjectoPAJavaConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int nmrPisos, nmrElevadores, capacidadeElevador, tempoIteracao = 500;
        do {
            System.out.println("Quantos Pisos tem o prédio?");
            nmrPisos = sc.nextInt();
        } while (8 > nmrPisos || nmrPisos > 16);
        sc.nextLine();
        do {
            System.out.println("Quantos Elevadores tem o prédio?");
            nmrElevadores = sc.nextInt();
        } while (1 > nmrElevadores || nmrElevadores > 5);
        do {
            System.out.println("Qual a capacidade dos Elevadores do prédio?");
            sc.nextLine();
            capacidadeElevador = sc.nextInt();
        } while (capacidadeElevador < 1);
        GestorDoPredio.getInstance().create(nmrPisos, nmrElevadores, capacidadeElevador);
               
        VisualizadorDoPredio vdp = new VisualizadorDoPredio();
                
        Predio predio = GestorDoPredio.getInstance().getPredio();
        
        predio.addObserver(vdp);
        
        int iteracoes=60;
        for (int i = 0; i < iteracoes; i++) {
            
            predio.simulaIteracao();
            try {
                Thread.sleep(tempoIteracao);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
//        Piso piso = new Piso(5);
//        System.out.println(piso);
//        Passageiro[] passageiros =new Passageiro[3];
//        passageiros[0] =new Adulto(5);
//        passageiros[1] =new Crianca(5);
//        passageiros[2] =new Deficiente(5);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(passageiros[i]);    
//        }
    }
}
