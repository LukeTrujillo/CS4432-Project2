package main;

import java.util.Date;

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
	}
	
	public void executeEqualsQuery(int equals) {
		executeQuery(equals, equals, true, hashIndex);
	}
	
	private void executeQuery(int upper, int lower, boolean match, Index preferred) {
		long startTime = new Date().getTime();
		
		Index choosen = null;
		
		if(!indexGenerated) {
			choosen = defaultIndex;
		} else {
			choosen = preferred;
		}
		
		
		
		
		
		//index selected lets move on
		
		
		long endTime = new Date().getTime();
	}
}
