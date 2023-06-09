
package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This program demonstrate reading byte-based data as it intended type 
 * it is using DataInputStream.
 * 
 * The data represents rainfall data in 6 station in melaka 
 * 
 * The program calculates the average data of rainfall and display it on the console.
 * 
 * @author norbalqish
 *
 */

public class RainfallDataInput {

	public static void main(String[] args) {

		// 1. Declare output file 
		try {

			// 2. Create stream to read data
			String sourceFile = "DataHujan_Ex6.txt";
			System.out.println("Reading data from " + sourceFile + "\n");
			
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			int totalAverageStation = 0;	
			int[] totalRainfall =  new int[6];
			int[] totalStation = new int[6];
			
			// 3. Process data until end-of-file
			while(dis.available() > 0) {
				
				// Read data
				String districtName = dis.readUTF();
				String stationID = dis.readUTF();
				String stationName = dis.readUTF();
				
				// 4. Print details
				System.out.println("\nDistrict Name : " +districtName);
				System.out.println("Station ID : " +stationID);
				System.out.println("Station Name : " +stationName + "\n");
				
				int stationTotalRainfall = 0;
				
				for(int i = 0; i < 6; i++) {
					int data = dis.readInt();
					stationTotalRainfall += data;
					totalRainfall[i] += data;
					totalStation[i]++;
					
					System.out.println("Day " +(i+1)+ " - " +data );
				}

				//5. Calculate average rainfall data for each station
				int averageStationRainfall = stationTotalRainfall/6;
				System.out.println("Average rainfall data : " +averageStationRainfall);
				totalAverageStation += averageStationRainfall;
				
			}
			
			//6. calculate average data for 6 stations
			int averageRainfall = totalAverageStation/6;
			System.out.println("\nAverage rainfall for 6 stations is " +averageRainfall);
			// 4. Close stream
			dis.close();
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program 
		System.out.println("\n\nEnd Of Program.");

	}
}