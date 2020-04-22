package index;

import block.Record;


public class IndexPointer {
	
	private int fileNumber;
	private int recordNumber;
	
	
	public IndexPointer(int fileNumber, int recordNumber) {
		this.fileNumber = fileNumber;
		this.recordNumber = recordNumber;
	}
	
	
	public Record getRecord() {
		return null;
	}
}
