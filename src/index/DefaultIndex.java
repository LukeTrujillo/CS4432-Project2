package index;

import block.Record;

public class DefaultIndex implements Index<Integer> {

	@Override
	public Record[] get(Integer value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Integer value, IndexPointer indexPointer) {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() { return "Full Table Scan used";}

}
