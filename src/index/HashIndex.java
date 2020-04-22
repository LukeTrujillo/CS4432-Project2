package index;
import java.util.ArrayList;
import java.util.HashMap;

import block.Record;
import block.BlockLoader;

public class HashIndex implements Index<Integer> {
	private HashMap<Integer, ArrayList<IndexPointer>> index;
	
	public HashIndex() {
		index = new HashMap<Integer, ArrayList<IndexPointer>>();
	
		load();
	}
	
	private void load() {
		Record records[] = BlockLoader.getAllRecords();
		
		for(Record record : records) {
			IndexPointer ptr = new IndexPointer(record.getFileNumber(), record.getRecordNumber());
			
			put(record.getRandomValue(), ptr);
		}
	}

	
	@Override
	public void put(Integer randomValue, IndexPointer indexPointer) {
		
		ArrayList<IndexPointer> tempList = null;
		
		if(index.containsKey(randomValue)) {
			tempList = index.get(randomValue);
		} else {
			tempList = new ArrayList<IndexPointer>();
		}
		
		tempList.add(indexPointer);
		
		index.put(randomValue, tempList);
	}

	@Override
	public Record get(Integer randomValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
