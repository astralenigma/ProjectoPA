/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

/**
 *
 * @author Rui
 */
public class Predio {
    private static Predio instance;

    private Predio() {
        instance=new Predio();
    }

    public static Predio getInstance() {
        if(instance==null){
            instance=new Predio();
        }
        return instance;
    }
    
    
}
