/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.model;

import java.util.Scanner;
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
    
    private Predio(int nmrPisos, int nmrElevadores) {
        pisos = new ArrayListStatic<>(nmrPisos);
        for (int i = 0; i < nmrPisos; i++) {
            pisos.add(i, new Piso(i));
        }
    }
    
    /**
     *
     * @return
     * @throws QuantidadePisosIlegalException
     * @throws QuantidadeElevadoresIlegalException
     */
    public static Predio getInstance() throws QuantidadePisosIlegalException, QuantidadeElevadoresIlegalException {
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
            instance = new Predio(nmrPisos, nmrElevadores);
        }
        return instance;
    }
}
