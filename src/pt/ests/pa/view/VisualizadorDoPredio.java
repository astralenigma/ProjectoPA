/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.view;

import java.util.Observable;
import java.util.Observer;
import pt.ests.pa.model.Predio;

/**
 *
 * @author Rui
 */
public class VisualizadorDoPredio implements Observer {

    @Override
    public void update(Observable o, Object o1) {
        
        if (o instanceof Predio) {
            Predio p = (Predio) o;
            
            System.out.println(p.toString());
        }
    }
}
