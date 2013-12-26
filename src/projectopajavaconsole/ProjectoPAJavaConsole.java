/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectopajavaconsole;

import pt.ests.pa.model.Piso;
import pt.ests.pa.model.passageiro.Adulto;
import pt.ests.pa.model.passageiro.Crianca;
import pt.ests.pa.model.passageiro.Deficiente;
import pt.ests.pa.model.passageiro.Passageiro;

/**
 *
 * @author Rui
 */
public class ProjectoPAJavaConsole {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Piso piso = new Piso(5);
//        System.out.println(piso);
        Passageiro[] passageiros =new Passageiro[3];
        passageiros[0] =new Adulto(5);
        passageiros[1] =new Crianca(5);
        passageiros[2] =new Deficiente(5);
        for (int i = 0; i < 3; i++) {
            System.out.println(passageiros[i]);    
        }
    }
}
