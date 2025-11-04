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
        if(connection == null){
            System.out.println("CONNECTION BOSTUR KAPATILMADI !");
            return;
        }
        try{
            if(!connection.isClosed()){
                connection.close();
            }
        }
        catch (SQLException sqlException){
            System.err.printf("[EXCEPTION_HO_%s.closeConnection()] %s%n",
                    this.getClass().getSimpleName(),sqlException.getMessage()
                    );
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
