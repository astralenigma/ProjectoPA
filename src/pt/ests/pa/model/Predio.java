/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import pt.ests.pa.model.exceptions.CapacidadeElevadorIlegalException;
import java.util.Scanner;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.exceptions.QuantidadeElevadoresIlegalException;
import pt.ests.pa.model.exceptions.QuantidadePisosIlegalException;
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
            Scanner sc = new Scanner(System.in);
            System.out.println("Quantos Pisos tem o prédio?");
            int nmrPisos = sc.nextInt();
            if (7 > nmrPisos || nmrPisos > 15) {
                throw new QuantidadePisosIlegalException();
            }
            System.out.println("Quantos Elevadores tem o prédio?");
            sc.nextLine();
            int nmrElevadores = sc.nextInt();
            if (1 > nmrElevadores || nmrElevadores > 5) {
                throw new QuantidadeElevadoresIlegalException();
            }
            System.out.println("Qual a capacidade dos Elevadores do prédio?");
            sc.nextLine();
            int capacidadeElevador = sc.nextInt();
            if (capacidadeElevador < 1) {
                throw new CapacidadeElevadorIlegalException();
            }
            instance = new Predio(nmrPisos, nmrElevadores, capacidadeElevador);
        }
        return instance;
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
        return str; //To change body of generated methods, choose Tools | Templates.
    }
}
