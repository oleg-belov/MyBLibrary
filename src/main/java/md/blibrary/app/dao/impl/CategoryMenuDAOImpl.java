package md.blibrary.app.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.TreeMap;

import md.blibrary.app.dao.CaregoryMenuDAO;
import md.blibrary.app.dao.TransactionManager.TransactionManager;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;


public class CategoryMenuDAOImpl implements CaregoryMenuDAO<Integer, String> {
	private static final String SELECT_ALL_SQL = "SELECT category_id, category_name "
												 	+ "FROM book_category "
												 	+ "GROUP BY category_id;";

	protected Connection getConnection() throws SystemException, SQLException {
		Connection conn = TransactionManager.getConnection();
		if(conn == null) {
			throw new SystemException("Call DAO methods only Undifined");
		}
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	public Map<Integer, String> selectAll() throws SystemException, NoSuchEntityException {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		TreeMap<Integer, String> categoryMap = new TreeMap<>();
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.createStatement();
			rs = stm.executeQuery(SELECT_ALL_SQL);
			
			while(rs.next()) {
				categoryMap.put(rs.getInt("category_id"), rs.getString("category_name"));
			}
			
			conn.commit();
			return categoryMap;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			TransactionManager.rollBackQuaetly(conn);
			throw new SystemException("Some exception", sqle);
		} finally {
			TransactionManager.closeQuaetly(rs, stm, conn);
		}
	}
}
