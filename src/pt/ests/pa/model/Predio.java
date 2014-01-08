/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.controller.GestorDoPredio;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.passageiro.Passageiro;
import pt.ests.pa.model.tads.arraylist.ArrayList;
import pt.ests.pa.model.tads.arraylist.ArrayListDNode;

/**
 * Classe do predio cola todos as classes.
 *
 * @author Rui
 */
public class Predio {

    private static Predio instance;
    private ArrayList<Piso> pisos;
    private ArrayList<Elevador> elevadores;

    private Predio() {
        pisos = new ArrayListDNode<>();
        for (int i = 0; i < GestorDoPredio.getNmrPisos(); i++) {
            pisos.add(i, new Piso(i));
        }
        elevadores = new ArrayListDNode<>();
        for (int i = 0; i < GestorDoPredio.getNmrElevadores(); i++) {
            elevadores.add(i, new Elevador(pisos, GestorDoPredio.getCapacidadeElevador()));
        }
    }

    public ArrayList<Elevador> getElevadores() {
        return elevadores;
    }

    /**
     *
     * @return @throws QuantidadePisosIlegalException
     * @throws QuantidadeElevadoresIlegalException
     */
    public static Predio getInstance(){
        if (instance == null) {
            instance = new Predio();
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
     *
     * @param nmrPiso Numero do piso onde o passageiro tem origem.
     * @param p Passageiro a ser inserido.
     */
    public void gerarPassageiro(int nmrPiso, Passageiro p) {
        pisos.get(nmrPiso).gerarPassageiros(p);
    }

    @Override
    public String toString() {
        String str = "---------------------------------------------------------------------\n"
                + "-------------------------------Predio--------------------------------\n"
                + "---------------------------------------------------------------------\n";
        for (int i = pisos.size() - 1; i >= 0; i--) {
            str += String.format("%02d", i) + String.format("%30s|", pisos.get(i));
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

    public Elevador elevadorMaisProximo(int pisoActual) {
        Elevador maisProximo = elevadores.get(0);
        for (int i = 1; i < elevadores.size(); i++) {
            maisProximo = (elevadores.get(i).verificarProximo(pisoActual) > maisProximo.verificarProximo(pisoActual)) ? elevadores.get(i) : maisProximo;
        }
        return maisProximo;
    }
}
