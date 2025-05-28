package examen2.busquedatesoro;

import java.util.Scanner;
import static examen2.busquedatesoro.BusquedaTesoro.*;

public class BusquedaTesoroPrincipal {
	
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar las filas*/
		int filas;
		
		/*Creamos una variable para almacenar las columnas*/
		int columnas;
		
		/*Creamos una variable para almacenar el numero de obstaculos*/
		int numObstaculos;
		
		/*Creamos una variable para almacenar la direccion del usuario*/
		String direccion;
		
		/*Creamos una variable para almacenar si es posible realizar el movimiento del jugador*/
		int posibleMovimiento;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un bucle do while para pedir al usuario el tamaño de las filas mientras sea menor de 2*/
		do {
			/*Pedimos al usuario que introduzca el numero de filas*/
			System.out.println("Introduce el numero de filas del tablero mayor de 1");
			
			/*Leemos la fila del usuario*/
			filas = sc.nextInt();
			sc.nextLine();
			
		} while(filas < 2 );
			
		/*Creamos un bucle do while para pedir al usuario el tamaño de las columnas mientras sea menor de 2*/
		do {
			/*Pedimos al usuario que introduzca el numero de columnas*/
			System.out.println("Introduce el numero de columnas del tablero mayor de 1");
			
			/*Leemos la columna del usuario*/
			columnas = sc.nextInt();
			sc.nextLine();
			
		} while(columnas < 2);
		
		/*Inicializamos el tablero llamando a la funcion*/
		inicializaTablero(filas, columnas);
		
		/*Insertamos el tesoro en el tablero llamando a la funcion*/
		generarPosicionTesoro();
		
		/*Calculamos el numero de obstaculos*/
		numObstaculos = (int) Math.sqrt(filas * columnas) / 2;
		
		/*Insertamos los obstaculos en el tablero llamando a la funcion*/
		generarObstaculos(numObstaculos);
		
		/*Generamos la posicion aleatoria del jugador en el tablero*/
		generarPosicionJugador();
		
		/*Creamos un buclw while para que mientras no se encuentre el tesoro seguir preguntando al usuario por la posicion*/
		while(tablero[posI][posJ] != 'X') {
			
			/*Mostramos el tablero al usuario*/
			pintaTablero();
			
			/*Pedimos al usuario que introduzca hacia donde quiere moverse*/
			System.out.println("Introduce hacia que direccion quieres ir");
			
			/*Leemos la direccion del usuario*/
			direccion = sc.nextLine();
			
			/*Comprobamos si podemos realizar el movimiento llamando a la funcion*/
			posibleMovimiento = mueveJugador(direccion);
			
			/*Si el movimiento se ha realizado mostramos un mensaje*/
			if(posibleMovimiento == 0) {
				System.out.println("Se ha movido al jugador hacia la direccion introducida");
				
			/*Si el movimiento no se ha podido realizar porque hay un obstaculo o se sale del tablero avisamos al usuario*/
			} else if(posibleMovimiento == -1) {
				System.out.println("No se puede realizar el movimiento ya que hay un obstaculo o se sale del tablero");
				
			/*Si el movimiento no existe avisamos al usuario*/
			} else if(posibleMovimiento == -2) {
				System.out.println("No entiendo el movimiento");
			}
		}
		
		System.out.println("ENHORABUENA, HAS LLEGADO AL TESORO");
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}