package MVPPresenters;

import MVPModels.DataBaseModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static MVPPresenters.OutputPresenter.*;

public class DataBasePresenter {
    private static final String url = DataBaseModel.GetUrl();
    private static final String login = DataBaseModel.GetLogin();
    private static final String password = DataBaseModel.GetPassword();
    private static Connection Session = null;

    public static void CheckDataBaseConnection(){
        try {
            Connect();
            SQL_TestConnectivity();
            Disconnect();
        } catch (SQLException | ClassNotFoundException e) {
            DisplayError("Ops !! You can't connect to the DataBase @Error\n");
            System.exit(1);
        }
    }
    public static void Connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Session = DriverManager.getConnection(url,login,password) ;
    }
    private static void SQL_TestConnectivity() throws SQLException {
        String query = "SELECT * FROM user;";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
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

    public static String[] GetMediaList() throws SQLException, ClassNotFoundException {
        String[] mediaList;
        Connect();
        mediaList = SQL_GetMediaList();
        Disconnect();
        return mediaList;
    }
    private static String[] SQL_GetMediaList() throws SQLException {
        String query = "SELECT Name FROM media;";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
        return ConvertMediaListToStringArray(dataSet);
    }
    private static String[] ConvertMediaListToStringArray(ResultSet DataSet) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        while (DataSet.next()) { dataList.add(DataSet.getString(1)); }

        String[] dataStringArray = new String[dataList.size()];
        dataList.toArray(dataStringArray);
        return dataStringArray;
    }

    public static String[] GetMediaDescription(String itemName) throws SQLException, ClassNotFoundException {
        Connect();
        String[] ItemDescription = SQL_GetItemDescription(itemName);
        Disconnect();
        return ItemDescription;
    }
    private static String[] SQL_GetItemDescription(String itemName) throws SQLException {
        String query = "SELECT Type, UploadDate, Location FROM media WHERE Name='" + itemName + "';";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
        return ConvertItemDescriptionToStringArray(dataSet);
    }
    private static String[] ConvertItemDescriptionToStringArray(ResultSet dataSet) throws SQLException {
        List<String> dataList = new ArrayList<String>();
        int i = 1;
        if (dataSet.next()) {
            int dataSetSize = dataSet.getMetaData().getColumnCount();
            while (i <= dataSetSize) { dataList.add(dataSet.getString(i++)); }

            String[] dataStringArray = new String[dataList.size()];
            dataList.toArray(dataStringArray);
            return dataStringArray;
        }
        return new String[4];
    }

    public static void AddMedia(String[] mediaData) throws SQLException, ClassNotFoundException {
        Connect();
        SQL_AddMedia(mediaData);
        Disconnect();
    }
    private static void SQL_AddMedia(String[] mediaData) throws SQLException {
        System.out.println(mediaData[3]);
        String query = "INSERT INTO media(Name, Type, UploadDate, Location) " +
                "VALUES ('" + mediaData[0] + "', '" + mediaData[1] + "'," +
                "'" + mediaData[2] + "', '" + mediaData[3] + "');";
        Session.createStatement().executeUpdate(query);
    }

    public static void EditMedia(String mediaName, String newMediaName) throws SQLException, ClassNotFoundException {
        Connect();
        int id = SQL_GetMediaID(mediaName);
        SQL_EditMedia(id, newMediaName);
        Disconnect();
    }
    private static int SQL_GetMediaID(String mediaName) throws SQLException {
        String query = "SELECT ID FROM media WHERE Name = '" + mediaName + "';";
        ResultSet dataSet = Session.createStatement().executeQuery(query);
        dataSet.next();
        return dataSet.getInt(1);
    }
    private static void SQL_EditMedia(int mediaID, String newMediaName) throws SQLException {
        String query = "UPDATE media SET Name='" + newMediaName + "' WHERE ID='" + mediaID +"';";
        Session.createStatement().executeUpdate(query);
    }

    public static void DeleteMedia(String mediaName) throws SQLException, ClassNotFoundException {
        Connect();
        SQL_DeleteMedia(mediaName);
        Disconnect();
    }
    private static void SQL_DeleteMedia(String mediaName) throws SQLException {
        String query = "DELETE FROM media WHERE Name='" + mediaName + "';";
        Session.createStatement().executeUpdate(query);
    }

    public static class UserNotFoundException extends Exception { UserNotFoundException(String s){ super(s);}}
    public static class UserAlreadyExistException extends Exception { UserAlreadyExistException(String s){ super(s);}}
}
