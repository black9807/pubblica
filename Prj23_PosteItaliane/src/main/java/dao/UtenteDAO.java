package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Utente;

public class UtenteDAO {
	
	private Connessione connessione = new Connessione();
	private Connection conn = connessione.getConn();
	
	private Statement stat;
	private ResultSet rs;
	
	public void addUtente(Utente u) {
		
		String nome = u.getNome();
		String username = u.getUsername();
		String psw = u.getPsw();
		
		String query = "insert into utenteposte values ('" + username + "', '"
				+ nome + "', '" + psw + "')";
		
		try {
			
			this.stat = this.conn.createStatement();
			this.stat.execute(query);
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}
	
	public ArrayList<Utente> getUtenti() {

		String query = "select * from utenteposte";
		ArrayList<Utente> temp = new ArrayList<>();

		try {

			stat = conn.createStatement();
			rs = stat.executeQuery(query);

			while (rs.next()) { 
				
				String nome = rs.getString("nome");
				String username = rs.getString("username");
				String psw = rs.getString("psw");

				temp.add(new Utente(nome, username, psw));
				
			}

		} catch (SQLException e) {

			System.err.println("Si è verificato un errore " + e.getMessage());

		}

		return temp;

	}
	
}
