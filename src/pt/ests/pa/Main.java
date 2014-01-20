/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ests.pa;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    public void start(Stage primaryStage) throws IOException {
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

//        int iteracoes = 60;
//        for (int i = 0; i < iteracoes; i++) {
        URL location = getClass().getResource("/pt/ests/pa/view/ViewPredioFX.fxml");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        Parent root = (Parent) fxmlLoader.load(location.openStream());

        Thread t = new Thread(predio);
        t.start();

//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);
//
//        Scene scene = new Scene(root, 300, 250);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Prédio");
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

        launch(args);
    }
}
