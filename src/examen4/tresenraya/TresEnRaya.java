package examen4.tresenraya;

import java.util.Arrays;
import java.util.Random;

public class TresEnRaya {
	
	static char[][] tablero = new char[3][3];
	
	static void inicializarTablero() {
		
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], ' ');
		}
	}
	
	static void imprimeTablero() {
		
		for(int i = 1; i < tablero.length+1; i++) {
			System.out.print("\t" + i);
		}
		
		System.out.println();
		
		for(int i = 0; i < tablero.length; i++) {
			System.out.print(i + 1 + "\t");
			for(int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
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
			Arrays.fill(tablero[i], ' ');
		}
	}
	
	static boolean esGanador(char ficha) {
		
		return comprobarFila(ficha) || comprobarColumna(ficha) || comprobarDiagonalIzquierda(ficha) || comprobarDiagonalDerecha(ficha);
	}
	
	private static boolean comprobarFila(char ficha) {
		
		int i = 0;
		int j = 0;
		
		boolean resultado = false;
		boolean auxiliarResultado = true;
		
		while(i < tablero.length && !resultado) {
			j = 0;
			
			while(j < tablero[i].length && auxiliarResultado) {
				
				if(tablero[i][j] != ficha) {
					auxiliarResultado = false;
				}
				j++;
			}
			
			resultado = auxiliarResultado;
			auxiliarResultado = true;
			i++;
		}
		
		return resultado;
	}
	
	private static boolean comprobarColumna(char ficha) {
		
		int i = 0;
		int j = 0;
		
		boolean resultado = false;
		boolean auxiliarResultado = true;
		
		while(j < tablero[0].length && !resultado) {
			i = 0;
			
			while(i < tablero.length && auxiliarResultado) {
				
				if(tablero[i][j] != ficha) {
					auxiliarResultado = false;
				}
				i++;
			}
			
			resultado = auxiliarResultado;
			auxiliarResultado = true;
			j++;
		}
		
		return resultado;
	}
	
	private static boolean comprobarDiagonalIzquierda(char ficha) {
		
		int i = 0;
		
		boolean resultado = true;
		
		while(i < tablero.length && resultado) {
			if(tablero[i][i] != ficha) {
				resultado = false;
			}
			i++;
		}
		
		return resultado;
	}
	
	private static boolean comprobarDiagonalDerecha(char ficha) {
		
		int i = 0;
		
		boolean resultado = true;
		
		while(i < tablero.length && resultado) {
			if(tablero[i][tablero.length - i - 1] != ficha) {
				resultado = false;
			}
			i++;
		}
		
		return resultado;
	}
}
