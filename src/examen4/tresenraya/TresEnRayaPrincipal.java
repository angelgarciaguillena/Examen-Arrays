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
		
		int contador = 0;
		
		String repetirJuego;
		
		boolean ganador = false;

		boolean valido;
		
		Scanner sc = new Scanner(System.in);
		
		inicializarTablero();
		
		turno = jugadorInicial();
		
		System.out.println("BIENVENIDO AL JUEGO DEL TRES EN RAYA");
		
		do {			
			
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
						
						if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
					        System.out.println("Fila o columna fuera de rango. Intenta de nuevo.");
					        valido = false;
					    } else {
					        valido = usuarioMueveFicha(fila, columna);
					        if (!valido) {
					            System.out.println("La casilla ya está ocupada. Intenta de nuevo.");
					        }
					    }
						
					} while(!valido);
					
					System.out.println("Tablero con movimiento:");
					imprimeTablero();
					
					ganador = esGanador(fichaUsuario);
					
					contador++;
					
					turno = 1;
					
				} else {
						
					System.out.println("Turno de la maquina");
						
					System.out.println("Tablero sin movimiento:");
					
					imprimeTablero();
						
					mueveFichaAleatoria();
						
					System.out.println("Tablero con movimiento:");
					imprimeTablero();
						
					ganador = esGanador(fichaOrdenador);
					
					contador++;
					
					turno = 0;
				}

				if(ganador) {
					
					if(turno == 1) {
						System.out.println("HA GANADO EL USUARIO");
					} else {
						System.out.println("HA GANADO LA MAQUINA");
					}
					
				} else if(contador == 9) {
					System.out.println("EMPATE");
					ganador = true;
				}
				
			} while(!ganador);
		
			System.out.println("Si deseas repetir el juego introduzca 'Si'");
			
			repetirJuego = sc.nextLine();
			
			limpiarTablero();
			
			contador = 0;
			
		} while(repetirJuego.equalsIgnoreCase("Si"));
		
		System.out.println("¡ADIOS!");
		sc.close();
	}
}