/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import pt.ests.pa.model.Predio;

/**
 *
 * @author Rui
 */
public class GestorDoPredio {

    //singleton
    private static GestorDoPredio instance;
    private Predio predio;
    
    @FXML
    private TextField numeroDeElevadores;
    @FXML
    private TextField numeroDePisos;
    @FXML
    private TextField capacidadeDosElevadores;

    public static GestorDoPredio getInstance() {
        if (instance == null) {
            instance = new GestorDoPredio();
        }
        return instance;
    }

    /**
     * Cria o predio.
     *
     * @param nmrPisos
     * @param nmrElevadores
     * @param capacidadeElevador
     */
    public void create(int nmrPisos, int nmrElevadores, int capacidadeElevador) {
        predio = new Predio(nmrPisos, nmrElevadores, capacidadeElevador);
    }

    /**
     * Cria o prédio em JavaFX.
     */
    @FXML
    public void criarPredio() {
        int nmrPisos = Integer.parseInt(numeroDePisos.getText()), nmrElevadores = Integer.parseInt(numeroDeElevadores.getText()), capacidadeElevador = Integer.parseInt(capacidadeDosElevadores.getText());
        predio = new Predio(nmrPisos, nmrElevadores, capacidadeElevador);
    }

    public Predio getPredio() {
        return predio;
    }
}