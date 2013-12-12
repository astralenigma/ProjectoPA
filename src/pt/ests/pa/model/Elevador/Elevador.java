
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.Elevador;

import pt.ests.pa.model.ElevadorNoPisoZeroException;
import pt.ests.pa.model.passageiro.Passageiro;

/**
 *
 * @author Rui
 */
public class Elevador {
//    private static final int pisoMax;
    private int piso;
    private StateElevador estado;
    private boolean estadoDasPortas;
    private Passageiro passageiro;
    private int nPisosPercorridos=0;

//    public Elevador(int piso, Object estado, Passageiro passageiro) {
//        this.piso = piso;
//        this.estado = estado;
//        this.passageiro = passageiro;
//    }
    
    public void subir(){
        piso++;
        nPisosPercorridos++;
    }
    public void descer() throws ElevadorNoPisoZeroException{
        if(piso==0){
            throw new ElevadorNoPisoZeroException();
        }
        piso--;
        nPisosPercorridos++;
    }
    
}
