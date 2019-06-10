/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package castlevaniachess;

/**
 *
 * @author fcoam
 */
public class PruebaMain {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.mostrarTablero(tablero.tableMatrix);
        tablero.piezaSeleccionable = 'C' ;
        tablero.seleccionarPieza(2, 0);
        System.out.println(tablero.piezaActiva);
        
        
        tablero.mostrarResaltados(2, 0);
        tablero.mostrarTablero(tablero.tableMatrixEfects);
        tablero.moverPieza(2, 0, 2, 1);
        System.out.println("");
        tablero.mostrarTablero(tablero.tableMatrix);
    }
}
