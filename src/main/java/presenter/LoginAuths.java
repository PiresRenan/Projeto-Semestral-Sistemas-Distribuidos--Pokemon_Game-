package presenter;

import java.sql.SQLException;
import model.DataBaseMethods;
import model.Users;
import view.AdmWindow;
import view.UserWindow;


public class LoginAuths {
    
    
    public static boolean getAuth(String username, String password) throws SQLException {
        if (DataBaseMethods.findUser(username, password) != null) {
            Users user = DataBaseMethods.findUser(username, password);
            switch (user.getType()) {
                case 0:
                    UserWindow normalUser = new UserWindow();
                    break;
                case 1:
                    AdmWindow a = new AdmWindow(user);
                    break;
                default:
                    break;
            } 
            return true;
        }
        return false;
    }
    
}
