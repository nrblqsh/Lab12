package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

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

public class RainfallDataOutput {

public static void main(String[] args) {
		
		// 1. Declare output file 
			String outFile = "DataHujan_Ex6.txt";
				
	// 2. insert data into array
			String[][] rainfallDatas = { {"Melaka Tengah","2222006", "Cheng (Taman Merdeka)", "0", "0","3", "0", "42", "10"}, 
					                {"Alor Gajah","2322006", "Melaka Pindah","0", "0", "0", "0", "2", "18"}, 
					                {"Jasin", "2424031","Datoh Kramat di Nyalas Melaka", "0", "0","0", "0", "0", "17"}, 
					                {"Jasin","2324032", "Ldg. Sing Lian di Bkt. Senggeh Melaka", "0", "0","0", "0", "0", "4"}, 
					                {"Melaka Tengah","2223023","Sg. Duyong", "0", "0","3", "0", "43", "26"},
					                {"Alor Gajah","2421003 ", "Simpang Ampat", "0", "4","1", "0", "6", "19"}};
						
			try {
					
				// 3. Create stream to read data
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
					
					// 4. insert data into file
					for (String[] rainfallData : rainfallDatas) {
						
						String districtName = rainfallData[0];
						String stationID = rainfallData[1];
						String stationName = rainfallData[2];
						String[] datas = {rainfallData[3], rainfallData[4], rainfallData[5], rainfallData[6], rainfallData[7], rainfallData[8]};
						
						// 5. write data into stream
						dos.writeUTF(districtName);
						dos.writeUTF(stationID);
						dos.writeUTF(stationName);
						
						for(String data : datas) {
							dos.writeInt(Integer.parseInt(data));
						}
					}
						
						// 6. Flush for each writing
						dos.flush();
						
						// 7. Close stream
						dos.close();
						
						System.out.println("Rainfall data has been written to " +outFile + ". Check it out");
					
					
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
			}
}