package examen5.hundirlaflotaentidad;

import java.util.Arrays;

public class Jugador {
	
	private String nombre;
	private int barcosHundidos = 0;
	private char[][] tablero;
	
	public Jugador(String nombre, int filas, int columnas) {
		
		if(nombre != null && !nombre.isBlank()) {
			this.nombre = nombre;
		}
		
		this.tablero = new char[filas][columnas];
		
		for(int i = 0; i < this.tablero.length; i++) {
			Arrays.fill(this.tablero[i], '-');
		}
	}
		
	public String getNombre() {
		return nombre;
	}

	public int getBarcosHundidos() {
		return barcosHundidos;
	}

	public char[][] getTablero() {
		return tablero;
	}
	
	public boolean lanzarBomba(char[][] tableroSolucion, int fila, int columna) {
		
		boolean hundido = false;
		
		this.tablero[fila - 'A'][columna - 1] = tableroSolucion[fila - 'A'][columna - 1];
		
		if(this.tablero[fila - 'A'][columna - 1] == 'B') {
			hundido = true;
			barcosHundidos++;
		}
		
		return hundido;
	}
	
	@Override
	public String toString() {
		
		/*Creamos una variable para almacenar el tablero dl jugador*/
		String cadena = "";
		
		/*Almacenamos el nombre en la cadena*/
		cadena += "Turno de " + this.nombre + "\n";
		
		/*Creamos un bucle for para almacenar el indice de arriba del tablero*/
		for(int i = 0; i < this.tablero[0].length; i++) {
			cadena += "\t" + (i + 1);
		}
		
		/*Hacemos un salto de linea*/
		cadena += "\n";
		
		/*Creamos un bucle for para recorrer las filas del tablero*/
		for(int i = 0; i < this.tablero.length; i++) {
			
			/*Almacenamos el indice de la izquierda del tablero*/
			cadena += (char)('A' + i) + "\t";
			
			/*Creamos un bucle for para recorrer las columnas del tablero y almacenar la informacion del tablero*/
			for(int j = 0; j < this.tablero[i].length; j++) {
				cadena += this.tablero[i][j] + "\t";
			}
			
			/*Hacemos un salto de linea*/
			cadena += "\n";
		}
		
		return cadena;
	}	
}