package FrameWork.helpers;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RetrieveData {
	static Connection connection = null;
	static Statement statement = null;
	public static ResultSet resultSet = null;

	public static String msAccDB = System.getProperty("user.dir") + "\\GIB_eCorp\\runManager\\MasterTestDb.accdb";
	public static String dbURL = "jdbc:ucanaccess://" + msAccDB;

	public static ResultSet getDbdata(String query) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");


			// Step 2.A: Create and get connection using DriverManager class
			connection = DriverManager.getConnection(dbURL);

			// Step 2.B: Creating JDBC Statement
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			// Step 2.C: Executing SQL &amp; retrieve data into ResultSet
			resultSet = statement.executeQuery(query);
			statement.close();


			connection.close();

			return resultSet;
		} catch (Exception e) {
			e.getMessage();
		}
		return resultSet;
	}


	public static ResultSet update(String query) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");


			// Step 2.A: Create and get connection using DriverManager class
			connection = DriverManager.getConnection(dbURL);

			// Step 2.B: Creating JDBC Statement
			statement = connection.createStatement();


			// Step 2.C: Executing SQL &amp; retrieve data into ResultSet
			int up = statement.executeUpdate(query);
			System.out.println(up + " data get  updated!!!!!");
			statement.close();


			connection.close();

			//return resultSet;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public static void updateResult(String testcaseID, String testdesc, String databinding, String startTime, String endTime, String logstatus, String remarks) {


		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			connection = DriverManager.getConnection(dbURL);


			statement = connection.createStatement();

			String query = "insert  into ResultLogger (TestCaseID,TestDescription,DataBinder,StartTime,EndTime,ExceutionStatus,Remarks) values ('" + testcaseID + "','" + testdesc + "','" + databinding + "','" + startTime + "','" + endTime + "','" + logstatus.toUpperCase() + "','" + remarks + "')";
			System.out.println(query);
			int s = statement.executeUpdate(query);
			System.out.println(s + " row inserted!!!");


		} catch (Exception e) {
			e.getMessage();

		}
	}

	public static void Updateinsert(String Query) {


		try {

			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");

			connection = DriverManager.getConnection(dbURL);


			statement = connection.createStatement();

			//String query = "insert  into Result (TestCaseID,TestDescription,StartTime,EndTime,ExceutionStatus,Remarks) values ('" + testcaseID + "','" + testdesc + "','" + startTime + "','" + endTime + "','" + logstatus.toUpperCase() + "','"+remarks+"')";
			System.out.println(Query);
			int s = statement.executeUpdate(Query);
			System.out.println(s + " row reflected!!!");


		} catch (Exception e) {
			e.getMessage();

		}
	}
}
