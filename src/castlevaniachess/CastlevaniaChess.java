/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castlevaniachess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author fcoam and AntonioJuan
 */
public class CastlevaniaChess extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Creamos el objeto tablero
        Tablero tablero = new Tablero();
        // Creamos el objeto tableroView
        TableroView tableroView = new TableroView();
        
        // Creamos el panel sobre el que añadiremos el tablero
        StackPane root = new StackPane();
        // Añadimos el tableroView al panel
        root.getChildren().add(tableroView.getChessTablero());
        // Pedimos a tableroView que muestre el tablero en pantalla
        tableroView.mostrarTablero();
        
        // Definimos las dimensiones de la escena
        Scene scene = new Scene(root, 700, 700);
        
        // Le damos un título a la ventana
        primaryStage.setTitle("Castlevania Chess");
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
