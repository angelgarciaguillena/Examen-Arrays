package examen2.busquedatesoro;

import java.util.Scanner;

public class BusquedaTesoroPrincipal {
	public static void main(String[] args) {
		
		/*Creamos una variable para almacenar las filas*/
		int fila;
		
		/*Creamos una variable para almacenar las columnas*/
		int columna;
		
		/*Creamos una variable para almacenar el numero de obstaculos*/
		int numObstaculos;
		
		/*Creamos un Scanner*/
		Scanner sc = new Scanner(System.in);
		
		/*Creamos un bucle do while para pedir al usuario el tamaño del tablero mientras sea menor de 2*/
		do {
			/*Pedimos al usuario que introduzca el numero de filas*/
			System.out.println("Introduce el numero de filas del tablero");
			
			/*Leemos la fila del usuario*/
			fila = sc.nextInt();
			sc.nextLine();
			
			/*Pedimos al usuario que introduzca el numero de columnas*/
			System.out.println("Introduce el numero de columnas del tablero");
			
			/*Leemos la columna del usuario*/
			columna = sc.nextInt();
			sc.nextLine();
			
		} while(fila < 2 && columna < 2);
		
		
		/*Inicializamos el tablero llamando a la funcion*/
		BusquedaTesoro.inicializaTablero(fila, columna);
		
		/*Insertamos el tesoro en el tablero llamando a la funcion*/
		BusquedaTesoro.generarPosicionTesoro();
		
		/*Calculamos el numero de obstaculos*/
		numObstaculos = (int) Math.sqrt((fila * columna) / 2);
		
		/*Insertamos los obstaculos en el tablero llamando a la funcion*/
		BusquedaTesoro.generarObstaculos(numObstaculos);
		
		/*Cerramos el Scanner*/
		sc.close();
	}
}