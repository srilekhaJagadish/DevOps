
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidateLogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ValidateLogin1() {
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String uname=request.getParameter("username");  
		String psw=request.getParameter("password"); 

		RemoteConnection object = new RemoteConnection();

		Connection con = null;

		
		Statement st = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String db_userid = null;
		String db_user = null;
		if(uname==null || psw== null || uname=="" || psw == "")
			out.print("<h1> Access Denied</h1>");
		else
			try {
				con = object.getRemoteConnection();
				System.out.println("con :"+ con);
				st = con.createStatement();
				System.out.println("statement : "+st);
				String sqlQuery = "select ID, NAME, PASSWORD from UserLogin where NAME= '"+uname+"' and PASSWORD= '"+psw+"'";	
				rs = st.executeQuery(sqlQuery);

				while(rs.next()){
					//Retrieve by column name
					db_userid  = rs.getString(1);
					db_user = rs.getString(2);


				}
				if(db_userid==null || db_user== null || db_userid=="" || db_userid== "")
					out.print("<h1> Access Denied</h1>");
				else{
					String sqlQuery1 = "select ID, SUBJECT, MARKS, CREDITS from CampusResults where USERID= '"+db_userid+"'";	
					rs1 = st.executeQuery(sqlQuery1);

					out.print("<table align = center border='1'> <tr><th>S.NO</th> <th>Subject</th> <th>Marks</th><th>Credits</th></tr>");
					while(rs1.next()){
						int id = rs1.getInt(1);
						String subject = rs1.getString(2);
						String marks = rs1.getString(3);
						String credits = rs1.getString(4);

						out.print(" <tr> <td>"+id+" </td>"
								+ "<td>"+subject+"</td>"
								+ "<td>"+marks+"</td>"
								+ "<td>"+credits+"</td></tr> ");
					}

					out.print("</table>"); }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				RemoteConnection.closeResultSet(rs);
				RemoteConnection.closeStatement(st);
				RemoteConnection.closeConnection(con);
			} 
	}



}




