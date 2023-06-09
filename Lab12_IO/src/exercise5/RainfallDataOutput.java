package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate reading byte-based data as it intended type 
 * it is using DataInputStream.
 * 
 * The data represents rainfall data a station in melaka 
 *
 * @author norbalqish
 *
 */
public class RainfallDataOutput {

	public static void main(String[] args) {
		
		// 1. Declare output file 
			String outFile = "DataHujan_Ex5.txt";
				
			// Data declaration
			String date[] = {"02/06/2023 ", "03/06/2023", "04/06/2023", "05/06/2023", "06/06/2023", "07/06/2023"};
			int  rainfallRead[] = {0, 0, 4, 1, 0, 6};
				
			try {
					
				// 2. Create stream to read data
				DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile));
					
					// Process data
					for (int index = 0; index < date.length; index++) {
						
						// 3. Write data into data stream
						dos.writeUTF(date[index]);
						dos.writeInt(rainfallRead[index]);
						
						// 4. Flush for each writing
						dos.flush();
					}
					
					// 5. Close stream
					dos.close();
					
				} catch (Exception ex) {
					
					ex.printStackTrace();
				}
				
				// Indicate end of program - Could be successful
				System.out.println("End of program. Check out " + outFile); 
			}
}