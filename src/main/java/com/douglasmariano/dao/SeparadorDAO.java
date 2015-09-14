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

import com.douglasmariano.model.Separador;
import com.douglasmariano.model.Pedido;

@Repository
public class SeparadorDAO {
	private final Connection connection;

	@Autowired
	public SeparadorDAO(DataSource dataSource) {
	  try {
	    this.connection = dataSource.getConnection();
	  } catch (SQLException e) {
	    throw new RuntimeException(e);
	  }
	}
	
	public void adiciona(Separador separador){
		String sql = "insert into separador (nome) " +
					"values (?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, separador.getNome());
	
			
			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	 public List<Separador> lista(){
		try{
			List<Separador> separador = new ArrayList<Separador>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select s.id, s.nome,  sum(extract('epoch' from (p.datafinalizacao - p.datainicio)) ) mediaSeparacao from pedido p inner join separador s on s.id = p.separador_id group by s.id, s.nome");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto tarefa
				Separador separadores = new Separador();
				separadores.setId(rs.getLong("id"));
				separadores.setNome(rs.getString("nome"));
				rs.getObject("mediaSeparacao");
				if(!rs.wasNull()) {
					
					separadores.setMediaSeparacao((long)rs.getDouble("mediaSeparacao"));
				}
				
				separador.add(separadores);
			}
			rs.close();
			stmt.close();
			System.out.println("Lista gerada com Sucesso!");
			return separador;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Separador separador){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from separador where id = ?");
			
			stmt.setLong(1, separador.getId());
			stmt.execute();
			stmt.close();
			
			System.out.println("Separador Excluida com SUCESSO!");
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	

	
	public void altera(Separador separador){
		String sql = "update separador set nome=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, separador.getNome());
		
			stmt.setLong(4, separador.getId());
				
			stmt.execute();
			stmt.close();
			
			System.out.println("DADOS ALTERADOS COM SUCESSO!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	public Separador buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select * from separador");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println(rs.getLong("id")+ " // " + id);
				if(id == rs.getLong("id")) {
					//criando objeto tarefa
					Separador separador = new Separador();
					separador.setId(rs.getLong("id"));
					separador.setNome(rs.getString("nome"));
					
					System.out.println("retornado separador:"+separador.getId());
					return separador;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
		
		
	}
