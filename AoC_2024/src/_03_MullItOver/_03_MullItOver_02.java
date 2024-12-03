package _03_MullItOver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03_MullItOver_02 {
	public static void main(String[] args) {

		ArrayList<String> validInput = getValidInput();
		for (String string : validInput) {
//			System.out.println(string + "\n");
		}

//		System.out.println("Longitud de validInput = " + validInput.size());

//		for (String string : validInput) {
//			System.out.println(string + "\n");
//		}

		ArrayList<String> multiplicationsArray = getMultiplications(validInput);
		ArrayList<String> numbersArray = getNumbers(multiplicationsArray);

		int total = 0;

		for (String string : numbersArray) {
			int numberA = Integer.parseInt(string.split(",")[0]);
			int numberB = Integer.parseInt(string.split(",")[1]);
//			System.out.println(numberA + " X " + numberB + " = " + (numberA*numberB));
			total += (numberA * numberB);
		}

		System.out.println(total);
	}

	public static ArrayList<String> getNumbers(ArrayList<String> multiplicationsArray) {
		ArrayList<String> digitsArray = new ArrayList<>();
		for (String multiplication : multiplicationsArray) {
			String regex = "\\d{1,3},\\d{1,3}";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(multiplication);
			while (matcher.find()) {
				digitsArray.add(matcher.group());
//				System.out.println(matcher.group());
			}
		}
		return digitsArray;
	}

	public static ArrayList<String> getMultiplications(ArrayList<String> validInput) {

		ArrayList<String> multiplicationsArray = new ArrayList<>();

		String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
		Pattern pattern = Pattern.compile(regex);

		for (String string : validInput) {
			Matcher matcher = pattern.matcher(string);
			while (matcher.find()) {
//				System.out.println(matcher.group());
				multiplicationsArray.add(matcher.group());
			}

		}

		return multiplicationsArray;
	}

	private static ArrayList<String> getValidInput() {

		ArrayList<String> multiplicationsArray = new ArrayList<>();

		String file = "src\\inputs\\input03.txt";
//      String text = "do()from()who()mul(741,501)~how()where()<what()[#where()mul(268,825)what()mul(958,990)){?(+'mul(427,368):%?how()?(mul(725,420)?when()}-from();mul(414,122/%-when():-'@mul(450,900)&what()<{ ]<'(?don't()balbalbalbal";
		String regex = "do\\(\\).*don't\\(\\)"; // GREEDY
		String regex2 = "do\\(\\).*?don't\\(\\)"; // LAZY
		String regex0 = ".*?don't\\(\\)";
		Pattern pattern0 = Pattern.compile(regex0);
		Pattern pattern = Pattern.compile(regex2, Pattern.DOTALL);

		String firstLine = "";
		StringBuilder sBuilder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new FileReader(file));) {

			String line = br.readLine();
			while (line != null) {

				sBuilder.append(line);
				line = br.readLine();
			}

			System.out.println(sBuilder);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Matcher matcccc = pattern0.matcher(sBuilder);
		if(matcccc.find()) {
			multiplicationsArray.add(matcccc.group());
		}

		System.out.println("");
		Matcher matcher = pattern.matcher(sBuilder);
		while (matcher.find()) {
			System.out.println(matcher.group());
			multiplicationsArray.add(matcher.group());
		}

		return multiplicationsArray;
	}
}
