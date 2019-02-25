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
public class TableroView {
        GridPane chesstablero = new GridPane();
        
        public GridPane getChessTablero() {
            return chesstablero;
        }
        
        public void dibujarTablero (int x, int y) {
            Rectangle casilla = new Rectangle(0, 0, 100, 100);
            casilla.setFill(Color.BURLYWOOD);
            casilla.setStroke(Color.PERU);
            chesstablero.add(casilla, x, y);
        }
            
        public void mostrarTablero (){
            for(int y=0; y<7; y++) {                   
                for(int x=0; x<7; x++) {
                dibujarTablero(x, y);
                }
            }
        }
}
