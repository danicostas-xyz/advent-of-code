package _01_Historian_Hysteria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _01_HistorianHysteria_01 {

	public static void main(String[] args) {

		String file = "src\\inputs\\input01.txt";

		List<Integer> leftList = new ArrayList<>();
		List<Integer> rightList = new ArrayList<>();
		List<Integer> distanceList = new ArrayList<>();

		readFile(file, leftList, rightList);
		pairNumbers(leftList, rightList, distanceList);
		int totalDistance = getTotalDistanceBetweenLists(distanceList);
		System.out.println(totalDistance);

	}

	private static int getTotalDistanceBetweenLists(List<Integer> distanceList) {

		int totalDistance = 0;
		for (Integer i : distanceList) {
			totalDistance += i;
		}
		
		return totalDistance;
	}

	private static void pairNumbers(List<Integer> leftList, List<Integer> rightList, List<Integer> distanceList) {

		leftList.sort(null);
		rightList.sort(null);

		for (int i = 0; i < leftList.size(); i++) {
			int distance = leftList.get(i) - rightList.get(i);
			if (distance < 0) distance *= -1;
			distanceList.add(distance);
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
