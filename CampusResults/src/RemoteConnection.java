import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class RemoteConnection {
	private final static Logger LOGGER = Logger.getLogger(RemoteConnection.class.getName());


	public Connection getRemoteConnection() throws ClassNotFoundException {
		Connection con = null;

		System.out.println("Inside try");
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbName = "CampusResults";
		System.out.println(dbName);
		String userName = "CampusResults";
		System.out.println(userName);
		String password = "CampusResults";
		System.out.println(password);
		String hostname = "campusresults.cdvcqt1hpfyp.us-east-1.rds.amazonaws.com";
		System.out.println(hostname);
		String port ="3306";
		System.out.println(port);
		String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" ;
		System.out.println(jdbcUrl);
		System.out.println("After initialization");
		if(hostname!=null){
			try {
				LOGGER.info("Getting remote connection with connection string from environment variables.");
				con = DriverManager.getConnection(jdbcUrl+dbName, userName, password);
				LOGGER.info("Remote connection successful.");
				return con;
			}

			catch (Exception e) { LOGGER.warning(e.toString());}

		}
		return con;

	}
	
	
	public static void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
				// System.out.println("Error while closing the DB Connection: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	public static void closeStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception ex) {
				// System.out.println("Error while closing the Statement: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception ex) {
				// System.out.println("Error while closing the ResultSet: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (Exception ex) {
				//  System.out.println("Error while closing the PreparedStatement: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}
	public static void closeCallableStatement(CallableStatement cs) {
		if (cs != null) {
			try {
				cs.close();
			} catch (Exception ex) {
				// System.out.println("Error while closing the CallableStatement: " + ex.getMessage());
				ex.printStackTrace();
			}
		}
	}




}
