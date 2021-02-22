package MVPPresenters;

import MVPModels.DataBaseModel;
import static javax.swing.JOptionPane.*;
import java.sql.*;

public class DataBasePresenter {
    private static final String url = DataBaseModel.GetUrl();
    private static final String login = DataBaseModel.GetLogin();
    private static final String password = DataBaseModel.GetPassword();
    private static Connection Session = null;

    public static void CheckDataBaseConnection(){
        try {
            Connect();
            Statement stmt = Session.createStatement();
            String query = "SELECT * FROM user;";
            ResultSet QueriedData = stmt.executeQuery(query);
            Disconnect();
        } catch (SQLException | ClassNotFoundException e) {
            showMessageDialog(null, "Ops !! You can't connect to the DataBase\n" + e,
                    "Erreur", ERROR_MESSAGE);
            System.exit(1);
        }
    }
    public static void Connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Session = DriverManager.getConnection(url,login,password) ;
    }
    public static void Disconnect() throws SQLException {
        if (Session != null){
            Session.close();
            Session = null;
        }
    }

    public static void SignUp(String login, String password) throws SQLException, ClassNotFoundException, UserAlreadyExistException {
            Connect();
            SQL_Check_LoginAvailable(login);
            SQL_SignUp(login, password);
            Disconnect();
    }
    private static void SQL_Check_LoginAvailable(String login) throws SQLException, UserAlreadyExistException {
        String query = "SELECT * FROM user WHERE Username='" + login + "';";
        ResultSet rt = Session.createStatement().executeQuery(query);
        if (rt.next()) throw new UserAlreadyExistException("login already exist @Error");
    }
    private static void SQL_SignUp(String login, String password) throws SQLException {
        String query = "INSERT INTO user(username, password) VALUES ('" + login + "', '" + password + "');";
        Session.createStatement().executeUpdate(query);
    }

    public static void SignIn(String login, String password) throws SQLException, ClassNotFoundException, UserNotFoundException {
            Connect();
            SQL_Check_UserExist(login, password);
            SignIn(login);
            Disconnect();
    }
    private static void SQL_Check_UserExist(String login, String password) throws SQLException, UserNotFoundException {
        String query = "SELECT * FROM user WHERE Username='" + login + "' AND Password='" + password + "';";
        ResultSet rt = Session.createStatement().executeQuery(query);
        if (!rt.isBeforeFirst()){
            throw new UserNotFoundException("Login or Password Incorrect @Error");
        }
    }
    private static void SignIn(String login) { UserPresenter.SetCurrentUser(login); }

    public static class UserNotFoundException extends Exception { UserNotFoundException(String s){ super(s);}}
    public static class UserAlreadyExistException extends Exception { UserAlreadyExistException(String s){ super(s);}}
}
