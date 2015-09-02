package com.douglasmariano.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douglasmariano.model.Vendedor;
import com.douglasmariano.model.Pedido;

@Repository
public class VendedorDAO {
	private final Connection connection;

	@Autowired
	public VendedorDAO(DataSource dataSource) {
	  try {
	    this.connection = dataSource.getConnection();
	  } catch (SQLException e) {
	    throw new RuntimeException(e);
	  }
	}
	
	public void adiciona(Vendedor vendedor){
		String sql = "insert into vendedor (nome) " +
					"values (?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, vendedor.getNome());
	
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	 public List<Vendedor> lista(){
		try{
			List<Vendedor> vendedor = new ArrayList<Vendedor>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select * from vendedor");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Vendedor vendedores = new Vendedor();
				vendedores.setId(rs.getLong("id"));
				vendedores.setNome(rs.getString("nome"));
				vendedor.add(vendedores);
			}
			rs.close();
			stmt.close();
			System.out.println("Lista gerada com Sucesso!");
			return vendedor;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Vendedor vendedor){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from vendedor where id = ?");
			
			stmt.setLong(1, vendedor.getId());
			stmt.execute();
			stmt.close();
			
			System.out.println("Vendedor Excluida com SUCESSO!");
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	

	
	public void altera(Vendedor vendedor){
		String sql = "update vendedor set nome=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, vendedor.getNome());
		
			stmt.setLong(4, vendedor.getId());
				
			stmt.execute();
			stmt.close();
			
			System.out.println("DADOS ALTERADOS COM SUCESSO!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Vendedor buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from vendedor");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println(rs.getLong("id")+ " // " + id);
				if(id == rs.getLong("id")) {
					//criando objeto tarefa
					Vendedor vendedor = new Vendedor();
					vendedor.setId(rs.getLong("id"));
					vendedor.setNome(rs.getString("nome"));
					
					System.out.println("retornado vendedor:"+vendedor.getId());
					return vendedor;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
		
		
	}
