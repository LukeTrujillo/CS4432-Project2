package block;

public class Record {

	public final static int RECORD_SIZE = 40;
	
	private int fileNumber;
	private int recordNumber;
	
	private int randomV;
	
	private String address;
	private String name;
	
	public Record(int fileNumber, int recordNumber, int randomV, String address, String name) {
		this.fileNumber = fileNumber;
		this.recordNumber = recordNumber;
		this.randomV = randomV;
		
		this.address = address;
		this.name = name;
	}
	
	public int getFileNumber() { return fileNumber; }
	public int getRecordNumber() { return recordNumber; }
	public int getRandomValue() { return randomV; }
	
	
	public String toString() {
		return null;
	}
	
	
	public static Record parseRecord(String query_string) {
		String[] parts = query_string.split(", ");
		
		
		
		return null;
	}
	
}
