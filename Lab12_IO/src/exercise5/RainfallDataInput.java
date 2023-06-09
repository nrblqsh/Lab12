
package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

public class RainfallDataInput {

	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "DataHujan_Ex5.txt";
		System.out.println("Reading data from " + sourceFile + "\n");

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int rainfallRead = 0;
			int totalRainfall = 0;
			int recordsNo = 0;
			String date = "";
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				date = dis.readUTF();
				rainfallRead = dis.readInt();
				System.out.println( date +  " --> " + rainfallRead);
				
				// Calculate total utilization
				totalRainfall += rainfallRead;
				recordsNo ++;
			}
			
			// 4. Close stream
			dis.close();
			
			// Calculate rainfall reading
	
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