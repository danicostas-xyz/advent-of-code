import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class AdventOfCode02_01 {

	public static void main(String[] args) {

		String directorioActual = System.getProperty("user.dir");
		String rutaArchivo = directorioActual + "\\src\\input02.txt";

		try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = "";
			int juego = 1;
			int resultado = 0;

			final int AZULES = 14;
			final int ROJOS = 12;
			final int VERDES = 13;

			while ((linea = lector.readLine()) != null) {
				String[] numeroJuego_Tiradas = linea.split(":");
				StringBuilder numeroJuego = new StringBuilder();
				numeroJuego.append(numeroJuego_Tiradas[0]);
				String[] tiradas = (numeroJuego_Tiradas[1].trim().split(";"));
//				System.out.println(tiradas[0]);
				System.out.println("\n__________________________________ [JUEGO " + juego
						+ "] __________________________________");

				ArrayList<Boolean> posibilidades = new ArrayList<>();

				for (int i = 0; i < tiradas.length; i++) {
					System.out.println("");
					System.out.println("----> TIRADA " + (i + 1) + " ---------------------------------------");
					System.out.println("");

					String[] cubos = tiradas[i].split(",");

					int resultadoRojo = 0;
					int resultadoVerde = 0;
					int resultadoAzul = 0;

					for (int j = 0; j < cubos.length; j++) {
						StringBuilder color = new StringBuilder();
						color.append(cubos[j].trim());
						System.out.print("\t" + color + " -> ");

						if (color.indexOf("red") > -1) {
							color.delete(color.indexOf("red"), color.length());
							resultadoRojo = ROJOS - (Integer.parseInt(color.toString().trim()));
							System.out.println("Quedan " + resultadoRojo + " cubos rojos.");
						} else if (color.indexOf("green") > -1) {
							color.delete(color.indexOf("green"), color.length());
							resultadoVerde = VERDES - (Integer.parseInt(color.toString().trim()));
							System.out.println("Quedan " + resultadoVerde + " cubos verdes.");
						} else if (color.indexOf("blue") > -1) {
							color.delete(color.indexOf("blue"), color.length());
							resultadoAzul = AZULES - (Integer.parseInt(color.toString().trim()));
							System.out.println("Quedan " + resultadoAzul + " cubos azules.");
						}

					} // FIN FOR PARA CONOCER CANTIDAD DE CUBOS DE CADA COLOR
					System.out.println("");
					if (resultadoRojo >= 0 && resultadoAzul >= 0 && resultadoVerde >= 0) {
						posibilidades.add(true);
						System.out.println("\t\t (V) [Tirada posible]");
					} else {
						posibilidades.add(false);
						System.out.println("\t\t (X) [Tirada NO posible]");
					}

				} // FIN FOR DE TIRADAS

				System.out.println("");
				if ((posibilidades.contains(false))) {
					resultado = resultado;
					System.out.println(
							"- Juego no posible porque algunas de sus tiradas no tendrían suficientes cubos de algún color para ser materializadas.");
				} else {
					resultado += juego;
					System.out.println("- Juego posible. Todas las tiradas tienen suficientes cubos de cada color.");
				}

				juego++;

				System.out.println("");
				System.out.println("**(Acumulado temporal:  " + resultado + ")**");

			} // FIN WHILE DE JUEGOS

			System.out.println("");
			System.out.println(" ----------------------------");
			System.out.println("| Resultado final: " + resultado + "      | ");
			System.out.println(" ----------------------------");

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

	}

}