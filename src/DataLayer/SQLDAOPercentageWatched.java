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
import person.PercentageWatched;
import person.Student;
import products.Course;

public class SQLDAOPercentageWatched implements DAOPercentageWatched {

    private String connectionUrl;

    public SQLDAOPercentageWatched(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    @Override
    public List<PercentageWatched> findPercentageWatched() {
        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;
        List<PercentageWatched> watched = new ArrayList<>();
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery("SELECT * FROM PercentageWatched");

            while (rs.next()) {
                int percentage = rs.getInt("Percentage");
                String email = rs.getString("Email");
                int contenItemId = rs.getInt("ContentItemId");
                watched.add(new PercentageWatched(percentage, email, contenItemId));

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
        return watched;
    }

    @Override
    public boolean updatePercentageWatched(PercentageWatched percentageWatched) {
        boolean answer;
        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            stmt.execute("Update PercentageWatched SET Percentage = " + percentageWatched.getPercentage() + " WHERE Email='" + percentageWatched.getEmail() + "' AND ContentItemId='" + percentageWatched.getContentItemId() + "'");
            answer = true;
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            answer = false;
            e.printStackTrace();
        } finally {
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
        return answer;
    }

    @Override
    public boolean addPercentageWatched(PercentageWatched percentageWatched) {
        boolean answer;
        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.

            stmt.execute("INSERT INTO PercentageWatched VALUES(" + percentageWatched.getPercentage() + ",'" + percentageWatched.getEmail() + "'," + percentageWatched.getContentItemId() + ")");
            answer = true;
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            answer = false;
            e.printStackTrace();
        } finally {
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
        return answer;
    }

}
