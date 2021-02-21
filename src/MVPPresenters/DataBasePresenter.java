package MVPPresenters;

import MVPModels.DataBaseModel;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;

import static javax.swing.JOptionPane.*;
import java.sql.*;
import java.util.Arrays;

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

    public static void Try_AddUser(String login, String password) {
        try {
            Connect();
            String query = "INSERT INTO user VALUES(,'" + login + "', '" + password + "');";
            int queryOutput = Session.createStatement().executeUpdate(query);
            System.out.println("query output: " + queryOutput);
            //OutputPresenter.DisplaySignUpConfirmation();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

}
