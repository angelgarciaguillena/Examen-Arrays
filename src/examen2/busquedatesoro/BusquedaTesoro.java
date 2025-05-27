package examen2.busquedatesoro;

import java.util.Arrays;
import java.util.Random;

public class BusquedaTesoro {
	
	/*Creamos una variable para almacear el tablero de la busqueda*/
	static char[][] tablero;
	
	/*Creamos una variable para almacenar la posicion de la fila del jugador*/
	static int posI;
	
	/*Creamos una variable para almacenar la posicion de la columna del jugador*/
	static int posJ;
	
	static void inicializaTablero(int numFilas, int numColumnas) {
		
		tablero = new char[numFilas][numColumnas];
		
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], ' ');
		}
	}
	
	static void generarPosicionTesoro() {
		
		int posFilaTesoro;
		
		int posColumnaTesoro;
		
		Random rand = new Random();
		
		posFilaTesoro = rand.nextInt(0, tablero.length);
		posColumnaTesoro = rand.nextInt(0, tablero[0].length);
		
		tablero[posFilaTesoro][posColumnaTesoro] = 'X';
	}
	
	static void generarObstaculos(int numObstaculos) {
		
		int contador = 0;
		
		int posFilaObstaculo = 0;
		int posColumnaObstaculo = 0;
		
		Random rand = new Random();
		
		while(contador != numObstaculos) {
			
			posFilaObstaculo = rand.nextInt(0, tablero.length);
			posColumnaObstaculo = rand.nextInt(0, tablero[0].length);
			
			if(tablero[posFilaObstaculo][posColumnaObstaculo] != '*') {
				
				if(posFilaObstaculo-1 >= 0 
					&& posColumnaObstaculo-1 >= 0 
					&& posFilaObstaculo+1 <= tablero.length 
					&& posColumnaObstaculo+1 <= tablero[0].length
					&& tablero[posFilaObstaculo-1][posColumnaObstaculo-1] != '*' 
					&& tablero[posFilaObstaculo+1][posColumnaObstaculo+1] != '*'
					&& tablero[posFilaObstaculo-1][posColumnaObstaculo+1] != '*'
					&& tablero[posFilaObstaculo-1][posColumnaObstaculo-1] != '*'){
					
					contador++;
				}
			}
		}
	}
	
	static void generarPosicionJugador() {
		
		boolean posicionCorrecta = false;
		
		Random rand = new Random();
		
		while(!posicionCorrecta) {
			
			posI = rand.nextInt(0, tablero.length);
			posJ = rand.nextInt(0, tablero[0].length);
			
			if(tablero[posI][posJ] != '*' && tablero[posI][posJ] != 'X') {
				posicionCorrecta = true;
			}
		}
	}
	
	static void pintaTablero() {
		
		for(int i = 0; i < tablero[0].length; i++) {
			System.out.println("\t" + (i + 1));
		}
		
		System.out.println();
		
		for(int i = 0; i < tablero.length; i++) {
			
			System.out.println(i + "\t");
			
			for(int j = 0; j < tablero[i].length; j++) {
				
				if(tablero[i][j] == 'X') {
					System.out.println(" " + "\t");
					
				} else if(posI == i && posJ == j) {
					System.out.println("J" + "\t");
					
				} else {
					System.out.println(" " + "\t");
				}
			}
			
			System.out.println();
		}
	}
	
	static int mueveJugador(String movimiento) {
		
		int resultado = 0;
		
		switch(movimiento.toUpperCase()) {
		
		case "ARRIBA" -> {
			
			if(posI-1 >= 0 || tablero[posI-1][posJ] == '*') {
				resultado = -1;
			} else {
				posI -= 1;
			}
		}
		
		case "ABAJO" -> {
			
			if(posI+1 <= tablero.length || tablero[posI+1][posJ] == '*') {
				resultado = -1;
			} else {
				posI += 1;
			}
		}
		
		case "DERECHA" -> {
			
			if(posJ+1 <= tablero[0].length || tablero[posI+1][posJ] == '*') {
				resultado = -1;
			} else {
				posJ += 1;
			}
		}
		
		case "IZQUIERDA" -> {
			
			if(posJ-1 >= 0 || tablero[posI][posJ-1] == '*') {
				resultado = -1;
			} else {
				posJ -= 1;
			}
		}
		
		default -> {
			resultado = -2;
		}
		}
		
		return resultado;
	}
}
