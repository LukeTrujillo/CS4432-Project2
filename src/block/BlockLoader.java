package block;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BlockLoader {
	
	private final static int NUM_BLOCKS = 99;
	
	private final static String directory_str = "Project2Dataset";
	private final static File directory = new File(directory_str);
	
	private static Record[] allRecords = null;
	
	public static Record[] getAllRecords() {
		if(allRecords != null) {
			return allRecords;
		}
		
		List<Record> records = new ArrayList<Record>();
		
		for(int x = 1; x <= NUM_BLOCKS; x++) {
			
			for(Record r : getRecords(x)) {
				records.add(r);
			}
		}
		
		allRecords = records.toArray(new Record[0]);
		
		return allRecords;
	}
	
	public static Record[] getRecords(int blockNumber) {
		try {
			
			String blockString = Files.readAllLines(Paths.get(directory_str + "/F" + blockNumber + ".txt")).get(0);
		
			InternalBlockIterator blockIterator = new InternalBlockIterator(blockString);
		
			List<Record> records = new ArrayList<Record>();
			
			while(blockIterator.hasNext()) {
				String recordString = blockIterator.next();
				//now lets make it into a record
				
				Record record = Record.parseRecord(recordString);
				
				records.add(record);
			}
		
			return records.toArray(new Record[0]);
		} catch (IOException e) {
			System.out.println("Could not read file #" + blockNumber);
			e.printStackTrace();
		}
		
		return null;
	}
}
