package examen4.tresenraya;

import java.util.Arrays;
import java.util.Random;

public class TresEnRaya {
	
	static char[][] tablero = new char[3][3];
	
	static void inicializarTablero() {
		
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero, ' ');
		}
	}
	
	static void imprimeTablero() {
		
		for(int i = 0; i < tablero.length; i++) {
			System.out.print(i+1);
		}
		
		System.out.println();
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]);
			}
			
			System.out.println();
		}
	}
	
	static int jugadorInicial() {
		
		int numero;
		
		Random rand = new Random();
		
		numero = rand.nextInt(0, 2);
		
		return numero;
	}
	
	static void mueveFichaAleatoria() {
		
		int fila;
		int columna;
		
		Random rand = new Random();
		
		do {
			
			fila = rand.nextInt(0, tablero.length);
			columna = rand.nextInt(0, tablero[0].length);
			
		} while(tablero[fila][columna] != ' ');
		
		tablero[fila][columna] = 'O';
	}
	
	static boolean usuarioMueveFicha(int fila, int columna) {
		
		boolean realizado = false;
		
		if(tablero[fila][columna] == ' ') {
			tablero[fila][columna] = 'X';
			realizado = true;
		}
		
		return realizado;
	}
	
	static void limpiarTablero() {
		
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero, ' ');
		}
	}
	
//	static boolean esGanador(char ficha) {
//		
//	}
//	
	private static boolean comprobarFila(char ficha) {
		int i = 0;
		int j = 0;
		
		boolean diferenciaEncontrada = false;
		boolean auxiliarResultado = true;
		
		while(i < tablero.length && !diferenciaEncontrada && auxiliarResultado) {
			j = 0;
			while(j < tablero[i].length && !diferenciaEncontrada) {
				if(tablero[i][j] != ficha) {
					diferenciaEncontrada = true;
				}
				j++;
			}
			auxiliarResultado = diferenciaEncontrada;
			auxiliarResultado = false;
			i++;
		}
		
		return diferenciaEncontrada;
	}
	
//	private static boolean comprobarColumna() {
//		
//		
//	}
}
