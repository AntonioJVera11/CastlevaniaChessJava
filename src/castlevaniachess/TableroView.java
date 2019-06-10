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
        System.out.println(tablero.tableMatrix[x][y]);
        switch(tablero.tableMatrix[x][y]) {   
            case 'R':
                ImageView rey1 = new ImageView(rey);
                rey1.setFitHeight(TAMCASILLA);
                rey1.setFitWidth(TAMCASILLA);
                chesstablero.add(rey1, x, y);
                break;
            case 'B':
                ImageView torre11 = new ImageView(torre);
                torre11.setFitHeight(TAMCASILLA);
                torre11.setFitWidth(TAMCASILLA);
                chesstablero.add(torre11, x, y);
                break;
            case 'M':
                ImageView mago11 = new ImageView(mago);
                mago11.setFitHeight(TAMCASILLA);
                mago11.setFitWidth(TAMCASILLA);
                chesstablero.add(mago11, x, y);
                break;
            case 'C':
                ImageView caballero11 = new ImageView(caballero);
                caballero11.setFitHeight(TAMCASILLA);
                caballero11.setFitWidth(TAMCASILLA);
                chesstablero.add(caballero11, x, y);
                break;
            case 'Z':
            ImageView peon1 = new ImageView(peon);
            peon1.setFitHeight(TAMCASILLA);
            peon1.setFitWidth(TAMCASILLA);
            chesstablero.add(peon1, x, y);
                break;
            case 'K':
            ImageView caballero12 = new ImageView(caballero);
            caballero12.setFitHeight(TAMCASILLA);
            caballero12.setFitWidth(TAMCASILLA);
            chesstablero.add(caballero12, x, y);
                break;
            case 'W':
            ImageView mago12 = new ImageView(mago);
            mago12.setFitHeight(TAMCASILLA);
            mago12.setFitWidth(TAMCASILLA);
            chesstablero.add(mago12, x, y);
                break;  
            case 'V':
                ImageView torre12 = new ImageView(torre);
                torre12.setFitHeight(TAMCASILLA);
                torre12.setFitWidth(TAMCASILLA);
                chesstablero.add(torre12, x, y);
                break;
            case 'b':
                ImageView torre21 = new ImageView(torre);
                torre21.setFitHeight(TAMCASILLA);
                torre21.setFitWidth(TAMCASILLA);
                chesstablero.add(torre21, x, y);
                break;
            case 'm':
                ImageView mago21 = new ImageView(mago);
                mago21.setFitHeight(TAMCASILLA);
                mago21.setFitWidth(TAMCASILLA);
                chesstablero.add(mago21, x, y);
                break;
            case 'c':
                ImageView caballero21 = new ImageView(caballero);
                caballero21.setFitHeight(TAMCASILLA);
                caballero21.setFitWidth(TAMCASILLA);
                chesstablero.add(caballero21, x, y);
                break;
            case 'r':
                ImageView rey2 = new ImageView(rey);
                rey2.setFitHeight(TAMCASILLA);
                rey2.setFitWidth(TAMCASILLA);
                chesstablero.add(rey2, x, y);
                break;
            case 'k':
            ImageView caballero22 = new ImageView(caballero);
            caballero22.setFitHeight(TAMCASILLA);
            caballero22.setFitWidth(TAMCASILLA);
            chesstablero.add(caballero22, x, y);
                break;
            case 'w':
            ImageView mago22 = new ImageView(mago);
            mago22.setFitHeight(TAMCASILLA);
            mago22.setFitWidth(TAMCASILLA);
            chesstablero.add(mago22, x, y);
                break;  
            case 'v':
                ImageView torre22 = new ImageView(torre);
                torre22.setFitHeight(TAMCASILLA);
                torre22.setFitWidth(TAMCASILLA);
                chesstablero.add(torre22, x, y);
                break; 
            case 'z':
            ImageView peon2 = new ImageView(peon);
            peon2.setFitHeight(TAMCASILLA);
            peon2.setFitWidth(TAMCASILLA);
            chesstablero.add(peon2, x, y);
                break;
        }
    }
} 