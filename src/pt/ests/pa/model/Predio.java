/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.arraylist.ArrayListStatic;

/**
 *
 * @author Rui
 */
public class Predio {
    private static Predio instance;
    private ArrayList<Piso> pisos;
    private final int MAXPISOS=14;
    private Predio() {
        instance=new Predio();
        pisos=new ArrayListStatic<Piso>(MAXPISOS);
    }

    public static Predio getInstance() {
        if(instance==null){
            instance=new Predio();
        }
        return instance;
    }
    
    
}
