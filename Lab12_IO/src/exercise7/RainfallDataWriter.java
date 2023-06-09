package exercise7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class RainfallDataWriter {

 public static void main(String[] args) {
		// 1. Declare output file 
					String outFile = "DataHujan_Ex7.txt";
						
					// Data declaration
					String station = "Station Simpang Ampat Alor Gajah";
					int rainfallReading[] = {0, 0, 4, 1, 0, 6};
						
					try {
							
						// 2. Create stream to read data
						BufferedWriter dos = new BufferedWriter(new FileWriter(outFile));
						PrintWriter printOut  = new PrintWriter(dos);	
						
						printOut.print(station);	
						
							for (int i = 0; i < rainfallReading.length; i++) {
								
								// 3. Write data into f
									
								printOut.print("-");
								printOut.print(rainfallReading[i]);
								
							}
							// 4. Flush for each writing
							dos.flush();
							
							// 5. Close stream
							dos.close();
							
						} catch (Exception ex) {
							
							ex.printStackTrace();
						}
						
						// Indicate end of program - Could be successful
						System.out.println("End of program. Check out " + outFile); 
	}
}