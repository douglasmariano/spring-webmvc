package com.douglasmariano.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douglasmariano.model.Pedido;

@Repository
public class PedidoDAO {
	
	private final Connection connection;
	
	public Calendar dataMedia;
	public Integer Dia = 14;
	
	@Autowired
	private SeparadorDAO separadorDAO;
	
	@Autowired
	private VendedorDAO vendedorDAO;

	private String sql;

	@Autowired
	public PedidoDAO(DataSource dataSource) {
	  try {
	    this.connection = dataSource.getConnection();
	  } catch (SQLException e) {
	    throw new RuntimeException(e);
	  }
	}
	
	public void adiciona(Pedido pedido){
		String sql = "insert into pedido (descricao, finalizado, separador_id, vendedor_id,numped,datainicio) " +
					"values (?,?,?, ?,?,?)";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, pedido.getDescricao());
			stmt.setBoolean(2, pedido.isFinalizado());
			stmt.setLong(3, pedido.getSeparador().getId());
			stmt.setLong(4, pedido.getVendedor().getId());
			stmt.setLong(5, pedido.getNumped());
			
			if(pedido.getDataInicio() == null)	{
				stmt.setTimestamp(6, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			} else {
				stmt.setNull(6, Types.TIMESTAMP);
			}

			stmt.execute();
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}
	}
	
	public List<Pedido> lista(){
		try{
			List<Pedido> pedidos = new ArrayList<Pedido>();
			PreparedStatement stmt = this.connection.prepareStatement
			("select p.*, extract('epoch' from case when datafinalizacao is null then '0' else (p.datafinalizacao -p.datainicio) end ) as mediaTempo from pedido p where  TO_CHAR(p.datainicio, 'DD') in ('"+Dia+"') and	TO_CHAR(p.datainicio, 'MM') in ('09') and TO_CHAR(p.datainicio, 'YY') in ('15') order by datainicio");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto pedido
				Pedido pedido = new Pedido();
				pedido.setId(rs.getLong("id"));
				pedido.setNumped(rs.getLong("numped"));
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setFinalizado(rs.getBoolean("finalizado"));
					

				rs.getObject("mediaTempo");
				if(!rs.wasNull()) {
					
					pedido.setMediaTempo((long)rs.getDouble("mediaTempo"));
				}
				
				rs.getLong("separador_id");
				if (!rs.wasNull()) {
					pedido.setSeparador(separadorDAO.buscaPorId(rs.getLong("separador_id")));
				}
				
				rs.getLong("vendedor_id");
				if (!rs.wasNull()) {
					pedido.setVendedor(vendedorDAO.buscaPorId(rs.getLong("vendedor_id")));;
				}
				
				
				if(rs.getDate("dataFinalizacao") != null) {
					//montando data atraves do calendar
					Calendar dataFinalizacao = Calendar.getInstance();
					dataFinalizacao.setTime(rs.getTimestamp("dataFinalizacao"));
					
					pedido.setDataFinalizacao(dataFinalizacao);
				}
				if(rs.getDate("dataInicio") != null) {
					//montando data atraves do calendar
					Calendar dataInicio = Calendar.getInstance();
					dataInicio.setTime(rs.getTimestamp("dataInicio"));
					
					pedido.setDataInicio(dataInicio);
				}
				
	
			//adicionar objeto a lista
				pedidos.add(pedido);
			}
			rs.close();
			stmt.close();
			System.out.println("Lista gerada com Sucesso!");
			return pedidos;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	public void remove(Pedido pedido){
		try{
			PreparedStatement stmt = this.connection.prepareStatement
			("delete from pedido where id = ?");
			
			stmt.setLong(1, pedido.getId());
			stmt.execute();
			stmt.close();
			
			System.out.println("Pedido Excluida com SUCESSO!");
			
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public Pedido buscaPorId(Long id){
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement("select p.*, extract('epoch' from case when datafinalizacao is null then '0' else (p.datafinalizacao -p.datainicio) end ) as mediaTempo from pedido p order by datainicio");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//System.out.println(rs.getLong("id")+ " // " + id);
				if(id == rs.getLong("id"))
				{
					//criando objeto pedido
					Pedido pedido = new Pedido();
					pedido.setId(rs.getLong("id"));
					pedido.setNumped(rs.getLong("numped"));
					pedido.setDescricao(rs.getString("descricao"));
					pedido.setFinalizado(rs.getBoolean("finalizado"));
				
					rs.getObject("mediaTempo");
					if(!rs.wasNull()) {
						
						pedido.setMediaTempo((long)rs.getDouble("mediaTempo"));
					}
					
					rs.getLong("separador_id");
					if (!rs.wasNull()) {
						pedido.setSeparador(separadorDAO.buscaPorId(rs.getLong("separador_id")));
					}
					
					rs.getLong("vendedor_id");
					if (!rs.wasNull()) {
						pedido.setVendedor(vendedorDAO.buscaPorId(rs.getLong("vendedor_id")));
					}
					
					if(rs.getDate("dataFinalizacao") != null) {
						//montando data atraves do calendar
						Calendar dataFinalizacao = Calendar.getInstance();
						dataFinalizacao.setTime(rs.getTimestamp("dataFinalizacao"));
					
						pedido.setDataFinalizacao(dataFinalizacao);
					}
					if(rs.getDate("dataInicio") != null) {
						//montando data atraves do calendar
						Calendar dataInicio = Calendar.getInstance();
						dataInicio.setTime(rs.getTimestamp("dataInicio"));
						
						pedido.setDataInicio(dataInicio);
					}
					System.out.println("retornada pedido:"+pedido.getId());
					return pedido;
				}
			}
				return null;
			}catch(SQLException e){
				throw new RuntimeException(e);
			}	
	}
	
	public void altera(Pedido pedido){
		String sql = "update pedido set descricao=?, finalizado=?, dataFinalizacao=?, separador_id=?, vendedor_id=?, numped=?  where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setString(1, pedido.getDescricao());
			stmt.setBoolean(2, pedido.isFinalizado());
			if(pedido.getDataFinalizacao() != null)	{
				stmt.setTimestamp(3, new Timestamp(pedido.getDataFinalizacao().getTimeInMillis()));
			} else {
				stmt.setNull(3, Types.TIMESTAMP);
			}
			stmt.setLong(4, pedido.getSeparador().getId());
			stmt.setLong(5, pedido.getVendedor().getId());
			
			stmt.setLong(6, pedido.getNumped());
			stmt.setLong(7, pedido.getId());
				
			stmt.execute();
			stmt.close();
			
			System.out.println("DADOS ALTERADOS COM SUCESSO!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	public void finaliza(Long id){
		
		Pedido pedido = buscaPorId(id);
		
		String sql = "update pedido set finalizado=?, dataFinalizacao=? where id=?";
		
		try{
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			
			stmt.setBoolean(1, true);
			
			stmt.setTimestamp(2, new Timestamp(Calendar.getInstance().getTimeInMillis()));
			
			stmt.setLong(3, pedido.getId());
				
			stmt.execute();
			stmt.close();
			
			System.out.println("DADOS ALTERADOS COM SUCESSO!");
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
		
	}
	


	
}
