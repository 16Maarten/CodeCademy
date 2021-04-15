/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import products.Module;

public class SQLDAOModule implements DAOModule {

    private String connectionUrl;

    public SQLDAOModule(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    @Override
    public List<Module> findModule() {
        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        Statement stmt2 = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<Module> modules = new ArrayList<>();
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            stmt2 = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery("SELECT * FROM Module");

            while (rs.next()) {
                double version = rs.getDouble("Version");
                String contactPersonName = rs.getString("ContactPersonName");
                String contactPersonEmail = rs.getString("ContactPersonEmail");
                int orderNumber = rs.getInt("OrderNumber");
                int contentItemId = rs.getInt("ContentItemId");
                rs2 = stmt2.executeQuery("SELECT * FROM ContentItem WHERE ContentItemId =" + contentItemId);
                //System.out.println("SELECT * FROM ContentItem WHERE ContentItemId =" + contentItemId);
                Date publicationDate = null;
                String status = "";
                String title = "";
                String description ="";
                String cursusName = "";
                while (rs2.next()) {
                    publicationDate = rs2.getDate("PublicationDate");
                    status = rs2.getString("Status");
                    title = rs2.getString("Title");
                    description = rs2.getString("Description");
                    cursusName = rs2.getString("CursusName");
                }
                modules.add(new Module(version,contactPersonName, contactPersonEmail, orderNumber, contentItemId, publicationDate, status, title, description, cursusName));
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null)
                try {
                rs.close();
            } catch (Exception e) {
            }
            if (stmt != null)
                try {
                stmt.close();
            } catch (Exception e) {
            }
            if (con != null)
                try {
                con.close();
            } catch (Exception e) {
            }
        }
        return modules;
    }

}
