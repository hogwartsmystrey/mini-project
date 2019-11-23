/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video.rental.software.config;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vimal
 */
public class SqlConnection {

    static final Logger logger = Logger.getLogger(SqlConnection.class.getName());
    private static Connection connection;

    public SqlConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public static Connection getConnection() throws SQLException {
        logger.log(Level.INFO, "Inside acquring connection");
        if (null == connection) {
            connection = (Connection) DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/video_rental",
                            "root", "admin@12345");

        }
        logger.log(Level.INFO, "Returning connection{0}", connection);
        return connection;
    }

    public static void closeConnection(Connection connection) throws SQLException {
        logger.log(Level.INFO, "Closing connection{0}", connection);
        if (null != connection) {
            connection.close();
        }
    }

}
