package _01_Historian_Hysteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _01_HistorianHysteria_02 {

	public static void main(String[] args) {

		String file = "src\\inputs\\input01.txt";

		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		List<Integer> similarityList = new ArrayList<>();

		readFile(file, leftList, rightList);
		getSimilarity(leftList, rightList, similarityList);
		int totalSimilarity = getTotalSimilarity(similarityList);
		System.out.println(totalSimilarity);
	}

	private static int getTotalSimilarity(List<Integer> similarityList) {
		int totalSimilarity = 0;

		for (Integer i : similarityList) {
			totalSimilarity += i;
		}

		return totalSimilarity;
	}

	private static void getSimilarity(List<Integer> leftList, List<Integer> rightList, List<Integer> similarityList) {

		for (Integer leftNumber : leftList) {

			int similarityScore = 0;
			int timesRepeated = 0;

			for (Integer rightNumber : rightList) {
				if (leftNumber.equals(rightNumber)) {
					timesRepeated++;
				}
			}

			similarityScore = leftNumber * timesRepeated;
			similarityList.add(similarityScore);
		}
	}

	private static void readFile(String file, List<Integer> leftList, List<Integer> rightList) {

		try (BufferedReader br = new BufferedReader(new FileReader(file));) {
			String line = br.readLine();
			while (line != null) {
				leftList.add(Integer.parseInt(line.split("   ")[0]));
				rightList.add(Integer.parseInt(line.split("   ")[1]));
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
