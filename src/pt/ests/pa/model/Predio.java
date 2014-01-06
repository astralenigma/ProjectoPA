/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.model.exceptions.CapacidadeElevadorIlegalException;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.exceptions.QuantidadeElevadoresIlegalException;
import pt.ests.pa.model.exceptions.QuantidadePisosIlegalException;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.arraylist.ArrayListStatic;

/**
 * Classe do predio cola todos as classes.
 *
 * @author Rui
 */
public class Predio {

    private static Predio instance;
    private ArrayList<Piso> pisos;
    private ArrayList<Elevador> elevadores;

    private Predio(int nmrPisos, int nmrElevadores, int capacidadeElevador) {
        pisos = new ArrayListStatic<>(nmrPisos);
        for (int i = 0; i < nmrPisos; i++) {
            pisos.add(i, new Piso(i));
        }
        elevadores = new ArrayListStatic<>(nmrElevadores);
        for (int i = 0; i < nmrElevadores; i++) {
            elevadores.add(i, new Elevador(pisos, capacidadeElevador));
        }
    }

    /**
     *
     * @return @throws QuantidadePisosIlegalException
     * @throws QuantidadeElevadoresIlegalException
     */
    public static Predio getInstance() throws QuantidadePisosIlegalException, QuantidadeElevadoresIlegalException, CapacidadeElevadorIlegalException {
        if (instance == null) {
            int nmrPisos = 8;
            int nmrElevadores = 2;
            int capacidadeElevador = 10;
            instance = new Predio(nmrPisos, nmrElevadores, capacidadeElevador);
        }
        return instance;
    }

    /**
     * Devolve o nmr maximo de pisos.
     *
     * @return Inteiro com o tamanho do prédio
     */
    public int getMaxPisos() {
        return pisos.size();
    }

    /**
     * Insere um passageiro no seu piso de origem.
     * @param nmrPiso Numero do piso onde o passageiro tem origem.
     * @param p Passageiro a ser inserido.
     */
    public void gerarPassageiro(int nmrPiso, Passageiro p) {
        pisos.get(nmrPiso).receberPassageiro(p);
    }

    @Override
    public String toString() {
        String str = "---------------------------------------------------------------------\n"
                + "-------------------------------Predio--------------------------------\n"
                + "---------------------------------------------------------------------\n";
        for (int i = pisos.size() - 1; i >= 0; i--) {
            str += String.format("%30s", pisos.get(i));
            for (int j = 0; j < elevadores.size(); j++) {
                str += String.format("%6s", (elevadores.get(j).getPisoActual() == i) ? elevadores.get(j) : "");
            }
            str += "\n";
        }
        for (int i = 0; i < elevadores.size(); i++) {
            System.out.println("Numero do elevador: " + (i + 1));
            System.out.println("Numero de passageiros no elevador: " + elevadores.get(i).getNmrPassageiros());
            System.out.println("Estado do Elevador: " + elevadores.get(i).getEstado().palavras());
            System.out.println("Distancia Percorrida: " + elevadores.get(i).getnPisosPercorridos());
        }
        return str;
    }
}
