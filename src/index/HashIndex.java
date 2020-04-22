package index;
import java.util.ArrayList;
import java.util.HashMap;

import block.Record;
import block.BlockLoader;

public class HashIndex implements Index<Integer> {
	private HashMap<Integer, ArrayList<IndexPointer>> index;
	
	private int lastGetBlocksRead;
	
	public HashIndex() {
		index = new HashMap<Integer, ArrayList<IndexPointer>>();
	
		lastGetBlocksRead = 0;
		
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
	public Record[] get(Integer randomValue) {
		lastGetBlocksRead = 0;
		
		ArrayList<IndexPointer> list = index.get(randomValue);
		
		if(list == null) return null;
		
		HashMap<Integer, Record[]> loadedBlocks = new HashMap<Integer, Record[]>();
		
		ArrayList<Record> results = new ArrayList<Record>();
		
		
		for(IndexPointer ptr : list) {
			Record temp[];
			
			if(loadedBlocks.containsKey(ptr.getFileNumber())) {
				temp = loadedBlocks.get(ptr.getFileNumber());
			} else {
				temp = BlockLoader.getRecords(ptr.getFileNumber());
				
				loadedBlocks.put(ptr.getFileNumber(), temp);
				lastGetBlocksRead++;
			}
			
			results.add(temp[ptr.getRecordNumber() - 1]);
		}
		
		return results.toArray(new Record[0]);
	}
	
	public String toString() { return "HashIndex used";}

	@Override
	public int lastGetBlocksRead() {
		return lastGetBlocksRead;
	}
	
	
}
