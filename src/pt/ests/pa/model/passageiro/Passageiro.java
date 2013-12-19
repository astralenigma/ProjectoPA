/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model.passageiro;

/**
 *
 * @author Rui
 */
public class Passageiro implements Comparable<Passageiro> {

    private int destino, origem;
    private StatePassageiro estado;
    private int tempoDeEspera;

    public Passageiro() {
        estado = new StatePassageiroEmEspera(this);
        tempoDeEspera = 0;
    }

    public void setEstado(StatePassageiro estado) {
        this.estado = estado;
    }

    private static int compare(Passageiro passageiro) {
        if (passageiro instanceof Deficiente) {
            return 1;
        }
        if (passageiro instanceof Crianca) {
            return 1;
        }
        return 1;
    }

    public void incrementarTempoDeEspera() {
        tempoDeEspera++;
    }

    public int getOrigem() {
        return origem;
    }

    public int getDestino() {
        return destino;
    }
    

    @Override
    public int compareTo(Passageiro t) {

//        Precisamos de 2 compareTos dependendo do estado do Passageiro talvez tenhamos que verificar o estado do elevador
//        if (estado instanceof StatePassageiroEmTransporte) {
//            return destino-origem;
//        }
        return compare(this) - compare(t);
    }
}
