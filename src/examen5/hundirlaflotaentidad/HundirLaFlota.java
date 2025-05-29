package examen5.hundirlaflotaentidad;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {
	
	/*Creamos el Scanner*/
	static Scanner sc = new Scanner(System.in);
	
	/*Creamos una constante para almacenar la letra A*/
	static final char LETRA_A = 'A';
	
	public static void main(String[] args) {
		
		/*Creamos un tablero para almacenar el tablero solucion*/
		char[][] tableroSolucion;
		
		/*Creamos una variable para almacenar el numero de filas del tablero*/
		int numeroFila;
		
		/*Creamos una variable para almacenar el numero de columnas del tablero*/
		int numeroColumna;
		
		/*Creamos una variable para almacenar la fila del barco*/
		int filaBarco;
		
		/*Creamos una variable para almacenar la columna del barco*/
		int columnaBarco;
		
		/*Creamos una variable para almacenar el numero de barcos que hay en el tablero*/
		int numeroBarcosTotales;
		
		/*Creamos una variable para almacenar el nombre del jugador*/
		String nombre;
		
		/*Creamos un objeto jugador 1*/
		Jugador jugador1 = null;
		
		/*Creamos un objeto jugador 2*/
		Jugador jugador2 = null;
		
		/*Creamos un objeto jugador principal*/
		Jugador jugadorPrincipal = null;
		
		/*Mostramos al usuario un mensaje de que ha iniciado el juego*/
		System.out.println("BIENVENIDO AL HUNDIR LA FLOTA");
		
		/*Preguntamos al usuario el numero de filas del tablero*/
		System.out.println("Introduce el numero de filas del tablero");
		
		/*Leemos el numero de filas del tablero*/
		numeroFila = sc.nextInt();
		sc.nextLine();
		
		/*Preguntamos al usuario el numero de columnas del tablero*/
		System.out.println("Introduce el numero de columnas del tablero");
		
		/*Leemos el numero de columnas del tablero*/
		numeroColumna = sc.nextInt();
		sc.nextLine();
		
		/*Pedimos al usuario que introduzca el nombre del primer jugador*/
		System.out.println("Introduce el nombre del primer jugador");
		
		/*Leemos el nombre del primer jugador*/
		nombre = sc.nextLine();
		
		/*Creamos al primer jugador*/
		jugador1 = new Jugador(nombre, numeroFila, numeroColumna);
		
		/*Pedimos al usuario que introduzca el nombre del segundo jugador*/
		System.out.println("Introduce el nombre del segundo jugador");
		
		/*Leemos el nombre del segundo jugador*/
		nombre = sc.nextLine();
		
		/*Creamos al segundo jugador*/
		jugador2 = new Jugador(nombre, numeroFila, numeroColumna);
		
		/*Creamos el tablero solucion llamando a la funcion*/
		tableroSolucion = crearTablero(numeroFila, numeroColumna);
		
		/*Calculamos el numero de barcos que hay en el tablero*/
		numeroBarcosTotales = (int) Math.sqrt(numeroFila * numeroColumna);
		
		/*Rellenamos el tablero de la solucion con los barcos llamando a la funcion*/
		generarBarquitos(tableroSolucion, numeroBarcosTotales);
		
//		Para revisar
//		pintaTablero(tableroSolucion);
		
		/*Pasamos al jugador 1*/
		jugadorPrincipal = jugador1;
		
		/*Creamos un bucle while para que mientras no se haya encontrado todos los barcos del tablero seguir con el juego*/
		while(jugadorPrincipal.getBarcosHundidos() != numeroBarcosTotales) {
			
			/*Pintamos el tablero del jugador 1*/
			System.out.println(jugadorPrincipal);
			
			/*Pedimos al usuario que introduzca la fila del barco*/
			System.out.println("Introduce la fila del barco en letra");
			
			/*Leemos la fila del barco*/
			filaBarco = (sc.next().toUpperCase().charAt(0));
			
			/*Pedimos al usuario que introduzca la columna del barco*/
			System.out.println("Introduce la columna del barco en numero");
			
			/*Leemos la columna del barco*/
			columnaBarco = sc.nextInt();
			sc.nextLine();
			
			/*Lanzamos la bomba llamando a la funcion y si la posicion que hemos desvelado es un barco indicamos que se
			 * ha hundido sino indicamos que es agua y cambiamos el turno*/
			if(jugadorPrincipal.lanzarBomba(tableroSolucion, filaBarco, columnaBarco)) {
				System.out.println("HUNDIDO");
				
			} else {
				System.out.println("AGUA");
				jugadorPrincipal = jugadorPrincipal == jugador1 ? jugador2 : jugador1;
			}
		}
		
		/*Mostramos quien ha ganado*/
		System.out.println("Enhorabuena! Ha Ganado El Jugador " + jugadorPrincipal.getNombre());
		
		/*Cerramos el Scanner*/
		sc.close();
	}
		
	static char[][] crearTablero(int filas, int columnas){
		
		/*Creamos un tablero*/
		char[][] tablero = new char[filas][columnas];
		
		/*Inicializamos el tablero con la letra A*/
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], 'A');
		}
		
		/*Devolvemos el tablero*/
		return tablero;
	}
	
	static void generarBarquitos(char[][] tablero, int numBarquitos) {
		
		/*Creamos una variable para almacenar la fila del barco*/
		int filaBarco;
		
		/*Creamos una variable para almacenar la columna del barco*/
		int columnaBarco;
		
		/*Creamos la clase Random*/
		Random rand = new Random();
		
		/*Creamos un bucle while para insertar los barcos en el tablero*/
		while(numBarquitos != 0) {
			
			/*Generamos la fila donde se encuentra el barco*/
			filaBarco = rand.nextInt(0, tablero.length);
			
			/*Generamos la columna donde se encuentra el barco*/
			columnaBarco = rand.nextInt(0, tablero.length);
			
			/*Si la posicion no tiene ya un barco lo insertamos y restamos uno a los barcos totales*/
			if(tablero[filaBarco][columnaBarco] != 'B') {
				tablero[filaBarco][columnaBarco] = 'B';
				numBarquitos--;
			}
		}
	}
	
	//Borrar
//	static void pintaTablero(char tableroJugador[][]) {
//		
//		/*Creamos un bucle for para mostrar el indice de arriba del tablero*/
//		for(int i = 0; i < tableroJugador[0].length; i++) {
//			System.out.print("\t" + (i + 1));
//		}
//		
//		/*Hacemos un salto de linea*/
//		System.out.println();
//		
//		/*Creamos un bucle for para recorrer las filas del tablero*/
//		for(int i = 0; i < tableroJugador.length; i++) {
//			
//			/*Mostramos el indice de la izquierda del tablero*/
//			System.out.print((char)(LETRA_A + i) + "\t");
//			
//			/*Creamos un bucle for para recorrer las columnas del tablero*/
//			for(int j = 0; j < tableroJugador[i].length; j++) {
//				System.out.print(tableroJugador[i][j] + "\t");
//			}
//			
//			/*Hacemos un salto de linea*/
//			System.out.println();
//		}
//	}
}