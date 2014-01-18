/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import pt.ests.pa.controller.GestorDoPredio;
import pt.ests.pa.model.Predio;
import pt.ests.pa.view.VisualizadorDoPredio;

/**
 *
 * @author Rui
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nmrPisos = 12, nmrElevadores = 3, capacidadeElevador = 5, tempoIteracao = 500;
//        do {
//            System.out.println("Quantos Pisos tem o prédio?");
//            nmrPisos = sc.nextInt();
//        } while (8 > nmrPisos || nmrPisos > 16);
//        sc.nextLine();
//        do {
//            System.out.println("Quantos Elevadores tem o prédio?");
//            nmrElevadores = sc.nextInt();
//        } while (1 > nmrElevadores || nmrElevadores > 5);
//        do {
//            System.out.println("Qual a capacidade dos Elevadores do prédio?");
//            sc.nextLine();
//            capacidadeElevador = sc.nextInt();
//        } while (capacidadeElevador < 1);
        GestorDoPredio.getInstance().create(nmrPisos, nmrElevadores, capacidadeElevador);

        VisualizadorDoPredio vdp = new VisualizadorDoPredio();

        Predio predio = GestorDoPredio.getInstance().getPredio();

        predio.addObserver(vdp);

        int iteracoes = 60;
        for (int i = 0; i < iteracoes; i++) {
            predio.simulaIteracao();
            try {
                Thread.sleep(tempoIteracao);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
//        Piso piso = new Piso(5);
//        System.out.println(piso);
//        Passageiro[] passageiros =new Passageiro[3];
//        passageiros[0] =new Adulto(5);
//        passageiros[1] =new Crianca(5);
//        passageiros[2] =new Deficiente(5);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(passageiros[i]);    
//        }
        launch(args);
    }
}
