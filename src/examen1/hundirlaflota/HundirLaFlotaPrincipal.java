package examen1.hundirlaflota;

import java.util.Scanner;

public class HundirLaFlotaPrincipal {
	
	public static void main(String[] args) {
		
		/*Creamos un tablero para almacenar el tablero solucion*/
		char[][] tableroSolucion;
		
		/*Creamos un tablero para almacenar el tablero del jugador 1*/
		char[][] tableroJugador1;
		
		/*Creamos un tablero para almacenar el tablero del jugador 2*/
		char[][] tableroJugador2;
		
		/*Creamos una variable para almacenar el numero de filas del tablero*/
		int numeroFila;
		
		/*Creamos una variable para almacenar el numero de columnas del tablero*/
		int numeroColumna;
		
		/*Creamos una variable para almacenar el numero de barcos que hay en el tablero*/
		int numeroBarcosTotales;
		
		/*Creamos una variable para almacenar el numero de barcos del jugador 1*/
		int barcosJugador1 = 0;
		
		/*Creamos una variable para almacenar el numero de barcos del jugador 2*/
		int barcosJugador2 = 0;
		
		/*Creamos una variable para almacenar si el jugador ha hundido algun barco*/
		boolean hundido;
		
		/*Creamos un objeto para acceder a las funciones*/
		HundirLaFlota funciones = new HundirLaFlota();
		
		/*Creamos el Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Preguntamos al usuario el numero de filas del tablero*/
		System.out.println("Introduce el numero de filas del tablero");
		
		/*Leemos el numero de filas del tablero*/
		numeroFila = sc.nextInt();
		funciones.sc.nextLine();
		
		/*Preguntamos al usuario el numero de columnas del tablero*/
		System.out.println("Introduce el numero de columnas del tablero");
		
		/*Leemos el numero de columnas del tablero*/
		numeroColumna = sc.nextInt();
		funciones.sc.nextLine();
		
		/*Creamos el tablero del jugador 1 llamando a la funcion*/
		tableroJugador1 = funciones.inicializarTablero(numeroFila, numeroColumna);
		
		/*Creamos el tablero del jugador 2 llamando a la funcion*/
		tableroJugador2 = funciones.inicializarTablero(numeroFila, numeroColumna);
		
		/*Creamos el tablero solucion llamando a la funcion*/
		tableroSolucion = funciones.crearTablero(numeroFila, numeroColumna);
		
		/*Calculamos el numero de barcos que hay en el tablero*/
		numeroBarcosTotales = (int) Math.sqrt(numeroFila * numeroColumna);
		
		/*Rellenamos el tablero de la solucion con los barcos llamando a la funcion*/
		funciones.generarBarquitos(tableroSolucion, numeroBarcosTotales);
		
		/*Mostramos al usuario un mensaje de que ha iniciado el juego*/
		System.out.println("BIENVENIDO AL HUNDIR LA FLOTA");
		
//		Para revisar
//		funciones.pintaTablero(tableroSolucion);
		
		/*Creamos un bucle while para que mientras no se haya encontrado todos los barcos del tablero seguir con el juego*/
		while(barcosJugador1 != numeroBarcosTotales && barcosJugador2 != numeroBarcosTotales) {
			
			/*Mostramos un mensaje de que es el turno del jugador 1*/
			System.out.println("Turno del jugador 1");
			
			/*Pintamos el tablero del jugador 1*/
			funciones.pintaTablero(tableroJugador1);
			
			/*Comenzamos con el movimiento del jugador 1 llamando a la funcion*/
			hundido = funciones.turnoJugador(tableroSolucion, tableroJugador1);
			
			/*Si el jugador a hundido a 1 barco sumamos 1 a sus barcos hundidos y repetimos su turno*/
			if(hundido) {
				barcosJugador1++;
				
			/*Si no pasamos al turno del jugador 2*/
			} else {
				
				/*Creamos un bucle do while para que mientras que el jugador 2 ha hundido a un barco y no haya encontrado todos los barcos repetir su turno */
				do{
					
					/*Mostramos un mensaje de que es el turno del jugador 2*/
					System.out.println("Turno del jugador 2");
					
					/*Pintamos el tablero del jugador 2*/
					funciones.pintaTablero(tableroJugador2);
					
					/*Hacemos el movimiento del jugador 2 llamando a la funcion*/
					hundido = funciones.turnoJugador(tableroSolucion, tableroJugador2);
					
					/*Si el jugador 2 a hundido a un barco se le suma 1 al contador de los barcos que ha hundido*/
					if(hundido) {
						barcosJugador2++;
					}
					
				}while(hundido && barcosJugador2 != numeroBarcosTotales);
			}
		}
		
		/*Si el numero de barcos del jugador 1 es mayor al del jugador 2 el jugador 1 ha ganado*/
		if(barcosJugador1 > barcosJugador2) {
			System.out.println("ENHORABUENA! HA GANADO EL JUGADOR 1");
			
		/*Si el numero de barcos del jugador 2 es mayor al del jugador 1 el jugador 2 ha ganado*/
		} else if(barcosJugador2 > barcosJugador1) {
			System.out.println("ENHORABUENA! HA GANADO EL JUGADOR 2");
		} 
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}