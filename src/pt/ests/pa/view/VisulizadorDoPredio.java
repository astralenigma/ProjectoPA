/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.view;

import java.util.logging.Level;
import java.util.logging.Logger;
import pt.ests.pa.model.Predio;
import pt.ests.pa.model.exceptions.CapacidadeElevadorIlegalException;
import pt.ests.pa.model.exceptions.QuantidadeElevadoresIlegalException;
import pt.ests.pa.model.exceptions.QuantidadePisosIlegalException;

/**
 *
 * @author Rui
 */
public class VisulizadorDoPredio {

    
    

public static void imprimirPredio(){
    try {
        System.out.println(Predio.getInstance());
    } catch (QuantidadePisosIlegalException ex) {
        System.out.println("Quantidade de pisos Ilegal.");
    } catch (QuantidadeElevadoresIlegalException ex) {
        System.out.println("Quantidade de elevadores Ilegal.");
    } catch (CapacidadeElevadorIlegalException ex) {
        System.out.println("Capacidade do elevador Ilegal");
    }
}
}
