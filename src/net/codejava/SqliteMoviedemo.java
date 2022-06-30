package net.codejava;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.*;


public class SqliteMoviedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl = "jdbc:sqlite:/C:\\Users\\J.Gowrishankar\\Desktop\\db\\movidb.db";
		try {
			Connection connection=DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM movies";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				String name=result.getString("name");
				String actor=result.getString("actor");
				String actress=result.getString("actress");
				String director=result.getString("director");
				String year=result.getString("year");
				
				System.out.println(name+" | "+actor+" | "+actress+" | "+director+" | "+year);
				
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			String sqlcon1 = "SELECT name FROM movies WHERE actor='Rajinikanth';";
			Statement statementcon1 = connection.createStatement();
			ResultSet resultcon1 = statementcon1.executeQuery(sqlcon1);
			while(resultcon1.next()) {
				String name=resultcon1.getString("name");				
				System.out.println(name);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting to SQLite Database");
			e.printStackTrace();
		}

	}

}
