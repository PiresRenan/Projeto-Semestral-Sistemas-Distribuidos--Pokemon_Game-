package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataBaseMethods{
	
	Connection c;
	
	public DataBaseMethods() {
		try {
			c = ConnDB.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertUserPokemon(Pokemon p, String owner) throws SQLException {
        String sql = "INSERT INTO userpokemons (owner, pokemon, type, abilities, hp, att, def, special_att, special_def, spd) VALUES (?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setString(1, owner);
        statement.setString(2, p.getName());
        statement.setString(3, p.getType());
        statement.setString(4, p.getAbilities());
        statement.setInt(5, p.getHp());
        statement.setInt(6, p.getAtt());
        statement.setInt(7, p.getDef());
        statement.setInt(8, p.getSpecial_att());
        statement.setInt(9, p.getSpecial_def());
        statement.setInt(10, p.getSpd());
        int rowsInserted = statement.executeUpdate();
        return (rowsInserted > 0);
    }

	public static void deletePokemon(String nome_p, String owner) throws SQLException{
		Connection c = ConnDB.getConnection(); 
		String sql = "DELETE FROM userpokemons WHERE pokemon=? and owner=?;";
		PreparedStatement st = c.prepareStatement(sql);
		st.setString(1, nome_p);
		st.setString(2, owner);
		st.executeQuery();
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
	
	public Pokemon searchPokemon(String name) throws SQLException{
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
			return p;
		}
		return null;
	}
	
	public static Pokemon searchPokemonUser(String name) throws SQLException{
		Connection c = ConnDB.getConnection(); 
        String sql = "SELECT * FROM userpokemons WHERE owner LIKE ?;";
        PreparedStatement statement = c.prepareStatement(sql);
		statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        while(result.next()) {
            Pokemon p = new Pokemon(
                    result.getInt(1),
                    result.getString(2), 
                    result.getString(3), 
                    result.getString(4), 
                    result.getString(5), 
                    result.getInt(6), 
                    result.getInt(7), 
                    result.getInt(8), 
                    result.getInt(9), 
                    result.getInt(10),
                    result.getInt(11)
                    );
            System.out.println(p.toString());
			return p;
        }
        return null;
    }

	public static void upgradePokemon(Pokemon p, String attribute, int valor) throws SQLException{
		String sql = "";
		Connection c = ConnDB.getConnection(); 
		switch (attribute) {
			case "hp":
				p.setHp(p.getHp() +valor);
				sql = "UPDATE userpokemons SET hp=? WHERE id=?;";
				break;
			case "att":
				p.setAtt(p.getAtt() + valor);
				sql = "UPDATE userpokemons SET att=? WHERE id=?;";
				break;
			case "def":
				p.setDef(p.getDef() + valor);
				sql = "UPDATE userpokemons SET def=? WHERE id=?;";
				break;
			case "special_att":
				p.setSpecial_att(p.getSpecial_att() + valor);
				sql = "UPDATE userpokemons SET Special_att=? WHERE id=?;";
				break;
			case "special_def":
				p.setSpecial_def(p.getSpecial_def() + valor);
				 sql = "UPDATE userpokemons SET special_def=? WHERE id=?;";
				break;
			case "special_sdp":
				p.setSpd(p.getSpd() + valor);
				 sql = "UPDATE userpokemons SET spd=? WHERE id=?;";
				break;
		}
		PreparedStatement statement = c.prepareStatement(sql);
		statement.setInt(1, p.getAtt());
		statement.setInt(2, p.getId());
		statement.executeUpdate();
		JOptionPane.showMessageDialog(null, "Atributos crescesceram rapa");
	}
	
	public static Pokemon searchPokemonID(int id) throws SQLException{
		Connection c = ConnDB.getConnection(); 
        String sql = "SELECT * FROM pokes WHERE id=?;";
        PreparedStatement statement = c.prepareStatement(sql);
        statement.setInt(1, id);
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
            return p;
        }
        return null;
    }

	public static void capturarPokemon(Pokemon pokemon, String user) throws SQLException {
		Connection c = ConnDB.getConnection();
	    String sql = "INSERT INTO userpokemons (owner, pokemon, type, abilities, hp, att, def, special_att, special_def, spd) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	    PreparedStatement st = c.prepareStatement(sql);
		st.setString(1, user);
		st.setString(2, pokemon.getName());
		st.setString(3, pokemon.getType());
		st.setString(4, pokemon.getAbilities());
		st.setInt(5, pokemon.getHp());
		st.setInt(6, pokemon.getAtt());
		st.setInt(7, pokemon.getDef());
		st.setInt(8, pokemon.getSpecial_att());
		st.setInt(9, pokemon.getSpecial_def());
		st.setInt(10, pokemon.getSpd());
	    int i = st.executeUpdate();

		if (i > 0) {
			JOptionPane.showMessageDialog(null, "Parabéns, você encontrou um " + pokemon.getName());
		}else {
			JOptionPane.showMessageDialog(null, "Ops, o pokemon fugiu.");
		}

	}
	
	public boolean updatePokemon(String where, String value, String actualValue) throws SQLException {
	    String sql = "UPDATE `pokemons`.`pokes` SET `"+where+"` = ? WHERE (`id` = ?);";
	    PreparedStatement statement = c.prepareStatement(sql);
	    statement.setString(1, value);
	    statement.setString(2, actualValue);
	    statement.executeUpdate();
	    return true;
	}
	
	public boolean deletePokemon(int id) throws SQLException{
	    String sql = "DELETE FROM pokes WHERE id=?";
	    PreparedStatement statement = c.prepareStatement(sql);
	    statement.setInt(1, id);
	    statement.executeUpdate();
		return true;
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
	
	public static Users findUserByEmail(String email) throws SQLException{
        Connection conn = ConnDB.getConnection();
        String sql = "SELECT * FROM users WHERE email=?;";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, email);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            Users user = new Users(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3), 
                    result.getString(4),  
                    result.getInt(5),
                    result.getInt(6)
                    );
            return user;
        }
        return null;
    }
	
	public static void updateUser(String query) throws SQLException{
	    Connection conn = ConnDB.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.executeUpdate();
        JOptionPane.showMessageDialog(null, "Alterado com sucesso");
    }
	
	public static Users findUser(String name, String password) throws SQLException{
	    Connection conn = ConnDB.getConnection();
		String sql = "SELECT * FROM users WHERE name=? and password=?;";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, name);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			Users user = new Users(
			        result.getInt(1),
					result.getString(2), 
					result.getString(3), 
					result.getString(4), 
					result.getInt(5),
					result.getInt(6)
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
	
	public static void deleteUser(String query){
	    Connection c = ConnDB.getConnection(); 
		PreparedStatement st;
        try {
            st = c.prepareStatement(query);
            st.execute();
            JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public static void findPokemonsUsers(String name) throws SQLException {
	    String query = "SELECT * FROM userpokemons WHERE owner=?";
	    Connection c = ConnDB.getConnection(); 
	    PreparedStatement st = c.prepareStatement(query);
	    st.setString(1, name);
	    ResultSet result = st.executeQuery();
	    if(result.next()) {
	        Pokemon pokemon = new Pokemon(
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
	        System.out.println(result);
	    }
	}
}
