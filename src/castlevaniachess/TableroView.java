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
    
    /* Hacemos que cree una nueva partida invocando al método nuevaPartida*/
    public TableroView() {
        this.nuevaPartida();
    }

    /* Añadiremos el GridPane sobre el que se sostendrá el juego*/
    GridPane chesstablero = new GridPane();

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
        Rectangle casilla = new Rectangle(0, 0, 100, 100);
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
        /* Añadimos todas las imágenes que actuarán como personajes 
        de nuestro juego*/ 
        /* Importamos los magos y los convertimos a ImageView para
        poder trabajar con ellos*/
        Image Mago;
        Mago = new Image(getClass().getResourceAsStream("images/Mago.png"));
        ImageView magoView = new ImageView ();
        magoView.setImage(Mago);
        ImageView magoView2 = new ImageView ();
        magoView.setImage(Mago);
        ImageView magoView3 = new ImageView ();
        magoView.setImage(Mago);
        ImageView magoView4 = new ImageView ();
        magoView.setImage(Mago);
        /* De esta manera haremos que las imágenes queden centradas tanto 
        horizontal como verticalmente en su casilla*/
        GridPane.setHalignment(magoView, HPos.CENTER);
        GridPane.setValignment(magoView, VPos.CENTER);
        GridPane.setHalignment(magoView2, HPos.CENTER);
        GridPane.setValignment(magoView2, VPos.CENTER);
        GridPane.setHalignment(magoView3, HPos.CENTER);
        GridPane.setValignment(magoView3, VPos.CENTER);
        GridPane.setHalignment(magoView4, HPos.CENTER);
        GridPane.setValignment(magoView4, VPos.CENTER);
        /*Procedemos a colocar cada ficha en su posición inicial*/
        chesstablero.add(magoView, 0, 0);
        chesstablero.add(magoView2, 6, 0);
        chesstablero.add(magoView3, 0, 6);
        chesstablero.add(magoView4, 6, 6);
        
        
        /* Importamos los reyes y los convertimos a ImageView para
        poder trabajar con ellos*/
        Image Rey; 
        Rey = new Image(getClass().getResourceAsStream("images/Rey.png"));
        ImageView reyView = new ImageView ();
        reyView.setImage(Rey);
        ImageView reyView2 = new ImageView ();
        reyView.setImage(Rey);
        /* De esta manera haremos que las imágenes queden centradas tanto 
        horizontal como verticalmente en su casilla*/
        GridPane.setHalignment(reyView, HPos.CENTER);
        GridPane.setValignment(reyView, VPos.CENTER);
        GridPane.setHalignment(reyView2, HPos.CENTER);
        GridPane.setValignment(reyView2, VPos.CENTER);
        /*Procedemos a colocar cada ficha en su posición inicial*/
        chesstablero.add(reyView, 3, 0);
        chesstablero.add(reyView2, 3, 6);
        
        
        /* Importamos los caballeros y los convertimos a ImageView para
        poder trabajar con ellos*/
        Image Caballero;
        Caballero = new Image(getClass().getResourceAsStream("images/Caballero.png"));
        ImageView caballeroView = new ImageView ();
        caballeroView.setImage(Caballero);
        ImageView caballeroView2 = new ImageView ();
        caballeroView.setImage(Caballero);
        ImageView caballeroView3 = new ImageView ();
        caballeroView.setImage(Caballero);
        ImageView caballeroView4 = new ImageView ();
        caballeroView.setImage(Caballero);
        /* De esta manera haremos que las imágenes queden centradas tanto 
        horizontal como verticalmente en su casilla*/
        GridPane.setHalignment(caballeroView, HPos.CENTER);
        GridPane.setValignment(caballeroView, VPos.CENTER);
        GridPane.setHalignment(caballeroView2, HPos.CENTER);
        GridPane.setValignment(caballeroView2, VPos.CENTER);
        GridPane.setHalignment(caballeroView3, HPos.CENTER);
        GridPane.setValignment(caballeroView3, VPos.CENTER);
        GridPane.setHalignment(caballeroView4, HPos.CENTER);
        GridPane.setValignment(caballeroView4, VPos.CENTER);
        /*Procedemos a colocar cada ficha en su posición inicial*/
        chesstablero.add(caballeroView, 1, 0);
        chesstablero.add(caballeroView2, 5, 0);
        chesstablero.add(caballeroView3, 1, 6);
        chesstablero.add(caballeroView4, 5, 6);
        
        
        /* Importamos los peones y los convertimos a ImageView para
        poder trabajar con ellos*/
        Image Peon;
        Peon = new Image(getClass().getResourceAsStream("images/Peon.png"));
        ImageView peonView = new ImageView ();
        peonView.setImage(Peon);
        ImageView peonView2 = new ImageView ();
        peonView.setImage(Peon);
        ImageView peonView3 = new ImageView ();
        peonView.setImage(Peon);
        ImageView peonView4 = new ImageView ();
        peonView.setImage(Peon);
        /* De esta manera haremos que las imágenes queden centradas tanto 
        horizontal como verticalmente en su casilla*/
        GridPane.setHalignment(peonView, HPos.CENTER);
        GridPane.setValignment(peonView, VPos.CENTER);
        GridPane.setHalignment(peonView2, HPos.CENTER);
        GridPane.setValignment(peonView2, VPos.CENTER);
        GridPane.setHalignment(peonView3, HPos.CENTER);
        GridPane.setValignment(peonView3, VPos.CENTER);
        GridPane.setHalignment(peonView4, HPos.CENTER);
        GridPane.setValignment(peonView4, VPos.CENTER);
        /*Procedemos a colocar cada ficha en su posición inicial*/
        chesstablero.add(peonView, 2, 2);
        chesstablero.add(peonView2, 4, 2);
        chesstablero.add(peonView3, 2, 4);
        chesstablero.add(peonView4, 4, 4);
        
        
        /* Importamos las torres y las convertimos a ImageView para
        poder trabajar con ellas*/
        Image Torre;
        Torre = new Image(getClass().getResourceAsStream("images/Torre.png"));
        ImageView torreView = new ImageView ();
        torreView.setImage(Torre);
        ImageView torreView2 = new ImageView ();
        torreView.setImage(Torre);
        ImageView torreView3 = new ImageView ();
        torreView.setImage(Torre);
        ImageView torreView4 = new ImageView ();
        torreView.setImage(Torre);
        /* De esta manera haremos que las imágenes queden centradas tanto 
        horizontal como verticalmente en su casilla*/
        GridPane.setHalignment(torreView, HPos.CENTER);
        GridPane.setValignment(torreView, VPos.CENTER);
        GridPane.setHalignment(torreView2, HPos.CENTER);
        GridPane.setValignment(torreView2, VPos.CENTER);
        GridPane.setHalignment(torreView3, HPos.CENTER);
        GridPane.setValignment(torreView3, VPos.CENTER);
        GridPane.setHalignment(torreView4, HPos.CENTER);
        GridPane.setValignment(torreView4, VPos.CENTER); 
        /*Procedemos a colocar cada ficha en su posición inicial*/
        chesstablero.add(torreView, 2, 0);
        chesstablero.add(torreView2, 4, 0);
        chesstablero.add(torreView3, 2, 6);
        chesstablero.add(torreView4, 4, 6);
    }
} 