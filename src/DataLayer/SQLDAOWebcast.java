/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import products.Webcast;

public class SQLDAOWebcast implements DAOWebcast {

    private String connectionUrl;

    public SQLDAOWebcast(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    @Override
    public List<Webcast> findWebcast() {
        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        Statement stmt2 = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;
        ResultSet rs2 = null;
        List<Webcast> webcasts = new ArrayList<>();
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(this.connectionUrl);

            stmt = con.createStatement();
            stmt2 = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery("SELECT * FROM Webcast");

            while (rs.next()) {
                String duration = rs.getString("Duration");
                String url = rs.getString("URL");
                String expertName = rs.getString("ExpertName");
                String expertOrganisation = rs.getString("ExpertOrganisation");
                int contentItemId = rs.getInt("ContentItemId");
                rs2 = stmt2.executeQuery("SELECT * FROM ContentItem WHERE ContentItemId =" + contentItemId);
                Date publicationDate = null;
                String status = "";
                String title = "";
                String description = "";
                String cursusName = "";
                while (rs2.next()) {
                    publicationDate = rs2.getDate("PublicationDate");
                    status = rs2.getString("Status");
                    title = rs2.getString("Title");
                    description = rs2.getString("Description");
                    cursusName = rs2.getString("CursusName");
                }
                webcasts.add(new Webcast(duration, url, expertName, expertOrganisation, contentItemId, publicationDate, status, title, description, cursusName));
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
        return webcasts;
    }

}
