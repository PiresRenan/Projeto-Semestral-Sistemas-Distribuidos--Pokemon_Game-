package presenter;

import java.sql.SQLException;
import model.DataBaseMethods;
import model.Users;
import view.AdmWindow;


public class LoginAuths {
    
    
    public static boolean getAuth(String username, String password) throws SQLException {
        if (DataBaseMethods.findUser(username, password) != null) {
            Users user = DataBaseMethods.findUser(username, password);
            switch (user.getType()) {
                case 0:
                    
                    break;
                case 1:
                    AdmUser admUser = new AdmUser();
                    break;
                default:
                    break;
            } 
            return true;
        }
        return false;
    }
}
