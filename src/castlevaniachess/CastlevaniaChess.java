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
        Tablero tablero = new Tablero();
        TableroView tableroView = new TableroView();
        
        
        StackPane root = new StackPane();
        root.getChildren().add(tableroView.getChessTablero());
        tableroView.mostrarTablero();
        
        Scene scene = new Scene(root, 700, 700);
        
        primaryStage.setTitle("Castlevania Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
