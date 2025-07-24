
package Bd;
 
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionBD {
    private static final String URL="jdbc:mysql://localhost:3306/biblioteca";
    private static final String USUARIO="root";
    private static final String PASSWORD="Muchas.25letras";
    
    private static HikariDataSource dataSource;
    
    static{
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USUARIO);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(3000);
        config.setMaxLifetime(20000);
        config.setConnectionTimeout(10000);
        
        
        dataSource = new HikariDataSource(config);
    }
    
    public static Connection geConnection()throws SQLException{
        return dataSource.getConnection();
    }
    
    public static void closePool(){
        if(dataSource !=null){
            dataSource.close();
        }
    }

}
