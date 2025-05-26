package examen1.hundirlaflota;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HundirLaFlota {
	
	/*Creamos una constante para almacenar la letra A*/
	static final char LETRA_A = 'A';
	
	char[][] inicializarTablero(int filas, int columnas){
		
		/*Creamos un tablero*/
		char[][] tablero = new char[filas][columnas];
		
		/*Inicializamos el tablero con guiones*/
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], '-');
		}
		
		/*Devolvemos el tablero*/
		return tablero;
	}
	
	char[][] crearTablero(int filas, int columnas){
		
		/*Creamos un tablero*/
		char[][] tablero = new char[filas][columnas];
		
		/*Inicializamos el tablero con la letra A*/
		for(int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], 'A');
		}
		
		/*Devolvemos el tablero*/
		return tablero;
	}
	
	void generarBarquitos(char[][] tablero, int numBarquitos) {
		
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
	
	void pintaTablero(char tableroJugador[][]) {
		
		/*Creamos un bucle for para mostrar el indice de arriba del tablero*/
		for(int i = 0; i < tableroJugador.length; i++) {
			System.out.print("\t" + (i + 1));
		}
		
		/*Hacemos un salto de linea*/
		System.out.println();
		
		/*Creamos un bucle for para recorrer las filas del tablero*/
		for(int i = 0; i < tableroJugador.length; i++) {
			
			/*Mostramos el indice de la izquierda del tablero*/
			System.out.print((char)(LETRA_A + i) + "\t");
			
			/*Creamos un bucle for para recorrer las columnas del tablero*/
			for(int j = 0; j < tableroJugador[i].length; j++) {
				System.out.print(tableroJugador[i][j] + "\t");
			}
			
			/*Hacemos un salto de linea*/
			System.out.println();
		}
	}
	
	boolean turnoJugador(char tablero[][], char tableroJugador[][]) {
		
		/*Creamos una variable para almacenar la fila del barco*/
		int filaBarco;
		
		/*Creamos una variable para almacenar la columna del barco*/
		int columnaBarco;
		
		/*Creamos una variable para almacenar si el barco se ha tocado o no*/
		boolean hundido;
		
		/*Creamos el Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Pedimos al usuario que introduzca la fila del barco*/
		System.out.println("Introduce la fila del barco");
		
		/*Leemos la fila del barco*/
		filaBarco = (sc.next().toUpperCase().charAt(0) - LETRA_A);
		
		/*Pedimos al usuario que introduzca la columna del barco*/
		System.out.println("Introduce la columna del barco");
		
		/*Leemos la columna del barco*/
		columnaBarco = sc.nextInt() - 1;
		sc.nextLine();
		
		/*Desvelamos la posicion introducida por el usuario*/
		tableroJugador[filaBarco][columnaBarco] = tablero[filaBarco][columnaBarco];
		
		/*Si la posicion que hemos desvelado es un barco indicamos que se ha hundido sino 
		 * indicamos que es agua y que no se ha hundido ningun barco*/
		if(tableroJugador[filaBarco][columnaBarco] == 'B') {
			System.out.println("HUNDIDO");
			hundido = true;
		} else {
			System.out.println("AGUA");
			hundido = false;
		}
		
		/*Devolvemos si el barco se ha hundido o no*/
		return hundido;
	}
}