package org.example1;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {

    private String url;
    private String user;
    private String password;
    private java.sql.Connection con;



    public Connection(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // Kam perdorur metode boolean qe te ktheje true ose false ne varesi te lidhjes
    //si fillim eshte ne rregull por e tille nuk mund ta perdor si Connection pasi nuk e kthen si te tille
    //nuk po e bej qe te ktheje connection por po shtoj nje metode tjt
    public boolean connect() {
        try {

            con = DriverManager.getConnection(url, user, password);
            return true;

        } catch (SQLException e) {

            e.printStackTrace();
            return false;
        }
    }

    public java.sql.Connection getConnection() {
        return con;
    }
}
