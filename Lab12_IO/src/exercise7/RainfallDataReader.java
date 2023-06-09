package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;

public class RainfallDataReader {

	public static void main(String[] args) {
		

		// 1. Declare output file 
		String sourceFile = "DataHujan_Ex7.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			BufferedReader dis = new BufferedReader(new FileReader(sourceFile));

			// Variables for processing byte-based data
			String rainfallRead;
			String rainfallData[] = {};
			int totalRainfall = 0;
			int recordsNo = 0;

			// 3. Process data until end-of-file
			 while ((rainfallRead = dis.readLine()) != null) {
				
				 rainfallData = rainfallRead.split("-");
			 }
			 
				String station ;
				station = rainfallData[0];
				System.out.println(station);
				System.out.println("Rainfall data : ");
				
				for(int i = 1; i < rainfallData.length; i++) {
					System.out.println(rainfallData[i] + ",");
					totalRainfall += Integer.parseInt(rainfallData[i]);
					recordsNo++;
				}
				
			dis.close();
							
			// Calculate average rainfall reading
			
			double averageRain = totalRainfall / recordsNo;
			String formattedAverage = String.format("%.1f", averageRain);
			System.out.print("\nAverage rainfall from station Simpang Ampat in Alor Gajah for " + recordsNo 
					+ " days : " + formattedAverage + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program 
		System.out.println("\n\nEnd Of Program.");
		

	}
}