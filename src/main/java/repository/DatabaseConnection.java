package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public DatabaseConnection(String loginName,String password,String dbName){
        try{
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+dbName,
                    loginName,password
            );

        }catch (Exception sqlException){
            System.out.println(sqlException.getMessage());
        }
    }

    public void closeConnection(){
        try{
            connection.close();
        }
        catch (Exception closeEx){
            System.out.println(closeEx.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
