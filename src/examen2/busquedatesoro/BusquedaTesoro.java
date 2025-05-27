package examen2.busquedatesoro;

import java.util.Arrays;
import java.util.Random;

/**
 * Clase que contiene las funciones principales del juego 'Busqueda del Tesoro'
 * 
 * @author Angel
 */
public class BusquedaTesoro {
	
	/**
	 * Creamos una variable para almacear el tablero de la busqueda
	 */
	public static char[][] tablero;
	
	/**
	 * Creamos una variable para almacenar la posicion de la fila del jugador
	 */
	public static int posI;
	
	/**
	 * Creamos una variable para almacenar la posicion de la columna del jugador
	 */
	public static int posJ;
	
	/**
	 * Funcion que se encarga de inicializar el tablero con espacios en blanco
	 * 
	 * @param numFilas Numero de filas del tablero
	 * @param numColumnas Numero de columnas del tablero
	 */
	public static void inicializaTablero(int numFilas, int numColumnas) {
		
		/*Creamos el tablero donde se va a realizar la busqueda*/
		tablero = new char[numFilas][numColumnas];
		
		/*Creamos un bucle for para inicializar el tablero con espacios en blanco*/
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], ' ');
		}
	}
	
	/**
	 * Funcion encargada de generar la posicion del tesoro en el tablero
	 */
	public static void generarPosicionTesoro() {
		
		/*Creamos una variable para almacenar la posicion de la fila del tesoro*/
		int posFilaTesoro;
		
		/*Creamos una variable para almacenar la posicion de la columna del tesoro*/
		int posColumnaTesoro;
		
		/*Creamos la clase Random*/
		Random rand = new Random();
		
		/*Generamos una posicion aleatoria de la fila donde va a estar el tesoro*/
		posFilaTesoro = rand.nextInt(0, tablero.length);
		
		/*Generamos una posicion aleatoria de la columna donde va a estar el tesoro*/
		posColumnaTesoro = rand.nextInt(0, tablero[0].length);
		
		/*Almacenamos en el tablero el tesoro en la posicion generada aleatoriamente*/
		tablero[posFilaTesoro][posColumnaTesoro] = 'X';
	}
	
	/**
	 * Funcion encargada de generar los obstaculos comprobando que no se generen en diagonales
	 * 
	 * @param numObstaculos Numero de obstaculos que se tiene que generar en el tablero
	 */
	public static void generarObstaculos(int numObstaculos) {
		
		/*Creamos una variable para almacenar la posicion de la fila del obstaculo*/
		int posFilaObstaculo = 0;
		
		/*Creamos una variable para almacenar la posicion de la columna del obstaculo*/
		int posColumnaObstaculo = 0;
		
		/*Creamos la clase Random*/
		Random rand = new Random();
		
		/*Creamos un bucle while para seguir generando posiciones hasta que no se hayan insertado todos los obstaculos*/
		while(numObstaculos > 0) {
			
			/*Generamos una posicion aleatoria de la fila donde va a estar el obstaculo*/
			posFilaObstaculo = rand.nextInt(0, tablero.length);
			
			/*Generamos una posicion aleatoria de la columna donde va a estar el obstaculo*/
			posColumnaObstaculo = rand.nextInt(0, tablero[0].length);
			
			/*Si la casilla es un espacio en blanco y no hay mas obstaculos en su diagonal insertamos el obstaculo y restamos 1 al contador*/
			if(tablero[posFilaObstaculo][posColumnaObstaculo] == ' ' && !obstaculoEnDiagonal(posFilaObstaculo, posColumnaObstaculo)) {
				
				/*Almacenamos el obstaculo en el tablero*/
				tablero[posFilaObstaculo][posColumnaObstaculo] = '*';
				
				/*Restamos 1 a los obstaculos que necesitamos insertar*/
				 numObstaculos--;
			}
		}
	}
	
	/**
	 * Funcion encargada de revisar que no haya otro obstaculo en las diagonales de la casilla donde vayamos a introducir
	 * un obstaculo y devuelve true si se ha encontrado un obstaculo en las diagonales o false si no se ha 
	 * encontrado obstaculos en las diagonales
	 * 
	 * @param posFilaObstaculo Numero de fila del obstaculo
	 * @param posColumnaObstaculo Numero de columna del obstaculo
	 * @return Devuelve true si se ha encontrado un obstaculo en las diagonales o false si no se ha encontrado obstaculos en las diagonales
	 */
	private static boolean obstaculoEnDiagonal(int posFilaObstaculo, int posColumnaObstaculo) {
		
		/*Creamos una variable que almacena la fila en la que estamos y establecemos la posicion de fila a 0 si se 
		 * sale del tablero y si no lo dejamos con el mismo valor*/
		int i = (posFilaObstaculo-1) < 0 ? 0 : posFilaObstaculo-1;
		
		/*Creamos una variable que almacena la columna en la que estamos*/
		int j = 0;
		
		/*Creamos una vbariable que almacenara si hemos encontrado un obstaculo o no*/
		boolean encontrado = false;
		
		/*Creamos un bucle while para buscar en las diagonales de filas si hay un obstaculo*/
		while(i <= posFilaObstaculo+1 && i < tablero.length && !encontrado) {
			
			/*Establecemos la posicion de columna a 0 si se sale del tablero y si no lo dejamos con el mismo valor*/
			j = (posColumnaObstaculo-1) < 0 ? 0 : posColumnaObstaculo-1;
			
			/*Creamos un bucle while para buscar en las diagonales de columnas si hay un obstaculo*/
			while(j <= posColumnaObstaculo+1 && j < tablero[i].length && !encontrado) {
				
				/*Si en la posicion hay un obstaculo marcamos que hemos encontrado un obstaculo*/
				if(tablero[i][j] == '*') {
					encontrado = true;
				}
				
				/*Sumamos 2 a las columnas para seguir recorriendo las diagonales*/
				j+=2;
			}
			
			/*Sumamos 2 a las filas para seguir recorriendo las diagonales*/
			i+=2;
		}
		
		/*Devolvemos si hemos encontrado un obstaculo*/
		return encontrado;
	}
	
	/**
	 * Funcion encargada de generar la posicion de inicio del jugador en el tablero
	 */
	public static void generarPosicionJugador() {
	
		/*Creamos la clase Random*/
		Random rand = new Random();
		
		/*Creamos un bucle do while para generar posiciones aleatorias mientras que la posicion aleatoria que generemos no sea un espacio en blanco*/
		do{
			/*Generamos una posicion aleatoria de la fila donde va a estar el jugador al principio del juego*/
			posI = rand.nextInt(0, tablero.length);
			
			/*Generamos una posicion aleatoria de la columna donde va a estar el jugador al principio del juego*/
			posJ = rand.nextInt(0, tablero[0].length);
			
		} while(tablero[posI][posJ] != ' ');
	}
	
	/**
	 * Funcion encargada de mostrar el tablero al usuario
	 */
	public static void pintaTablero() {
		
		/*Creamos un bucle for para mostrar el indice superior del tablero*/
		for(int i = 0; i < tablero[0].length; i++) {
			System.out.print("\t" + (i + 1));
		}
		
		/*Hacemos un salto de linea*/
		System.out.println();
		
		/*Creamos un bucle for para recorrer las filas del tablero*/
		for(int i = 0; i < tablero.length; i++) {
			
			/*Imprimimos el indice de la izquierda del tablero*/
			System.out.print(i + "\t");
			
			/*Creamos un bucle for para recorrer las columnas del tablero*/
			for(int j = 0; j < tablero[i].length; j++) {
				
				/*Si la posicion del tablero es donde se encuentra el tesoro imprimimos un espacio en blanco para ocultar el lugar del tesoro*/
				if(tablero[i][j] == 'X') {
					System.out.print(" " + "\t");
					
				/*Si la posicion del tablero es donde se encuentra el jugador imprimimos una J*/
				} else if(posI == i && posJ == j) {
					System.out.print("J" + "\t");
					
				/*Si no es ninguno de los anteriores casos imprimimos lo que tenga almacenado el tablero*/
				} else {
					System.out.print(tablero[i][j] + "\t");
				}
			}
			
			/*Hacemos un salto de linea*/
			System.out.println();
		}
	}
	
	/**
	 * Funcion encargada de realizar el movimiento del jugador si es posible y devuelve 0 si ha sido posible,
	 * -1 si el movimiento hace que el jugador se salga del tablero o se choque con un obstaculo y -2 si no 
	 * se ha entendido el movimiento que ha introducido el jugador
	 * 
	 * @param movimiento Movimiento del jugador
	 * @return Devuelve 0 si ha sido posible, -1 si el movimiento hace que el jugador se salga del tablero o se 
	 * choque con un obstaculo y -2 si no se ha entendido el movimiento que ha introducido el jugador
	 */
	public static int mueveJugador(String movimiento) {
		
		/*Creamos una variable para almacenar si el movimiento es correcto o no*/
		int resultado = 0;
		
		/*Creamos un switch para que depende de la opcion del usuario realizar una funcion u otra*/
		switch(movimiento.toUpperCase()) {
		
		/*Si el usuario introduce que quiere moverse hacia arriba*/
		case "ARRIBA" -> {
			
			/*Si la posicion de la fila no se sale del tablero por arriba y no hay un obstaculo nos movemos hacia esa posicion*/
			if(posI-1 >= 0 && tablero[posI-1][posJ] != '*') {
				posI -= 1;
				
			/*Si no guardamos que el movimiento no es valido*/
			} else {
				resultado = -1;
			}
		}
		
		/*Si el usuario introduce que quiere moverse hacia abajo*/
		case "ABAJO" -> {
			
			/*Si la posicion de la fila no se sale del tablero por abajo y no hay un obstaculo nos movemos hacia esa posicion*/
			if(posI+1 < tablero.length && tablero[posI+1][posJ] != '*') {
				posI += 1;
				
			/*Si no guardamos que el movimiento no es valido*/
			} else {
				resultado = -1;
			}
		}
		
		/*Si el usuario introduce que quiere moverse hacia la derecha*/
		case "DERECHA" -> {
			
			/*Si la posicion de la columna no se sale del tablero por la derecha y no hay un obstaculo nos movemos hacia esa posicion*/
			if(posJ+1 < tablero[0].length && tablero[posI+1][posJ] != '*') {
				posJ += 1;
				
			/*Si no guardamos que el movimiento no es valido*/
			} else {
				resultado = -1;
			}
		}
		
		/*Si el usuario introduce que quiere moverse hacia la izquierda*/
		case "IZQUIERDA" -> {
			
			/*Si la posicion de la columna no se sale del tablero por la izquierda y no hay un obstaculo nos movemos hacia esa posicion*/
			if(posJ-1 >= 0 && tablero[posI][posJ-1] != '*') {
				posJ -= 1;
				
			/*Si no guardamos que el movimiento no es valido*/
			} else {
				resultado = -1;
			}
		}
		
		/*Si la opcion no es valida almacenamos un -2 en el resultado*/
		default -> {
			resultado = -2;
		}
		}
		
		/*Devolvemos el resultado del movimiento*/
		return resultado;
	}
}