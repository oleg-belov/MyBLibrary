package md.blibrary.app.dao.TransactionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TransactionManager {
	private static final String DATASOURCE_NAME = "jdbc/postgres";
	  private static DataSource ds = null;
		
	  static {
		  try {
		    Context envContext = (Context)(new InitialContext().lookup("java:/comp/env"));
		    		
		    ds = (DataSource)  envContext.lookup(DATASOURCE_NAME);
		  } catch (Exception ignore) {
			/*NOP*/
		}
	  }

	  public static Connection getConnection() throws SQLException{
		  Connection conn = ds.getConnection();
			
			return conn;
	  }
	  
	  public static void closeQuaetly(ResultSet rs, Statement stm, Connection conn) {
		  if (rs != null) {
			  try {
				  rs.close();
			  } catch (Exception ignore) {
				/*NOP*/
			}
		  }
		  if (stm != null) {
			  try {
				  stm.close();
			  } catch (Exception ignore) {
				/*NOP*/
			}
		  }
		  if (conn != null) {
			  try {
				  conn.close();
			  } catch (Exception ignore) {
				/*NOP*/
			}
		  }
	  }

	public static void rollBackQuaetly(Connection conn) {
		 if (conn != null) {
			  try {
				  conn.rollback();
			  } catch (Exception ignore) {
				/*NOP*/
			}
		  }
	}
	  
}
