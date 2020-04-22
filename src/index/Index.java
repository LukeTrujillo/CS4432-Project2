package index;

import block.Record;

public interface Index<N> {
	Record[] get(Integer value);
	
	void put(N value, IndexPointer indexPointer);

	String toString();
	

}
