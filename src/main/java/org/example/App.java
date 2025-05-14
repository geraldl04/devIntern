package org.example;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String url = "jdbc:postgresql://localhost:5432/Dev-Intern";
        String user = "postgres";
        String password = "Geraldi2004";

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stat = conn.createStatement() ;
            ResultSet result = stat.executeQuery("SELECT * FROM student");

            while(result.next()) {
                System.out.println( " Emri : " + result.getString("emri") + "  Emaili :" + result.getString("emaili"));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection(url, user, password)) {

            DatabaseMetaData dbmd = conn.getMetaData() ;
            ResultSet tables = dbmd.getTables(null, null, "%", new String[] {"TABLE"});

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Tabelat : " + tableName);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }


        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stat = conn.createStatement() ;
            ResultSet result = stat.executeQuery("SELECT * FROM student WHERE pike > 10 ");

            while(result.next()) {
                System.out.println( " Emri : " + result.getString("emri") + " Piket:" + result.getInt("pike") );
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stat = conn.createStatement() ;
            int rezultati = stat.
                    executeUpdate(" INSERT INTO student (emri,emaili) VALUES ('Geraldddd','ShtuarNgaLidhja'); ");

            if(rezultati>0) {

                ResultSet rs = stat.executeQuery("SELECT * FROM student WHERE emaili = 'ShtuarNgaLidhja' ");
                while(rs.next()) {
                    System.out.println( " Emri : " + rs.getString("emri") + ":" + rs.getString("emaili") );
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }


        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement stat = conn.createStatement() ;

            ResultSet result1 = stat.executeQuery("SELECT * FROM student WHERE emri = 'Mirsalda' ");

            while(result1.next()) {
                System.out.println( " Emri : " + result1.getString("emri") + " Piket:" + result1.getInt("pike") );
            }
            int rezultati = stat.
                    executeUpdate("UPDATE student SET pike = 30 WHERE emri = 'Mirsalda' ");


            if(rezultati>0) {
                ResultSet rs = stat.executeQuery("SELECT * FROM student WHERE emri = 'Mirsalda' ");
                while(rs.next()) {
                    System.out.println( " Emri : " + rs.getString("emri") + " Piket " + rs.getString("pike") );
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String sql = "DELETE FROM student WHERE emri = ?";

            try (PreparedStatement stat = conn.prepareStatement(sql)) {
                stat.setString(1, "Sara"); //zevendeson ? e pare me sara , se mund te ndodhe
            //te kemi disa ? ne query
                int rezultati = stat.executeUpdate();

                if (rezultati > 0) {
                    System.out.println(" Sara u fshi .");
                } else {
                    System.out.println("Nuk u gjet student me emrin Sara");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
