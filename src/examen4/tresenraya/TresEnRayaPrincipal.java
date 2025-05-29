package examen4.tresenraya;

import static examen4.tresenraya.TresEnRaya.*;

import java.util.Scanner;
public class TresEnRayaPrincipal {
	
	public static void main(String[] args) {
		
		final char fichaOrdenador = 'O';
		final char fichaUsuario = 'X';
		
		int turno;
		
		int fila;
		int columna;
		
		String repetirJuego;
		
		boolean ganador = false;

		boolean valido;
		
		Scanner sc = new Scanner(System.in);
		
		inicializarTablero();
		
		turno = jugadorInicial();
		
		do {
			
			System.out.println("BIENVENIDO AL JUEGO DEL TRES EN RAYA");
			
			do {
				if(turno == 0) {
					
					System.out.println("Turno del usuario");
					
					System.out.println("Tablero sin movimiento:");
					imprimeTablero();
					
					do {	
						System.out.println("Introduce la fila");
						
						fila = sc.nextInt() - 1;
						sc.nextLine();
						
						System.out.println("Introduce la columna");
						
						columna = sc.nextInt() - 1;
						sc.nextLine();
						
						valido = usuarioMueveFicha(fila, columna);
					} while(!valido);
					
					System.out.println("Tablero con movimiento:");
					imprimeTablero();
					
					ganador = esGanador(fichaUsuario);
					
					turno = 1;
					
				} else {
						
					System.out.println("Turno de la maquina");
						
					System.out.println("Tablero sin movimiento:");
					
					imprimeTablero();
						
					mueveFichaAleatoria();
						
					System.out.println("Tablero con movimiento:");
					imprimeTablero();
						
					ganador = esGanador(fichaOrdenador);
					
					turno = 0;

				}
				
				if(ganador) {
					
					if(turno == 1) {
						System.out.println("HA GANADO EL USUARIO");
					} else {
						System.out.println("HA GANADO LA MAQUINA");
					}
				} 
				
			} while(!ganador);
		
			System.out.println("Si deseas repetir el juego introduzca 'Si'");
			
			repetirJuego = sc.nextLine();
			
			limpiarTablero();
			
		} while(repetirJuego.equalsIgnoreCase("Si"));
		
		System.out.println("¡ADIOS!");
		sc.close();
	}
}