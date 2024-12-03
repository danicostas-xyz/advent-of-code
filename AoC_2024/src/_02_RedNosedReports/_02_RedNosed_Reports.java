package _02_RedNosedReports;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _02_RedNosed_Reports {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String url = "inputs\\input02.txt";

		List<Boolean> safeList = new ArrayList<Boolean>();

		// 1. Descartar filas que no sean decrecientes o crecientes
		// 2. De las filas buenas, comprobar que cada aumento/decremento es de 1, 2 o 3
		// (inclusivo) pero no mayor

		getSafeList(url, safeList);
		int safeReports = getNumberOfSafeReports(safeList);
		System.out.println("linea 25");
		System.out.println(safeReports);

	}

	private static int getNumberOfSafeReports(List<Boolean> safeList) {
		int safeReports = 0;

		for (Boolean b : safeList) {
			safeReports++;
		}

		return safeReports;
	}

	private static void getSafeList(final String url, List<Boolean> safeList) {
		try (BufferedReader br = new BufferedReader(new FileReader(url))) {

			String line = br.readLine();

			while (line != null) {

				String[] lineNumbers = line.split(" ");

				List<Boolean> resultListPositive = new ArrayList<>();
				List<Boolean> resultListNegative = new ArrayList<>();

				int x = 0;
				for (String s : lineNumbers) {

					int a = Integer.parseInt(s);

					if (x == 0) {
						x = a;
						continue;
					}

					if (a > x) {
						resultListPositive.add(true);
					} else
						resultListPositive.add(false);
				}

				x = 150;
				for (String s : lineNumbers) {

					int a = Integer.parseInt(s);

					if (a < x) {
						resultListNegative.add(true);
					} else
						resultListNegative.add(false);

					x = a;
				}

				// If this line passes the first check, we check the second ->

				List<Boolean> lista1 = new ArrayList<>();
				if (!resultListPositive.contains(false)) {
					int z = 0;
					for (String s : lineNumbers) {
						int b = Integer.parseInt(s);

						if (z == 0) {
							z = b;
							continue;
						}

						int difference = z - b;
						if (difference < 0)
							difference *= -1;

						if (difference > 0 && difference < 4) {
							lista1.add(true);
						}
					}
				}

				List<Boolean> lista2 = new ArrayList<>();
				if (!resultListNegative.contains(false)) {
					int z = 0;
					for (String s : lineNumbers) {
						int b = Integer.parseInt(s);

						if (z == 0) {
							z = b;
							continue;
						}

						int difference = z - b;
						if (difference < 0)
							difference *= -1;

						if (difference > 0 && difference < 4) {
							lista2.add(true);
						}
					}
				}

				if (!lista1.contains(false)) {
					safeList.add(true);
				}

				if (!lista2.contains(false)) {
					safeList.add(true);
				}

				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
