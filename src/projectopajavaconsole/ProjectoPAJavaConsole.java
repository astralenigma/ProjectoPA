/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopajavaconsole;

import pt.ests.pa.controller.GestorDoPredio;
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

        VisualizadorDoPredio vdp = new VisualizadorDoPredio();
        GestorDoPredio gdp = new GestorDoPredio();
        while (true) {
            vdp.imprimirPredio();
            gdp.criarPassageiros();
            try {
                Thread.sleep(1000);
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
