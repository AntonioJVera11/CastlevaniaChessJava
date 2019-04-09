package castlevaniachess;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fcoam
 */
public class Tablero {
    
    public char[][] tableMatrix = new char[7][7];
    public static final char JUGADOR_1 = '1';
    public static final char JUGADOR_2 = '2';   
    public static final char REY_1 = 'R';
    public static final char REY_2 = 'r';
    public static final char MAGO_1 = 'M';
    public static final char MAGO_2 = 'm';
    public static final char CABALLERO_1 = 'C';
    public static final char CABALLERO_2 = 'c';
    public static final char ZOMBI_1 = 'Z';
    public static final char ZOMBI_2 = 'z';
    Random turnoPieza = new Random();
    char piezaSeleccionada;
    char turnoJugador ;
    
    Tablero(){ //Método constructor del tablero, rellenando con huecos en blanco y las piezas
        
        for(int y=0; y<7; y++) { //Se rellena la matriz de ceros (Espacios en Blanco)
            for(int x=0; x<7; x++) {
                tableMatrix[x][y] = '0';
            }
        }
        //Colocación inicial de las piezas del jugador 1
        this.colocarPieza(0, 0, Tablero.ZOMBI_1);
        this.colocarPieza(1, 0, Tablero.MAGO_1);
        this.colocarPieza(2, 0, Tablero.CABALLERO_1);
        this.colocarPieza(3, 0, Tablero.REY_1);
        this.colocarPieza(4, 0, Tablero.CABALLERO_1);
        this.colocarPieza(5, 0, Tablero.MAGO_1);
        this.colocarPieza(6, 0, Tablero.ZOMBI_1);
        //Colocación inicial de las piezas del jugador 2
        this.colocarPieza(0, 6, Tablero.ZOMBI_2);
        this.colocarPieza(1, 6, Tablero.MAGO_2);
        this.colocarPieza(2, 6, Tablero.CABALLERO_2);
        this.colocarPieza(3, 6, Tablero.REY_2);
        this.colocarPieza(4, 6, Tablero.CABALLERO_2);
        this.colocarPieza(5, 6, Tablero.MAGO_2);
        this.colocarPieza(6, 6, Tablero.ZOMBI_2);
    }
    
    public void startMatrix (Tablero tablero){ 
        for(int y=0; y<7; y++) { //Se rellena la matriz de ceros (Espacios en Blanco)
            for(int x=0; x<7; x++) {
                tableMatrix[x][y] = '0';
            }
        }
    }
    
    public void mostrarTablero() { //Se muestra el tablero por la consola de comandos
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                System.out.print(tableMatrix[x][y]);
            }
            System.out.println();
        }
    }
    
    public char cambioTurno (char turnoJugador){
        if (turnoJugador == JUGADOR_1){
            turnoJugador = JUGADOR_2;
        }
        else {
            turnoJugador = JUGADOR_2;
        }
        return turnoJugador;
    }
    
    public void tirarDado(char turnoJugador){
        int siguientePieza = turnoPieza.nextInt(4);
        
        if(turnoJugador == JUGADOR_1){
            switch (siguientePieza){
                case '0':
                    piezaSeleccionada = Tablero.ZOMBI_1;
                break;
                case '1':
                    piezaSeleccionada = Tablero.MAGO_1;
                break;
                case '2':
                    piezaSeleccionada = Tablero.CABALLERO_1;
                break;
                case '3':
                    piezaSeleccionada = Tablero.REY_1;
                break;
            }
        }
        
        else if(turnoJugador == JUGADOR_2){
            switch (siguientePieza){
                case '0':
                    piezaSeleccionada = Tablero.ZOMBI_2;
                break;
                case '1':
                    piezaSeleccionada = Tablero.MAGO_2;
                break;
                case '2':
                    piezaSeleccionada = Tablero.CABALLERO_2;
                break;
                case '3':
                    piezaSeleccionada = Tablero.REY_2;
                break;
            }
        }
    }
    
    public boolean estaLibreCelda (int x, int y){ //Comprueba si la celda seleccionada está vacía o no True=Vacía False=Contiene una pieza
        if (tableMatrix[x][y] == '0'){
            return true;
        } 
        else{
            return false;
        }      
    }
    
    public void colocarPieza (int x, int y, char tipoPieza ){
        tableMatrix[x][y] = tipoPieza;
    }
    
    public void quitarPieza (int x, int y, char tipoPieza ){
        tableMatrix[x][y] = '0';
    }
    
    public void moverPieza(int xInicial, int yInicial, int xDestino, int yDestino, char nombrePieza) {
        try{
            tableMatrix[xDestino][yDestino] = tableMatrix[xInicial][yInicial];
            tableMatrix[xInicial][yInicial]= '0';
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR: No existe la posición indicada");
        } catch(Exception e) {
            System.out.println("ERROR desconocido");
        }
        
    }
}
