import java.io.*;
public class Assignment5 {

	public static void main(String[] args) {
		int stateCode, childPopulation, totalPopulation, childPovertyPopulation; //necessary values
		BufferedReader read = null;
		PrintWriter write = null; //dataoutputstream to write to binary file
		String line = null;
		int[] overallChildPopulation = new int[100];
		int[] overallChildPovertyPopulation = new int[100];
		int[] overallTotalPopulation = new int[100];
		double[] percentage = new double[100];
		try { //try,catch to catch exception 
			read = new BufferedReader( new FileReader("src/PovertyData.txt")); //Creating buffered reader to read file
			while ((line = read.readLine()) != null ) { //while loop that reads necessary info and writes it to new file
				String temp = line.substring(0, 2);
				stateCode = Integer.parseInt(temp.trim());
				temp = line.substring(83, 90);
				
				totalPopulation = Integer.parseInt(temp.trim());
				temp = line.substring(92, 99);
				childPopulation = Integer.parseInt(temp.trim());
				temp = line.substring(101, 108);
				childPovertyPopulation = Integer.parseInt(temp.trim());
				overallChildPopulation[stateCode - 1] += childPopulation;
				overallChildPovertyPopulation[stateCode - 1] += childPovertyPopulation;
				overallTotalPopulation[stateCode - 1] += totalPopulation;
				percentage[stateCode - 1] = overallChildPovertyPopulation[stateCode - 1] / overallChildPopulation[stateCode - 1];
			}
			write = new PrintWriter("PFormatted.txt"); //writing to binary file
			for (int i = 0; i < 50; i++) {
				if (overallTotalPopulation[i] != 0) {
					write.printf("%d %10d %10d %n", (i+1), overallTotalPopulation[i], overallChildPopulation[i], overallChildPovertyPopulation[i]);
				}
			}
			read.close(); //closing writer and reader
			write.close();
		}
		catch(Exception e) {
            System.err.println( e.getMessage());
		}
	}

}
