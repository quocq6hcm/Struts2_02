package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler  {
    Connection cnnDB;
    String hostName = "localhost";
    String sqlInstanceName = "SQLEXPRESS";
    String database = "TestDB";
    String userName = "sa";
    String password = "1234";

    String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
            + ";instance=" + sqlInstanceName + ";databaseName=" + database;

    public Connection openCnnDB()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnnDB = DriverManager.getConnection(connectionURL, userName,
                    password);

        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            cnnDB = null;
        }
        return cnnDB;
    }

    public void closeCnnDB()
    {
        if (cnnDB != null)
        {
            try
            {
                cnnDB.close();
                cnnDB = null;
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }



}
