package sql.friends.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class FriendDAO implements Friendint {

//	int id = Integer.parseInt(JOptionPane.showInputDialog("enter ID"));
//	String name = JOptionPane.showInputDialog("enter name");
	String name;
//	String city = JOptionPane.showInputDialog("enter city");
	String city;
//	int age = Integer.parseInt(JOptionPane.showInputDialog("enter age"));
	int age;
	String table = "friends";
	String url = "jdbc:derby://localhost:1527/mydata4";
	Friend friend = new Friend();
	int n = JOptionPane.YES_OPTION;

	@Override

	public void AddFriend() {
		while (n == JOptionPane.YES_OPTION) {
			String sql = "insert into friends values(" + Integer.parseInt(JOptionPane.showInputDialog("enter ID"))
					+ ",'" + JOptionPane.showInputDialog("enter name") + "','"
					+ JOptionPane.showInputDialog("enter city") + "',"
					+ Integer.parseInt(JOptionPane.showInputDialog("enter age")) + ")";
			try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement();) {

				stmt.executeUpdate(sql);
				System.out.println("friend added successfully");
				n = JOptionPane.showConfirmDialog(null, "Would you like to add another friend?", "An Inane Question",
						JOptionPane.YES_NO_OPTION);

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,
						"An unexpected error has occurred:\n" + e.getMessage() + '\n'
								+ Thread.currentThread().getStackTrace()
								+ "\nPlease send this error to a.m7md.f@gmail.com." + "\nThanks for your help.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	@Override
	public Friend ReadFriend() {
		String sql = "select * from friends where id= " + Integer.parseInt(JOptionPane.showInputDialog("enter ID"));
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Friend friend = new Friend();
				friend.setId(rs.getInt("id"));
				friend.setName(rs.getString("name"));
				friend.setCity(rs.getString("city"));
				friend.setAge(rs.getInt("age"));
				return friend;
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

		return null;

	}

	@Override
	public Friend ReadAll() {

		String sql = "select * from " + table;
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.print("[id=");
				System.out.print(rs.getInt("id"));
				System.out.print(", name=");
				System.out.print(rs.getString("name"));
				System.out.print(", city=");
				System.out.print(rs.getString("city"));
				System.out.print(", age=");
				System.out.print(rs.getInt("age"));
				System.out.println("]");
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return friend;

	}

	@Override
	public void UpdateName() {

		String sql = "update friends set name= '" + JOptionPane.showInputDialog("enter name") + "'";
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("friend's name changed");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void UpdateCity() {

		String sql = "update friends set city= '" + JOptionPane.showInputDialog("enter new city to change") + "'";
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("friend city changed");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void UpdateAge() {

		String sql = "update friends set age= "
				+ Integer.parseInt(JOptionPane.showInputDialog("enter new age to change")) + "where id="
				+ Integer.parseInt(JOptionPane.showInputDialog("enter ID"));
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {

			stmt.executeUpdate(sql);
			System.out.println("friend age changed");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void DeleteFriend() {
		String sql = "delete from friends where id="
				+ Integer.parseInt(JOptionPane.showInputDialog("enter friend's ID to delete"));
		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("friend removed.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void DeleteAll() {
		String sql = "delete from " + table;

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("all friends removed.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	@Override
	public void DeleteTable() {
		String sql = "drop table " + table;

		try (Connection con = DriverManager.getConnection(url); Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println("table removed.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"An unexpected error has occurred:\n" + e.getMessage() + '\n'
							+ Thread.currentThread().getStackTrace() + "\nPlease send this error to a.m7md.f@gmail.com."
							+ "\nThanks for your help.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	}
}
