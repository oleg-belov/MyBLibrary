package md.blibrary.app.dao.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import md.blibrary.app.dao.exceptions.NoSuchEntityException;


public abstract class Extractor<T> {
	public abstract T extract(ResultSet rs) throws SQLException;
	
	public List<T> extractAll(ResultSet rs) throws SQLException, NoSuchEntityException {
		List<T> result = new LinkedList<>();
		
		if(!rs.next()) {
			throw new NoSuchEntityException("No product in book library");
		}
		do {
			T entity =  extract(rs);
			result.add(entity);
		} while(rs.next());
		return result;
	}
}
