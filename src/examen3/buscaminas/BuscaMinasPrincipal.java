package examen3.buscaminas;

import java.util.Scanner;

import static examen3.buscaminas.BuscaMinas.*;

public class BuscaMinasPrincipal {
	
	public static void main(String[] args) {
		
		/*Creamos un tablero donde almacenamos las minas y los numeros*/
		char[][] tableroSolucion;
		
		/*Creamos un tablero donde se realizaran las jugadas del jugador*/
		char[][] tableroJugador;
		
		/*Creamos una variable para almacenar el numero de filas del tablero*/
		int numFilas;
		
		/*Creamos una variable para almacenar el numero de columnas del tablero*/
		int numColumnas;
		
		/*Creamos una variable para almacenar la fila donde se encunetra el jugador*/
		int fila;
		
		/*Creamos una variable para almacenar la columna donde se encunetra el jugador*/
		int columna;
		
		/*Creamos una variable para almacenar el numero de minas*/
		int numMinas;
		
		/*Creamos una variable que almacenara el numero de casillas donde no hay minas*/
		int numCasillas;
		
		/*Creamos el Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un bucle do while para pedir el numero de columnas hasta que sea mayor a 6*/
		do {
			/*Pedimos al usuario que introduzca el numero de filas*/
			System.out.println("Introduce el numero de filas mayor a 6");
			
			/*Leemos las filas del tablero*/
			numFilas = sc.nextInt();
			sc.nextLine();
		} while(numFilas < 7);
		
		/*Creamos un bucle do while para pedir el numero de columnas hasta que sea mayor a 6*/
		do {
			/*Pedimos al usuario que introduzca el numero de columnas*/
			System.out.println("Introduce el numero de columnas mayor a 6");
			
			/*Leemos las columnas del tablero*/
			numColumnas = sc.nextInt();
			sc.nextLine();
		} while(numColumnas < 7);
		
		/*Inicializamos el tablero de la solucion llamando a la funcion*/
		tableroSolucion = inicializarTablero(numFilas, numColumnas);
		
		/*Inicializamos el tablero del jugador llamando a la funcion*/
		tableroJugador = inicializarTablero(numFilas, numColumnas);
		
		/*Calculamos el numero de minas del tablero*/
		numMinas = (int) (numFilas * numColumnas * 0.15);
		
		/*Establecemos el numero de casillas*/
		numCasillas = (numFilas * numColumnas) - numMinas;

		/*Insertamos las minas en el tablero de la solucion*/
		insertarMinas(tableroSolucion, numMinas);
		
		/*Insertamos los numeros de minas en el tablero de la solucion*/
		comprobarMinasAlrededor(tableroSolucion);
		
//		Para revisar
//		pintarTablero(tableroSolucion);
		
		/*Creamos un bucle do while para que mientras no encunetre una mina y no haya ganado continuar el juego*/
		do {
			
			/*Pedimos al usuario que introduzca una fila*/
			System.out.println("Introduce una fila");
			
			/*Leemos la fila del usuario*/
			fila = sc.nextInt() - 1;
			sc.nextLine();
			
			/*Pedimos al usuario que introduzca una columna*/
			System.out.println("Introduce una columna");
			
			/*Leemos la columna del usuario*/
			columna = sc.nextInt() - 1;
			sc.nextLine();
			
			/*Almacenamos la casilla del tablero solucion al tablero jugador*/
			tableroJugador[fila][columna] = tableroSolucion[fila][columna];
			
			/*Mostramos el tablero del jugador*/
			pintarTablero(tableroJugador);
			
			/*Restamos 1 al contador de casillas*/
			numCasillas--;
			
		} while(tableroJugador[fila][columna] != '*' && numCasillas > 0);
		
		/*Si la ultima posicion del usuario es una mina mostramos un mensaje de que ha perdido*/
		if(tableroJugador[fila][columna] == '*') {
			System.out.println("HAS ENCONTRADO UNA MINA");
		
		/*Si no es que ha ganado*/
		} else {
			System.out.println("HAS GANADO");
		}
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}