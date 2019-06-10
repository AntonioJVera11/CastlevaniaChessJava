/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castlevaniachess;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.R;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author AntonioJuan
 */

/* Creamos la clase tableroView que nos servirá para 
crear el tablero */
public class TableroView {
    
    /* Cargamos todas las imágenes de nuestros caracteres*/
    Image mago = new Image(getClass().getResourceAsStream("/imagenes/Mago.png"));
    Image rey = new Image(getClass().getResourceAsStream("/imagenes/Rey.png"));
    Image caballero = new Image(getClass().getResourceAsStream("/imagenes/Caballero.png"));
    Image peon = new Image(getClass().getResourceAsStream("/imagenes/Peon.png"));
    Image torre = new Image(getClass().getResourceAsStream("/imagenes/Torre.png"));
    
    /* Hacemos que cree una nueva partida invocando al método nuevaPartida*/
    public TableroView() {
        this.nuevaPartida();
    }

    /* Añadiremos el GridPane sobre el que se sostendrá el juego*/
    GridPane chesstablero = new GridPane();
    public final double TAMCASILLA = 100;

    /* Creamos el objeto de la clase Tablero para poder trabajar con ella*/
    Tablero tablero = new Tablero ();

    /* Creamos el método getChessTablero que nos devolverá el 
     gridPane chesstablero*/
    public GridPane getChessTablero() {
        return chesstablero;
    }
    
    /* Creamos el método para empezar una nueva partida*/
    public void nuevaPartida() {
        this.tablero = new Tablero();
        this.mostrarTablero();
    }

    /* Creamos el método dibujarTablero que definirá las 
     características de las casillas (dimensiones, color)*/
    public void dibujarTablero (int x, int y) {
        /* Le damos a la casilla posición y dimensiones*/
        Rectangle casilla = new Rectangle(0, 0, TAMCASILLA, TAMCASILLA);
        /* Le damos color a la casilla*/
        casilla.setFill(Color.BURLYWOOD);
        /* Le damos color al borde*/
        casilla.setStroke(Color.PERU);
        /* Añadimos el tablero al panel*/
        chesstablero.add(casilla, x, y);
    }

    /* Creamos el método que mostrará el tablero con un bucle
     for en X e Y*/
    public void mostrarTablero (){
        /* Este bucle creará las 7 casillas en el eje Y*/
        for(int y=0; y<7; y++) { 
            /* Este bucle creará las 7 casillas en el eje X*/
            for(int x=0; x<7; x++) {
            /* Hacemos que se dibuje el tablero con las casillas
            que ha creado el bucle*/
            dibujarTablero(x, y);
            }
        }
    }

    public void clickCasilla (int x, int y) {
        /* Creamos un chivato que nos diga la celda que se ha pulsado*/
        System.out.println("Se ha pulsado la casilla: " + x + "," + y);
        /* Nos valemos de la sentencia IF para saber si la casilla está libre*/
        if(tablero.estaLibreCelda(x,y)) {
          /* Creamos un aviso para saber si la celda está libre*/
          System.out.println("La celda está libre, ficha colocándose");
        } else {
          /* Creamos un aviso para cuando no se puede colocar la pieza*/
          System.out.println("La celda es inutilizable");
        }
    }
    
    /* Creamos el método que coloque las fichas en el tablero*/
    public void mostrarFichas (int x, int y) {
        System.out.println("Mostrando rey en mostrarfichas");
        System.out.println(tablero.tableMatrix[x][y]);
        switch(tablero.tableMatrix[x][y]) {   
            case 'R':
                ImageView rey1 = new ImageView(rey);
                rey1.setFitHeight(TAMCASILLA);
                rey1.setFitWidth(TAMCASILLA);
                chesstablero.add(rey1, x, y);
                System.out.println("Mostrando rey");
                break;
        }
    }
} 