/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa.view;

import java.util.Observable;
import java.util.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import pt.ests.pa.model.Elevador.Elevador;
import pt.ests.pa.model.Predio;

/**
 *
 * @author Rui
 */
public class VisualizadorDoPredio implements Observer {

    @FXML
    public VBox pisos;
    public HBox elevadores;
    public VBox pisosAtendidos;
    public HBox informacaoElevadores;

    public VisualizadorDoPredio() {
    pisos=new VBox();
    elevadores=new HBox();
    pisosAtendidos=new VBox();
    informacaoElevadores= new HBox();
    }

    
    @Override
    public void update(Observable o, Object o1) {

        if (o instanceof Predio) {
            Predio p = (Predio) o;
//            clear();
            writePisos(p);
            writeElevadores(p);
            System.out.println(p.toString());
        }
    }

    public void writePisos(Predio p) {
        for (int i = p.getMaxPisos() - 1; i >= 0; i--) {
            pisos.getChildren().add(new Label(p.getPisos().get(i).toString()));
            pisosAtendidos.getChildren().add(new Label(p.getPisos().get(i).passageirosAtendidos()));
        }
    }

    public void writeElevadores(Predio p) {
        for (int i = p.getNmrElevadores() - 1; i >= 0; i--) {
            Elevador e = p.getElevadores().get(i);
            elevadores.getChildren().add(drawElevador(p, e));
            String str = "";
            str += ("Numero do elevador: " + (i + 1) + "\n");
            str += ("Numero de passageiros no elevador: " + e.getNmrPassageiros() + "\n");
            str += ("Estado do Elevador: " + e.getEstado().palavras() + "\n");
            str += ("Distancia Percorrida: " + e.getnPisosPercorridos() + "\n");
            informacaoElevadores.getChildren().add(new Label(str));
        }
    }

    public VBox drawElevador(Predio p, Elevador e) {
        VBox v = new VBox();
        for (int i = p.getMaxPisos() - 1; i >= 0; i--) {
            v.getChildren().add(new Label((e.getnumPisoActual() == i) ? (e.toString()) : ""));
        }
        return v;
    }

    public void clear() {
        elevadores.getChildren().clear();
        informacaoElevadores.getChildren().clear();
        pisos.getChildren().clear();
        pisosAtendidos.getChildren().clear();
    }
}
