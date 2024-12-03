package _02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class AdventOfCode02_02 {

	public static void main(String[] args) {

		String directorioActual = System.getProperty("user.dir");
		String rutaArchivo = directorioActual + "\\src\\input02.txt";
		
		try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = "";
			int juego = 1;
			int resultado = 0;

			while ((linea = lector.readLine()) != null) {
				String[] numeroJuego_Tiradas = linea.split(":");
				StringBuilder numeroJuego = new StringBuilder();
				numeroJuego.append(numeroJuego_Tiradas[0]);
				String[] tiradas = (numeroJuego_Tiradas[1].trim().split(";"));

				
				int minimumRed = 0;
				int minimumGreen = 0;
				int minimumBlue = 0;
				
				for (int i = 0; i < tiradas.length; i++) {

					String[] cubos = tiradas[i].split(",");

					for (int j = 0; j < cubos.length; j++) {
						StringBuilder color = new StringBuilder();
						color.append(cubos[j].trim());

						if (color.indexOf("red") > -1) {
							color.delete(color.indexOf("red"), color.length());
							int cantidad = Integer.parseInt(color.toString().trim());
							if (cantidad > minimumRed) {
								minimumRed = cantidad;
							}
						} else if (color.indexOf("green") > -1) {
							color.delete(color.indexOf("green"), color.length());
							int cantidad = Integer.parseInt(color.toString().trim());
							if (cantidad > minimumGreen) {
								minimumGreen = cantidad;
							}
						} else if (color.indexOf("blue") > -1) {
							color.delete(color.indexOf("blue"), color.length());
							int cantidad = Integer.parseInt(color.toString().trim());
							if (cantidad > minimumBlue) {
								minimumBlue = cantidad;
							}
						}

					} // FIN FOR PARA CONOCER CANTIDAD DE CUBOS DE CADA COLOR

				} // FIN FOR DE TIRADAS
				
				System.out.println("Azul: " + minimumBlue + " | Rojo: " + minimumRed + " | Verde: " + minimumGreen);

 				int cubesSetPower = minimumBlue * minimumGreen * minimumRed;
				
 				resultado += cubesSetPower;


			} // FIN WHILE DE JUEGOS
			
			System.out.println(resultado);
			



		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

	}

}
