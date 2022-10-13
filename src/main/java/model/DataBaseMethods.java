package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseMethods{
	
	Connection c;
	
	public DataBaseMethods() {
		try {
			c = ConnDB.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertPokemon(Pokemon p) throws SQLException {
		String sql = "INSERT INTO pokes (name, type, abilities, hp, att, def, special_att, special_def, spd) VALUES (?,?,?,?,?,?,?,?,?);";
		PreparedStatement statement = c.prepareStatement(sql);
		statement.setString(1, p.getName());
		statement.setString(2, p.getType());
		statement.setString(3, p.getAbilities());
		statement.setInt(4, p.getHp());
		statement.setInt(5, p.getAtt());
		statement.setInt(6, p.getDef());
		statement.setInt(7, p.getSpecial_att());
		statement.setInt(8, p.getSpecial_def());
		statement.setInt(9, p.getSpd());
		int rowsInserted = statement.executeUpdate();
		return (rowsInserted > 0);
	}
	
	public String searchPokemon(String name) throws SQLException{
		String sql = "SELECT * FROM pokes WHERE name=?;";
		PreparedStatement statement = c.prepareStatement(sql);
		statement.setString(1, name);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			Pokemon p = new Pokemon(
					result.getInt(1),
					result.getString(2), 
					result.getString(3), 
					result.getString(4), 
					result.getInt(5), 
					result.getInt(6), 
					result.getInt(7), 
					result.getInt(8), 
					result.getInt(9), 
					result.getInt(10)
					);
			return p.toString();
		}
		return "Pokemon não encontrado";
	}
	
	public boolean updatePokemon(String where, String value, String actualValue) throws SQLException {
		String sql = "";
		int updated = 0;
		switch (where) {
		case "id":
			sql = "UPDATE pokes SET id=? WHERE id=?;";
			PreparedStatement statement = c.prepareStatement(sql);
			int int_value = Integer.parseInt(value);
			int int_actualValue = Integer.parseInt(actualValue);
			statement.setInt(1, int_value);
			statement.setInt(2, int_actualValue);
			System.out.println(sql);
			updated = statement.executeUpdate();
			return (updated > 0);
		case "name":
			System.out.println("To aqui");
			sql = "UPDATE pokes SET name=? WHERE name=?;";
			statement = c.prepareStatement(sql);
			statement.setString(1, value);
			statement.setString(2, actualValue);
			System.out.println(sql);
			updated = statement.executeUpdate();
			return (updated > 0);
		default:
			break;
		}
		return (updated > 0);
	}
	
	public boolean deletePokemon(String name) throws SQLException{
		return false;
	}
	
	public boolean newUser(Users user) throws SQLException {
		String sql = "INSERT INTO users (name, email, password, type, age) VALUES (?,?,?,?,?);";
		PreparedStatement statement = c.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());
		statement.setInt(4, user.getType());
		statement.setInt(5, user.getAge());
		int rowsInserted = statement.executeUpdate();
		return (rowsInserted > 0);
	}
	
	public Users findUser(String name, String password) throws SQLException{
		String sql = "SELECT * FROM users WHERE name=? and password=?;";
		PreparedStatement statement = c.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			Users user = new Users(
					result.getString(1), 
					result.getString(2), 
					result.getString(3), 
					result.getInt(4), 
					result.getInt(5)
					);
			return user;
		}
		return null;
	}
	
	public boolean changePassword(String email, String new_password) throws SQLException{
		String sql = "UPDATE users SET password=? WHERE email=?;";
		PreparedStatement statement = c.prepareStatement(sql);
		statement.setString(1, new_password);
		statement.setString(2, email);
		int updated = statement.executeUpdate();
		return (updated > 0);
	}
	
	public boolean deleteUser(int id) throws SQLException{
		String sql = "DELETE FROM users WHERE id=?";
		return false;
	}
}