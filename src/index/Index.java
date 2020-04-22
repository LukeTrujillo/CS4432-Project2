package index;

import block.Record;

public interface Index<N> {
	Record[] get(N value);
	
	void put(N value, IndexPointer indexPointer);

	String toString();
	
	int lastGetBlocksRead();
}
