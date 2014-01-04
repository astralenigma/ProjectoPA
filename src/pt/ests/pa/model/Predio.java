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
            sc.nextLine();
            int nmrPisos = sc.nextInt();
            if (8 > nmrPisos || nmrPisos > 14) {
                throw new QuantidadePisosIlegalException();
            }
            System.out.println("Quantos Elevadores tem o prédio?");
            sc.nextLine();
            int nmrElevadores = sc.nextInt();
            if (2 > nmrElevadores || nmrElevadores > 4) {
                throw new QuantidadeElevadoresIlegalException();
            }
            System.out.println("Quantos Elevadores tem o prédio?");
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
        String str = "";
        for (int i = 0; i < 10; i++) {
            str += pisos.get(i);
        }
        return str; //To change body of generated methods, choose Tools | Templates.
    }
}
