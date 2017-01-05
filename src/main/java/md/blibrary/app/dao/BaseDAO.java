package md.blibrary.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import md.blibrary.app.dao.TransactionManager.TransactionManager;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;
import md.blibrary.app.dao.extractor.Extractor;

public class BaseDAO<T> {
			
	protected static Connection getConnection() throws SystemException, SQLException {
		Connection conn = TransactionManager.getConnection();
		if(conn == null) {
			throw new SystemException("Call DAO methods only Undifined");
		}
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	protected List<T> selectALL(String sql, Extractor<T> extractor) throws SystemException, NoSuchEntityException {
		Connection conn = null;
		Statement stm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			stm = conn.createStatement();
			rs = stm.executeQuery(sql);
		
			List<T> result = extractor.extractAll(rs);
			
			conn.commit();
			return result;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			TransactionManager.rollBackQuaetly(conn);
			throw new SystemException("Some exception", sqle);
		} finally {
			TransactionManager.closeQuaetly(rs, stm, conn);
		}
	}
	
	protected T selectBy(String sql, int param, Extractor<T> extractor) throws SystemException, NoSuchEntityException {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			stm.setInt(1, param);
			rs = stm.executeQuery();
			
			if(!rs.next()) {
				throw new NoSuchEntityException("No product in book library");
			}
			
			T result = extractor.extract(rs);
			
			conn.commit();
			return result;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			TransactionManager.rollBackQuaetly(conn);
			throw new SystemException("Some exception", sqle);
		} finally {
			TransactionManager.closeQuaetly(rs, stm, conn);
		}
	}
	
	protected List<T> selectBy(String sql, Extractor<T> extractor, int param) throws SystemException, NoSuchEntityException {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			stm.setInt(1, param);
			rs = stm.executeQuery();
		
			List<T> result = extractor.extractAll(rs);
			
			conn.commit();
			return result;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			TransactionManager.rollBackQuaetly(conn);
			throw new SystemException("Some exception", sqle);
		} finally {
			TransactionManager.closeQuaetly(rs, stm, conn);
		}
	}

}
