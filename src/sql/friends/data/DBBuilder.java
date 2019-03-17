package sql.friends.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DBBuilder {
	String url = "jdbc:derby://localhost:1527/mydata4";

	public void Database() {
		String table = JOptionPane.showInputDialog("enter table name to create");
		String sql = "create table " + table + "(id int primary key, name varchar(12), city varchar(20),age int)";
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("table " + table + " created successfully");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
