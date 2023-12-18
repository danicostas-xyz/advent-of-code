import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;

public class AdventOfCode04_01 {
	public static void main(String[] args) {

		String directorioActual = System.getProperty("user.dir");
		String rutaArchivo = directorioActual + "\\src\\input04.test.txt";

		try (BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = "";
			int carta = 1;
			int resultado = 0;

			while ((linea = lector.readLine()) != null) {
				String[] headerBody = linea.split(":");
				String body = headerBody[1].trim();
				String[] boletoNumerosGanadores = body.split(" ");
				String boleto = boletoNumerosGanadores[0];
				String numerosGanadores = boletoNumerosGanadores[1];
				
				System.out.println(boleto + "-" + numerosGanadores);
				
				
			} // RECORRER EL TEXTO LÍNEA A LÍNEA

		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

	}
}
