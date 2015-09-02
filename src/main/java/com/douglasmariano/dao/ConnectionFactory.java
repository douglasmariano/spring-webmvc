package com.douglasmariano.dao;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
  
public class ConnectionFactory {  
	 /**   public Connection getConnection() throws SQLException {  
        try {  
            Class.forName("org.postgresql.Driver");  
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/os","postgres","admin");  
  
        } catch (ClassNotFoundException e) {  
            throw new SQLException(e.getMessage());  
        }  
    }  
	    
	   <bean id="postgresDataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="org.postgresql.Driver" />
		<property name="url" value="jdbc:postgresql://localhost:5432/os" />
		<property name="username" value="porstgres" />
		<property name="password" value="admin" />
	</bean>
**/
  
}  