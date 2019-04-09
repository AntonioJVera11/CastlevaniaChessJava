/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castlevaniachess;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author AntonioJuan
 */

// Creamos la clase tableroView que nos servirá para 
// crear el tablero 
public class TableroView {
        // Añadiremos el GridPane sobre el que se sostendrá el juego
        GridPane chesstablero = new GridPane();
        
        // Creamos el objeto de la clase Tablero para poder trabajar con ella
        Tablero tablero = new Tablero ();
        
        // Creamos el método getChessTablero que nos devolverá el 
        // gridPane chesstablero
        public GridPane getChessTablero() {
            return chesstablero;
        }
        
        // Creamos el método dibujarTablero que definirá las 
        // características de las casillas (dimensiones, color)
        public void dibujarTablero (int x, int y) {
            // Le damos a la casilla posición y dimensiones
            Rectangle casilla = new Rectangle(0, 0, 100, 100);
            // Le damos color a la casilla
            casilla.setFill(Color.BURLYWOOD);
            // Le damos color al borde
            casilla.setStroke(Color.PERU);
            // Añadimos el tablero al panel 
            chesstablero.add(casilla, x, y);
        }
        
        // Creamos el método que mostrará el tablero con un bucle
        // for en X e Y
        public void mostrarTablero (){
            // Este bucle creará las 7 casillas en el eje Y
            for(int y=0; y<7; y++) { 
                // Este bucle creará las 7 casillas en el eje X
                for(int x=0; x<7; x++) {
                // Hacemos que se dibuje el tablero con las casillas
                // que ha creado el bucle
                dibujarTablero(x, y);
                }
            }
        }
        
        public void clickCasilla (int x, int y) {
            // Creamos un chivato que nos diga la celda que se ha pulsado
            System.out.println("Se ha pulsado la casilla: " + x + "," + y);
            // Nos valemos de la sentencia IF para saber si la casilla está libre
            if(tablero.estaLibreCelda(x,y)) {
                // Creamos un aviso para saber si la celda está libre
                System.out.println("La celda está libre, ficha colocándose");
                
            }
        }
}
