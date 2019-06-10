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
        //Matriz que contiene un caracter que representa cada pieza del tablero
    public char[][] tableMatrix = new char[7][7]; 
    
        //Matriz para representar efectos visuales sin modificar la posición de las piezas
    public char[][] tableMatrixEfects = new char[7][7]; 
    
        //Variables que representan los puntos de vida de cada pieza, las que no aparecen no les hace falta pues caen después de un ataque
    public static short hp_MAGO_1 = 2;
    public static short hp_MAGO_2 = 2;
    public static short hp_CABALLERO_1 = 4;
    public static short hp_CABALLERO_2= 4;
    public static short hp_MURCIELAGO_1 = 2;
    public static short hp_MURCIELAGO_2 = 2;
    public static short hp_MAGO_1_2 = 2;
    public static short hp_MAGO_2_2 = 2;
    public static short hp_CABALLERO_1_2 = 4;
    public static short hp_CABALLERO_2_2= 4;
    public static short hp_MURCIELAGO_1_2 = 2;
    public static short hp_MURCIELAGO_2_2 = 2;
    
        //Variables que representan la pieza en el tablero
    public static final char JUGADOR_1 = '1';
    public static final char JUGADOR_2 = '2';   
    public static final char REY_1 = 'R';
    public static final char REY_2 = 'r';
    public static final char MAGO_1 = 'M';
    public static final char MAGO_2 = 'm';
    public static final char CABALLERO_1 = 'C';
    public static final char CABALLERO_2 = 'c';
    public static final char MURCIELAGO_1 = 'B';
    public static final char MURCIELAGO_2 = 'b';
    public static final char ZOMBI_1 = 'Z';
    public static final char ZOMBI_2 = 'z';
    public static final char MAGO_1_2 = 'W';
    public static final char MAGO_2_2 = 'w';
    public static final char CABALLERO_1_2 = 'K';
    public static final char CABALLERO_2_2 = 'k';
    public static final char MURCIELAGO_1_2 = 'V';
    public static final char MURCIELAGO_2_2 = 'v';
    
        //Marcadores para efectos visuales (remarcar de algún color)
    public static final char SELECCIONADA = 'S';
    public static final char RESALTADA_VALIDA = 'X';
    public static final char RESALTADA_PROHIBIDA = 'W';
    Random dadoPieza = new Random();
    public static char piezaActiva;
    public static char piezaSeleccionable;
    public static char piezaSeleccionableAlt;
    public static char turnoJugador ;
    
    Tablero(){ //Método constructor del tablero, rellenando con huecos en blanco y colocando las piezas iniciales en su posición
        
        for(int y=0; y<7; y++) { //Se rellena la matriz de ceros (Espacios en Blanco)
            for(int x=0; x<7; x++) {
                tableMatrix[x][y] = '0';
                tableMatrixEfects[x][y] = '0';
            }
        }
        //Colocación inicial de las piezas del jugador 1
        colocarPieza(0, 0, Tablero.MURCIELAGO_1);
        colocarPieza(1, 0, Tablero.MAGO_1);
        colocarPieza(2, 0, Tablero.CABALLERO_1);
        colocarPieza(3, 0, Tablero.REY_1);
        colocarPieza(4, 0, Tablero.CABALLERO_1_2);
        colocarPieza(5, 0, Tablero.MAGO_1_2);
        colocarPieza(6, 0, Tablero.MURCIELAGO_1_2);
        colocarPieza(3, 1, Tablero.ZOMBI_1);
        //Colocación inicial de las piezas del jugador 2
        colocarPieza(0, 6, Tablero.MURCIELAGO_2);
        colocarPieza(1, 6, Tablero.MAGO_2);
        colocarPieza(2, 6, Tablero.CABALLERO_2);
        colocarPieza(3, 6, Tablero.REY_2);
        colocarPieza(4, 6, Tablero.CABALLERO_2_2);
        colocarPieza(5, 6, Tablero.MAGO_2_2);
        colocarPieza(6, 6, Tablero.MURCIELAGO_2_2);
        colocarPieza(3, 5, Tablero.ZOMBI_2);
    }
    
    public void startMatrix (Tablero tablero){ 
        for(int y=0; y<7; y++) { //Se rellena la matriz de ceros (Espacios en Blanco)
            for(int x=0; x<7; x++) {
                tableMatrix[x][y] = '0';
            }
        }
    }
    
    public void mostrarTablero(char[][] Tablero) { //Se muestra el tablero por la consola de comandos
        for(int y=0; y<7; y++) {
            for(int x=0; x<7; x++) {
                System.out.print(Tablero[x][y]+" ");
            }
            System.out.println();
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
    public void resaltarCelda(int x, int y, char resaltado){
        tableMatrixEfects[x][y] = resaltado;
    }
    public void quitarPieza (int x, int y){
        tableMatrix[x][y] = '0';
    }
    
    
    public void moverPieza(int xInicial, int yInicial, int xDestino, int yDestino) {
        
        if (this.tableMatrixEfects[xDestino][yDestino] == 'X'){ //Comprueba si la celda está vacía antes de mover la pieza
            try{
                this.colocarPieza(xDestino, yDestino, piezaActiva);
                this.quitarPieza(xInicial, yInicial);
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR: No existe la posición indicada");
            } catch(Exception e) {
                System.out.println("ERROR desconocido");
            }
        }
        else {System.out.println("No se puede mover a la posición indicada");}
    }
    

        
    public void tirarDado(char turnoJugador){

        int siguientePieza = dadoPieza.nextInt(4); // Se crea un número aleatorio para la selección de pieza seleccionable

        if(turnoJugador == JUGADOR_1){ // Se establecen las piezas seleccionables 
            switch (siguientePieza){
                case 0:
                    piezaSeleccionable = Tablero.MURCIELAGO_1;
                    piezaSeleccionableAlt = Tablero.MURCIELAGO_1_2;
                break;
                case 1:
                    piezaSeleccionable = Tablero.MAGO_1;
                    piezaSeleccionableAlt = Tablero.MAGO_1_2;
                break;
                case 2:
                    piezaSeleccionable = Tablero.CABALLERO_1;
                    piezaSeleccionableAlt = Tablero.CABALLERO_1_2;
                break;
                case 3:
                    piezaSeleccionable = Tablero.REY_1;
                break;
            }
        }
        else if(turnoJugador == JUGADOR_2){
            switch (siguientePieza){
                case 0:
                    piezaSeleccionable = Tablero.MURCIELAGO_2;
                    piezaSeleccionableAlt = Tablero.MURCIELAGO_2_2;
                break;
                case 1:
                    piezaSeleccionable = Tablero.MAGO_2;
                    piezaSeleccionableAlt = Tablero.MAGO_2_2;
                break;
                case 2:
                    piezaSeleccionable = Tablero.CABALLERO_2;
                    piezaSeleccionableAlt = Tablero.CABALLERO_2_2;
                break;
                case 3:
                    piezaSeleccionable = Tablero.REY_2;
                break;
            }
        }
        System.out.println("Se puede seleccionar: "+piezaSeleccionable+" "+piezaSeleccionableAlt); //Se muestran por consola qué piezas se pueden seleccionar
    }

    public char cambioTurno (char turnoAnterior){ 
    if (turnoAnterior == JUGADOR_1){
        turnoAnterior = JUGADOR_2;
    }
    else {
        turnoAnterior = JUGADOR_2;
    }
    return turnoAnterior;
    }
    
    public void seleccionarPieza(int x, int y){
        if (  this.tableMatrix[x][y] == piezaSeleccionable || this.tableMatrix[x][y] == piezaSeleccionableAlt){
            piezaActiva = tableMatrix[x][y];
        }
        else {
            System.out.println("No es posible seleccionar la casilla");
        }
    }
    
    public void mostrarResaltados(int x, int y){ //Para la pieza una vez generada se marcan las casillas como seleccionables
        switch (piezaSeleccionable){
            case CABALLERO_1:
                try {
                resaltarCelda(x+1, y, Tablero.RESALTADA_VALIDA);
                resaltarCelda(x-1, y, Tablero.RESALTADA_VALIDA);
                resaltarCelda(x, y+1, Tablero.RESALTADA_VALIDA);
                resaltarCelda(x, y-1, Tablero.RESALTADA_VALIDA);
                } catch(ArrayIndexOutOfBoundsException e) {
                //System.out.println("ERROR: No existe la posición indicada");
                }
            break;
            default:
                System.out.println("ERROR: No se puede mover hacia ninguna parte");
            break;
        }
    }
        
    
}


