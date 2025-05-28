package examen3.buscaminas;

import java.util.Arrays;
import java.util.Random;

public class BuscaMinas {
	
	static char[][] inicializarTablero(int filas, int columnas) {
		
		char[][] tablero = new char[filas][columnas];
		
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], ' ');
		}
		
		return tablero;
	}
	
	static void insertarMinas(char[][] tablero, int numMinas) {
		
		int posFilaMina;
		int posColumnaMina;
		
		Random rand = new Random();
		
		while(numMinas > 0) {
			
			posFilaMina = rand.nextInt(0, tablero.length);
			posColumnaMina = rand.nextInt(0, tablero[0].length);
			
			if(tablero[posFilaMina][posColumnaMina] == ' ' && !minasEnDiagonal(tablero, posFilaMina, posColumnaMina)) {
				tablero[posFilaMina][posColumnaMina] = '*';
				numMinas--;
			}
		}
	}
	
	private static boolean minasEnDiagonal(char[][] tablero, int posFilaMina, int posColumnaMina) {
		
		int i = (posFilaMina-1 < 0) ? 0 : posFilaMina-1;
		int j = 0;
		
		boolean encontrado = false;
		
		while(i <= posFilaMina+1 && i < tablero.length && !encontrado) {
			
			j = (posColumnaMina-1 < 0) ? 0 : posColumnaMina-1;
			
			while(j <= posColumnaMina+1 && j < tablero[i].length && !encontrado) {
				
				if(tablero[i][j] == '*') {
					encontrado = true;
				}
				
				j+=2;
			}
			
			i+=2;
		}
		
		return encontrado;
	}
	
	static void comprobarMinasAlrededor(char[][] tablero) {
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] != '*') {
					tablero[i][j] = (char) ('0' + contarNumeroMinas(tablero, i, j));
				}
			}
		}
	}
	
	private static int contarNumeroMinas(char[][] tablero, int posCasillaI, int posCasillaJ) {
		
		int contador = 0;
		
		for(int i = (posCasillaI-1) < 0 ? 0 : posCasillaI-1; i < tablero.length && i <= posCasillaI+1; i++) {
			for(int j = (posCasillaJ-1) < 0 ? 0 : posCasillaJ-1; j < tablero[i].length && j <= posCasillaJ+1; j++) {
				if(tablero[i][j] == '*') {
					contador++;
				}
			}
		}
		
		return contador;
	}
	
	static void pintarTablero(char[][] tablero) {
		
		for(int i = 1; i < tablero.length + 1; i++) {
			System.out.print("\t" + i);
		}
		
		System.out.println("\n");
		
		for(int i = 0; i < tablero.length; i++) {
			System.out.print((i + 1) + "\t");
			
			for(int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			
			System.out.println();
		}
	}
}