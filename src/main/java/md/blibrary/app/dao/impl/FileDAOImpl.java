package md.blibrary.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import md.blibrary.app.dao.FileDAO;
import md.blibrary.app.dao.TransactionManager.TransactionManager;
import md.blibrary.app.dao.exceptions.NoSuchEntityException;
import md.blibrary.app.dao.exceptions.SystemException;



public class FileDAOImpl implements FileDAO {
	
	
	protected Connection getConnection() throws SystemException, SQLException {
		Connection conn = TransactionManager.getConnection();
		if(conn == null) {
			throw new SystemException("Call DAO methods only Undifined");
		}
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	public byte[] selectFileById(String sql, int fileId) throws SystemException, NoSuchEntityException {
		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		byte[] fileBytes = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			stm = conn.prepareStatement(sql);
			stm.setInt(1, fileId);
			rs = stm.executeQuery();
			if(rs.next()) {
				fileBytes = rs.getBytes(1);
			}
			conn.commit();
			return fileBytes;
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			TransactionManager.rollBackQuaetly(conn);
			throw new SystemException("Some exception", sqle);
		} finally {
			TransactionManager.closeQuaetly(rs, stm, conn);
		}
	}

}
