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
		
		int contador = numObstaculos;
		
		int posFilaObstaculo = 0;
		int posColumnaObstaculo = 0;
		
		Random rand = new Random();
		
		while(contador > 0) {
			
			posFilaObstaculo = rand.nextInt(0, tablero.length);
			posColumnaObstaculo = rand.nextInt(0, tablero[0].length);
			
			if(tablero[posFilaObstaculo][posColumnaObstaculo] != '*' && tablero[posFilaObstaculo][posColumnaObstaculo] != 'X' && !obstaculoEnDiagonal(posFilaObstaculo, posColumnaObstaculo)) {
				
				tablero[posFilaObstaculo][posColumnaObstaculo] = '*';
				contador--;
				
			}
		}
	}
	
	private static boolean obstaculoEnDiagonal(int posFilaObstaculo, int posColumnaObstaculo) {
		
		int i = (posFilaObstaculo-1) < 0 ? 0 : posFilaObstaculo-1;
		int j = 0;
		
		boolean encontrado = false;
		
		while(i <= posFilaObstaculo+1 && i < tablero.length && !encontrado) {
			
			j = (posColumnaObstaculo-1) < 0 ? 0 : posColumnaObstaculo-1;
			
			while(j <= posColumnaObstaculo+1 && j < tablero[i].length && !encontrado) {
				
				if(tablero[i][j] == '*') {
					encontrado = true;
				}
				
				j+=2;
			}
			
			i+=2;
		}
		
		return encontrado;
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
			System.out.print("\t" + (i + 1));
		}
		
		System.out.println();
		
		for(int i = 0; i < tablero.length; i++) {
			
			System.out.print(i + "\t");
			
			for(int j = 0; j < tablero[i].length; j++) {
				
				if(tablero[i][j] == 'X') {
					System.out.print(" " + "\t");
					
				} else if(posI == i && posJ == j) {
					System.out.print("J" + "\t");
					
				} else {
					System.out.print(tablero[i][j] + "\t");
				}
			}
			
			System.out.println();
		}
	}
	
	static int mueveJugador(String movimiento) {
		
		int resultado = 0;
		
		switch(movimiento.toUpperCase()) {
		
		case "ARRIBA" -> {
			
			if(posI-1 >= 0 && tablero[posI-1][posJ] != '*') {
				posI -= 1;
			} else {
				resultado = -1;
			}
		}
		
		case "ABAJO" -> {
			
			if(posI+1 <= tablero.length && tablero[posI+1][posJ] != '*') {
				posI += 1;
			} else {
				resultado = -1;
			}
		}
		
		case "DERECHA" -> {
			
			if(posJ+1 <= tablero[0].length && tablero[posI+1][posJ] != '*') {
				posJ += 1;
			} else {
				resultado = -1;
			}
		}
		
		case "IZQUIERDA" -> {
			
			if(posJ-1 >= 0 && tablero[posI][posJ-1] != '*') {
				posJ -= 1;
			} else {
				resultado = -1;
			}
		}
		
		default -> {
			resultado = -2;
		}
		}
		
		return resultado;
	}
}
