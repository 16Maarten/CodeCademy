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
import person.Registration;


public class SQLDAORegistration implements DAORegistration{
    private String connectionUrl;

    public SQLDAORegistration(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }
    

    @Override
    public List<Registration> findRegistration() {
        // Connection beheert informatie over de connectie met de database.
        Connection con = null;
        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;
        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;
        List<Registration> registrations = new ArrayList<>();
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery("SELECT * FROM Registration");

            while (rs.next()) {
                Date registrationDate = rs.getDate("RegistrationDate");
                String email = rs.getString("Email");
                String cursusName = rs.getString("CursusName");
                registrations.add(new Registration(registrationDate,email,cursusName));
                
            }
        }

        // Handle any errors that may have occurred.
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
        return registrations;
    }

    @Override
    public boolean deleteRegistration(Registration registration) {
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
            stmt.execute("Delete FROM Registration WHERE CursusName='" + registration.getCursusName() + "' AND Email='"+registration.getEmail()+"' AND RegistrationDate='"+registration.getRegistrationDate()+"'");
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
