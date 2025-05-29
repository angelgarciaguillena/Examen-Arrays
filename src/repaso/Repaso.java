package repaso;

public class Repaso {
	
	static char[][] tablero = new char[3][3];
	
	
	//Buscaminas
	
	//Comprobar las casillas de diagonal en 3*3 desde centro
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
	
	//Casteo de char necesario = si devuelve numero
	static void comprobarMinasAlrededor(char[][] tablero) {
		
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] != '*') {
					tablero[i][j] = (char) ('0' + contarNumeroMinas(tablero, i, j));
				}
			}
		}
	}
	
	//Contar casillas alrededor 3*3 desde centro y poner el numero en el centro
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
	
	
	
	//Tres en Raya
	
	//Comprobar las filas en 3*3 false no ha ganado
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
	
	//Comprobar todas las columnas en 3*3 false no ha ganado
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
	
	//Comprobar la diagonal izquierda en tablero 3*3 false no ha ganado
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
	
	//Comprobar diagonal derecha en tablero 3*3 false no ha ganado
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