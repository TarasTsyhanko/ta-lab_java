package banksystem.config.mysql;

import banksystem.config.DataProp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {
    private static Logger log = LogManager.getLogger(MySQL.class);

    private static DataProp props = new DataProp();
    private static Connection connection;

    private MySQL() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (MySQL.class) {
                try {
                    Class.forName(props.jdbcDriver());
                    connection = DriverManager.getConnection(props.sqlURL(), props.dbUser(), props.dbPass());
                } catch (ClassNotFoundException e) {
                    log.error("Class \'" + props.jdbcDriver() + "\' not found!");
                    e.printStackTrace();
                } catch (SQLException e) {
                    log.error("SQLException: " + e.getMessage());
                    log.error("SQLState: " + e.getSQLState());
                    log.error("VendorError: " + e.getErrorCode());
                }
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                log.error("Database access error occurs! Cannot close Connection!!!");
            }
        }
    }
}
