package query;
import block.Record;

public interface SearchStrategy {
		
	@FunctionalInterface
	public interface Search {
		public Record[] lookup(String x);
	}
	
	
	
	public static Search full_table_scan = (x) -> {
		return null;
	};
	
	public static Search index_lookup = (x) -> {
		return null;
	};
	
	
}
