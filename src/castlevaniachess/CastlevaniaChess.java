/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castlevaniachess;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

/**
 *
 * @author fcoam and AntonioJuan
 */
public class CastlevaniaChess extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Creamos el objeto tablero para poder usar la clase tablero
        Tablero tablero = new Tablero();
        // Creamos el objeto tableroView para poder usar la clase TableroView
        TableroView tableroView = new TableroView();
        
        // Usamos un VBox y un HBoxpara alinear la pantalla y que la ventana sea responsivo
        HBox hBox = new HBox(tableroView.getChessTablero());
        hBox.setAlignment(Pos.CENTER);
        VBox root = new VBox();
        // Añadimos el gridpane de la clase tableroView al panel
        root.getChildren().add(hBox);
        // Centramos el gridpane para que el tablero se mantenga en el centro
        root.setAlignment(Pos.CENTER);
        // Pedimos a tableroView que muestre el tablero en pantalla
        tableroView.mostrarTablero();
        
        // Definimos las dimensiones de la escena
        Scene scene = new Scene(root, 700, 700);
        
        // Le damos un título a la ventana
        primaryStage.setTitle("Ajedrez Castlevania");
        primaryStage.setScene(scene);
        // Hacemos que se muestre
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}