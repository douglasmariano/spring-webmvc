package com.douglasmariano.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.douglasmariano.model.Pedido;
import com.douglasmariano.pojo.PedidoWinthor;

public class ConectionWinthor {
	public Connection getConexao(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.200.254)(PORT = 1521)))" + "(CONNECT_DATA = (SERVICE_NAME = ajel)))","ajel", "us13aj27el");

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	public List<PedidoWinthor> lista(){
		try{
			List<PedidoWinthor> pedidosWinthor = new ArrayList<PedidoWinthor>();
			PreparedStatement stmt = this.getConexao().prepareStatement
			("select * from pcpedc where pcpedc.dtentrega = '03-dec-2015' ");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next())
			{
				//criando objeto pedido
				PedidoWinthor pedidoWinthor = new PedidoWinthor();
				pedidoWinthor.setId(rs.getLong("numped"));
				pedidoWinthor.setNumped(rs.getLong("codcli"));
				pedidoWinthor.setValor(rs.getString("vltoral"));
				pedidoWinthor.setObservacao(rs.getString("obs"));
				pedidoWinthor.setPosicao(rs.getString("posicao"));
				pedidoWinthor.setVendedor(rs.getString("codusur"));

			//adicionar objeto a lista
				pedidosWinthor.add(pedidoWinthor);
			}
			rs.close();
			stmt.close();
			System.out.println("Lista gerada com Sucesso!");
			return pedidosWinthor;
	
			}catch(SQLException e){
				throw new RuntimeException(e);
		}
	}
	
	
}
