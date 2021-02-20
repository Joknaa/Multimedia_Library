package MVPPresenters;

import MVPModels.DataBaseModel;

import javax.swing.*;
import java.sql.*;

import static MVPPresenters.OutputPresenter.DisplayMessage;

public class DataBasePresenter {
    public static void Connect(){
        String url = DataBaseModel.GetUrl();
        String login = DataBaseModel.GetLogin();
        String password = DataBaseModel.GetPassword();

        try {
            Connection Session = DriverManager.getConnection(url,login,password) ;
            Statement stmt = Session.createStatement();
            String query = "SELECT * FROM schema001.user ";
            ResultSet QueriedData = stmt.executeQuery(query);
            if ( QueriedData.next() ) {
                JOptionPane.showMessageDialog(null,
                        "La base de donn\u00E9es est charg\u00E9 avec succ�s !",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Probl�me du chargement de la base de donnees !\n" +
                            "Veuillez demarrez le serveur mysql avant de lancer l'application\n" + e.getMessage(),
                    "Erreur", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }

    }
    public static void Disconnect(){ DisplayMessage("Disconnecting from DB"); }
    public static void Authenticate(){ DisplayMessage("Authentication ... "); }


}
