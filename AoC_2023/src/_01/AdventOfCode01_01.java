package _01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class AdventOfCode01_01 {

	public static void main(String[] args) {
		String directorioActual = System.getProperty("user.dir");
		String rutaArchivo = directorioActual + "\\src\\input01.txt";

		try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea = "";
			int resultado = 0;

			while ((linea = lector.readLine()) != null) {
				StringBuilder numeroNDigitos = new StringBuilder();

				for (int i = 0; i < linea.length(); i++) {

					if (Character.isDigit(linea.charAt(i))) {
						numeroNDigitos.append(linea.charAt(i));
					}
				}

				StringBuilder numeroDosDigitos = new StringBuilder();
				if (numeroNDigitos.length() > 2) {
					numeroDosDigitos.append(numeroNDigitos.charAt(0))
							.append(numeroNDigitos.charAt(numeroNDigitos.length() - 1));
				} else if (numeroNDigitos.length() == 1) {
					numeroDosDigitos.append(numeroNDigitos.charAt(0)).append(numeroNDigitos.charAt(0));
				} else if (numeroNDigitos.length() == 2) {
					numeroDosDigitos = numeroNDigitos;
				}

				System.out.println(numeroDosDigitos);
				int numeroInt = Integer.parseInt(numeroDosDigitos.toString());
				System.out.println(numeroInt);

				resultado += numeroInt;

			}
			System.out.println(resultado);
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

	}

}
