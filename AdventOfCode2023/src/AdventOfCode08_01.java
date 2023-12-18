import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AdventOfCode08_01 {

	public static void main(String[] args) {
		String directory = System.getProperty("user.dir");
		String filePath = directory + "\\src\\input08.test.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line = "";
			int result = 0;
			String input = reader.readLine();
			String blank = reader.readLine();
			int lineNumber = 0;
			
			String[][]

			ArrayList<String[]> network = new ArrayList<>();

			while ((line = reader.readLine()) != null) {

				String[] node = line.split(" = ");
				String nodeHeader = node[0];
				String[] nodeBody = node[1].split(", ");
				StringBuilder nodeBodyA = new StringBuilder();
				StringBuilder nodeBodyB = new StringBuilder();

				nodeBodyA.append(nodeBody[0].charAt(1)).append(nodeBody[0].charAt(2)).append(nodeBody[0].charAt(3));
				nodeBodyB.append(nodeBody[1].charAt(0)).append(nodeBody[1].charAt(1)).append(nodeBody[1].charAt(2));
				
				String[] headerAndBody = 
				
				

//				for (int i = 0; i < nodeBody.length; i++) {
//					if(nodeBody[i].indexOf("(") > -1) {
//						System.out.println(nodeBody[i].indexOf("("));
//						
//
//					} else if (nodeBody[i].indexOf(")") > -1) {
//						System.out.println(nodeBody[i].indexOf(")"));
//					}
//				}

				lineNumber++;
			}
//			System.out.println(result);
		} catch (IOException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
		}

	}

}
