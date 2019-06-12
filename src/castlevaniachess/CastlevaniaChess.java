/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castlevaniachess;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
        /* Creamos el objeto tablero para poder usar la clase tablero*/
        Tablero tablero = new Tablero();
        /* Creamos el objeto tableroView para poder usar la clase TableroView*/
        TableroView tableroView = new TableroView();
        
        /* Usamos un VBox y un HBox para alinear la pantalla y que la ventana
        sea responsivo*/
        HBox hBox = new HBox(tableroView.getChessTablero());
        hBox.setAlignment(Pos.CENTER);
        VBox root = new VBox();
        /* Añadimos el gridpane de la clase tableroView al panel*/
        root.getChildren().add(hBox);
        /* Centramos el gridpane para que el tablero se mantenga en el centro*/
        root.setAlignment(Pos.CENTER);
        /* Pedimos a tableroView que muestre el tablero en pantalla*/
        tableroView.mostrarTablero();
        tableroView.mostrarFichas(0, 0);
        tableroView.mostrarFichas(1, 0);
        tableroView.mostrarFichas(2, 0);
        tableroView.mostrarFichas(3, 0);
        tableroView.mostrarFichas(4, 0);
        tableroView.mostrarFichas(5, 0);
        tableroView.mostrarFichas(6, 0);
        tableroView.mostrarFichas(0, 6);
        tableroView.mostrarFichas(1, 6);
        tableroView.mostrarFichas(2, 6);
        tableroView.mostrarFichas(3, 6);
        tableroView.mostrarFichas(4, 6);
        tableroView.mostrarFichas(5, 6);
        tableroView.mostrarFichas(6, 6);
        tableroView.mostrarFichas(3, 1);
        tableroView.mostrarFichas(3, 5);

        /* Definimos las dimensiones de la escena*/
        Scene scene = new Scene(root, 700, 700);
        
        /* Le damos un título a la ventana*/
        primaryStage.setTitle("Ajedrez Castlevania");
        /* Definimos la escena*/
        primaryStage.setScene(scene);
        /* Hacemos que se muestre*/
        primaryStage.show();
        
        tableroView.chesstablero.setOnMouseClicked(new EventHandler<MouseEvent>() {
            int contadorClick = 0;
            @Override
            public void handle(MouseEvent mouseEvent) { 
               
                /* Creamos el método con el que conseguiremos que se reconozca la casilla en la que estamos haciendo click*/
                System.out.println("Coordenada X: " + Math.floor(mouseEvent.getX() / tableroView.TAMCASILLA) + " Coordenada Y: " + Math.floor(mouseEvent.getY() / tableroView.TAMCASILLA));
                
                int xSeleccionada = (int) Math.floor(mouseEvent.getX() / tableroView.TAMCASILLA);
                int ySeleccionada = (int) Math.floor(mouseEvent.getY() / tableroView.TAMCASILLA);
                
                double x = (mouseEvent.getX() / tableroView.TAMCASILLA);
                int x1 = (int)x;
                
                double y = (mouseEvent.getY() / tableroView.TAMCASILLA);
                int y1 = (int)y;
               
                System.out.println("Se han hecho " + contadorClick++ + " click/s, este último de");
                
                
                /* Como extra, añadimos el tipo de click que se está haciendo en la casilla*/
                if(mouseEvent.getButton() == MouseButton.PRIMARY) {
                    System.out.println("botón principal");
                    System.out.println("----------------");
                }
                if(mouseEvent.getButton() == MouseButton.SECONDARY) {
                    System.out.println("botón secundario");
                    System.out.println("----------------");
                    contadorClick = 0;
                }
                
                /*Añadimos los comportamientos que queremos que tenga el juego
                en función de la cantidad de click que hagamos y el lugar*/
                if(contadorClick == 1) {
                    tableroView.casillaSeleccionada(xSeleccionada, ySeleccionada);
                }
            }
        });
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
}