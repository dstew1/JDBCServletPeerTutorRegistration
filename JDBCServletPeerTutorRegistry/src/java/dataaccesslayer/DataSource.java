/*
Student Name: Daniel Stewart    
Student Number: 041029499
Course & Section #: 23S_CST8288_021
Declaration:
This is my own original work and is free from Plagiarism.
*/

package dataaccesslayer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The DataSource class represents a database data source used to manage database connections
 * for the peer tutor application. It provides a single database connection throughout the
 * application to prevent memory leaks and inefficiencies.
 * 
 * @see java.sql.Connection
 * @see java.sql.DriverManager
 * @see java.sql.SQLException
 * 
 * @author Daniel Stewart
 * @version 1.0
 */
public class DataSource {

    private Connection connection = null;
    // TODO:  Initialize the url string variable properly.  No need to load the
    //        JDBC URL, username, and password from a properties file.
    private String url = "jdbc:mysql://localhost:3306/peertutor?useSSL=false&allowPublicKeyRetrieval=true";
    private String username = "root";
    private String password = "falconsAAA33";
    
    /**
     * Creates a new DataSource object
     */
    public DataSource() {
        
    }

    /**
     * Creates and provides a database connection using the JDBC driver. If a connection
     * already exists, this method returns the existing connection to prevent multiple
     * connections and potential memory leaks.
     *
     * @return the database connection established using the JDBC driver.
     */
    public Connection createConnection() {
        // TODO:  Add your code here.  Make sure to use try-catch statement.
        //        Make sure there is only one connection for this application
        //        to prevent memory leaks.

        try {
            if (connection != null) {
                System.out.println("Cannot create new connection, one exists already");
            } else {
                connection = DriverManager.getConnection(url, username, password);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return connection;
    }

}
