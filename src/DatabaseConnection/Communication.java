
package DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class Communication {
    public void addToDatabase(String SQL) {

        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien
        // deze voor jou anders is.
        String connectionUrl = "jdbc:sqlserver://LAPTOP-2V91QL0I;databaseName=ProgRDB;integratedSecurity=true;";

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;

        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

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
    }

    public ArrayList<String> getListFromDatabase(String SQL, String column) {

        // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien
        // deze voor jou anders is.
        String connectionUrl = "jdbc:sqlserver://LAPTOP-Q21ELVRV;databaseName=ProgRDB;integratedSecurity=true;";

        // Connection beheert informatie over de connectie met de database.
        Connection con = null;

        // Statement zorgt dat we een SQL query kunnen uitvoeren.
        Statement stmt = null;

        // ResultSet is de tabel die we van de database terugkrijgen.
        // We kunnen door de rows heen stappen en iedere kolom lezen.
        ResultSet rs = null;
        ArrayList<String> variables = new ArrayList<>();
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String variable = rs.getString(column);
                variables.add(variable);
                
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
        return variables;
    }
}
