package cashmanager.cashmanager.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import cashmanager.cashmanager.util.PropertiesLoader;

/**
 * This factory class is used to get a connection to the CAMPER db. It is
 * designed as a Singleton.
 */
public class ConnectionFactory {

  private static ConnectionFactory connectionFactory = null;

  private String dbURL;
  private String dbUser;
  private String dbPwd;

  /**
   * Macht eine Instanz von ConnectionFactory und initialisiert diese
   */
  private ConnectionFactory() {

    try {
      final Properties prop = PropertiesLoader.loadProperties();
      setDbURL(prop.getProperty("connectionUrl",
          "jdbc:mysql://localhost:3306/CASHMANAGER"));
      setDbUser(prop.getProperty("dbUser", "root").trim());
      setDbPwd(prop.getProperty("dbPwd", "1234").trim());
    } catch (IOException e) {
      // TODO Replace by logger
      System.err.println("Error in " + this.getClass().getName() + ": "
          + e.getMessage());
      System.err
          .println("Default values are used:\ndbURL=jdbc:mysql://localhost:3306/CASHMANAGER\ndbUser=root\ndbPwd=1234");
      setDbURL("jdbc:mysql://localhost:3306/CASHMANAGER");
      setDbUser("root");
      setDbPwd("1234");
    }
  }

  public static ConnectionFactory getInstance() {

    if (connectionFactory == null) {
      connectionFactory = new ConnectionFactory();
    }
    return connectionFactory;
  }

	public Connection getConnection() throws SQLException {
    // Neue einmalige Verbindung wird aufgebaut
  	try {
  	Connection con = DriverManager.getConnection(getDbURL(), getDbUser(), getDbPwd());
  	return con;
  	} catch (SQLException s) {
  		System.err.print(s);
  		return null;
  	} 
  }

  private String getDbURL() {
    return dbURL;
  }

  private void setDbURL(String dbURL) {
    this.dbURL = dbURL;
  }

  private String getDbUser() {
    return dbUser;
  }

  private void setDbUser(String dbUser) {
    this.dbUser = dbUser;
  }

  private String getDbPwd() {
    return dbPwd;
  }

  private void setDbPwd(String dbPwd) {
    this.dbPwd = dbPwd;
  }
}