package _03_MullItOver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_MullItOver_01 {

	public static void main(String[] args) {

		List<String> multiplicationsArray = new ArrayList<>();
		getMultiplications(multiplicationsArray);
		List<String> numbersArray = getNumbers(multiplicationsArray);
		int total = 0;

		for (String string : numbersArray) {
			int numberA = Integer.parseInt(string.split(",")[0]);
			int numberB = Integer.parseInt(string.split(",")[1]);
			total += (numberA * numberB);
		}
		System.out.println(total);
	}

	private static List<String> getNumbers(List<String> multiplicationsArray) {
		List<String> digitsArray = new ArrayList<>();
		for (String multiplication : multiplicationsArray) {
			String regex = "\\d{1,3},\\d{1,3}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(multiplication);
			while (matcher.find()) {
				digitsArray.add(matcher.group());
			}
		}
		return digitsArray;
	}

	private static void getMultiplications(List<String> multiplicationsArray) {
		String file = "src\\inputs\\input03.txt";
		String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
		Pattern pattern = Pattern.compile(regex);

		try (BufferedReader br = new BufferedReader(new FileReader(file));) {

			String line = br.readLine();

			while (line != null) {
				Matcher matcher = pattern.matcher(line);
				while (matcher.find()) {
					multiplicationsArray.add(matcher.group());
				}
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
