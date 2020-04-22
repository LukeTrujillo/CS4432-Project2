package main;

import java.util.Date;

import block.BlockLoader;
import block.Record;
import index.ArrayIndex;
import index.DefaultIndex;
import index.HashIndex;
import index.Index;

public class DatabaseManager {

	private DefaultIndex defaultIndex;
	
	private HashIndex hashIndex;
	private ArrayIndex arrayIndex;
	
	private boolean indexGenerated;
	
	public DatabaseManager() {
		defaultIndex = new DefaultIndex();
		
		indexGenerated = false;
	}

	void createIndexes() {
		hashIndex = new HashIndex();
		arrayIndex = new ArrayIndex();
		
		indexGenerated = true;
		
		BlockLoader.flush();
	}
	
	public void executeEqualsQuery(int equals) {
		executeQuery(equals, equals, true, hashIndex);
	}
	
	private void executeQuery(int upper, int lower, boolean match, Index preferred) {
		BlockLoader.flush();
		long startTime = new Date().getTime();
		
		Index choosen = null;
		
		if(!indexGenerated) {
			choosen = defaultIndex;
		} else {
			choosen = preferred;
		}
		
		//now for the queries
		Record results[] = null;
		
		System.out.println("Results:");
		
		if(upper == lower && match) {
			for(Record r : choosen.get(upper)) {
				System.out.println("\t" + r);
			}
		} else if(upper != lower && match) {
			for(int x = Math.min(lower, upper); x < Math.max(lower, upper); x++) {
				for(Record r : choosen.get(x)) {
					System.out.println("\t" + r);
				}
			}
			
		} else if(upper == lower && !match) {
			
		}
		
		long endTime = new Date().getTime();
		
		System.out.println("Index: " + choosen);
		System.out.println("Time: " + (endTime - startTime));
		System.out.println("Disk Blocks Read:" + BlockLoader.getLoadedBlockCount());
		
		BlockLoader.flush();
	}
}
