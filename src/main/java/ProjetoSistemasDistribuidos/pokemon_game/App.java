package ProjetoSistemasDistribuidos.pokemon_game;

import java.sql.SQLException;
import model.DataBaseMethods;
import model.Users;

public class App 
{
    public static void main( String[] args )
    {
        Users user = new Users("teste", "teste@email.com", "123456", 0, 1);
        DataBaseMethods a = new DataBaseMethods();
        try {
			System.out.println(a.changePassword("renan@email.com.br", "025213"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
    }
}
