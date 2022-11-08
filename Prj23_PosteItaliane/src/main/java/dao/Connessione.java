package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connessione {

	private final String URL = "jdbc:mysql://localhost:3306/jato69";
	private final String USER = "app_java";
	private final String PASS = "java_2022!";

	private Connection conn = null;

	public Connection getConn() {
		
		if (conn == null) {
			
			connetti();
			
		}
		
		return conn;
		
	}

	private void connetti() {
		
		try { //passo la classe che contiene il driver sql
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {

			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connessione OK");

		} catch (SQLException e) {
			System.err.println("----------------------------------------------");
			System.err.println("Si è verificato un errore " + e.getMessage());
			System.err.println("----------------------------------------------");
//			e.printStackTrace();

		}

	}

	public void disconnetti() {

		if (conn != null) {

			try {

				conn.close();

			} catch (SQLException e) {

				e.printStackTrace();

			}

		} else {

			System.out.println("Sei già disconnesso");

		}

		System.out.println("Disconnesso");

	}
	
	public static void main(String[] args) {
		
		Connessione c = new Connessione();
		
		c.connetti();
		
	}

}