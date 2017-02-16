package akademik.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Jayuk
 */
public class DBUtil 
{
    private static Connection connection=null;
    
    public static Connection getConnection() throws SQLException, IOException
    {
        if(connection !=null)
        {
            return connection;
        }
        else
        {
            try
            {
                Properties prop = new Properties();
                InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream("database.properties");
                prop.load(inputStream);
                connection = DriverManager.getConnection(prop.getProperty("Url"), prop.getProperty("User"), prop.getProperty("Password"));
                connection.setAutoCommit(false);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
