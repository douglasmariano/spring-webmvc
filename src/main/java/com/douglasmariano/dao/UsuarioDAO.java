package com.douglasmariano.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douglasmariano.model.Usuario;


@Repository
public class UsuarioDAO  {
	
	private final Connection connection;

	@Autowired
	public UsuarioDAO(DataSource dataSource) {
	  try {
	    this.connection = dataSource.getConnection();
	  } catch (SQLException e) {
	    throw new RuntimeException(e);
	  }
	}
	
	
	public boolean existeUsuario(Usuario usuario){
		
		String sql = "select * from usuario where usuario= ?  and senha= ?";
		
		try{
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		
		stmt.setString(1, usuario.getUsuario());
		stmt.setString(2, usuario.getSenha());
		
		ResultSet rs = stmt.executeQuery();
		
		
		
		//verifica se existe retorno na consulta
		if(rs.next())
		{
			stmt.close();
			return true;
		}
		else
		{
			stmt.close();
			return false;
		}
		
	}catch(SQLException e){
		throw new RuntimeException(e);
	}
}
}