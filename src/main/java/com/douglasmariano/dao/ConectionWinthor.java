package com.douglasmariano.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.douglasmariano.pojo.PedidoWinthor;



@Repository
public class ConectionWinthor {
	
	
	public Connection getConexao(){
        try{
        	Class.forName("oracle.jdbc.OracleDriver");
        	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.200.254:1521/WINT", "ajel", "us13aj27el");
        		   
        		   /**("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.200.254)(PORT = 1521)))" + "(CONNECT_DATA = (SERVICE_NAME = wint)))","ajel", "us13aj27el");
                   	**/
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	public List<PedidoWinthor> lista(){
		Calendar cal = Calendar.getInstance();

		java.sql.Date sqlDate = new java.sql.Date(cal.getTimeInMillis());
			
		try{
			List<PedidoWinthor> pedidosWinthor = new ArrayList<PedidoWinthor>();
			PreparedStatement stmt = this.getConexao().prepareStatement
			("SELECT   p.numped,p.data, p.vlatend, p.codcli,    c.cliente,p.codusur,u.nome, p.obs, p.totpeso,  p.totvolume,  p.numitens,   p.posicao,  p.hora, p.minuto,  p.numnota,  p.numviaspedido, p.dtiniciodigitacaopedido,  p.dtfimdigitacaopedido FROM   pcpedc p, pcusuari u,pcclient c WHERE p.codusur = u.codusur and  p.codcli = c.codcli and data = TO_DATE('"+sqlDate+"', 'yyyy/mm/dd') order by data,hora, minuto,posicao");
			ResultSet rs = stmt.executeQuery();
						while(rs.next())
			{
				//criando objeto pedido
				PedidoWinthor pedidoWinthor = new PedidoWinthor();
				pedidoWinthor.setNumped(rs.getInt("numped"));
				pedidoWinthor.setCodCliente(rs.getInt("codcli"));
				pedidoWinthor.setCliente(rs.getString("cliente"));
				pedidoWinthor.setValor(rs.getString("vlatend"));
				pedidoWinthor.setObservacao(rs.getString("obs"));
				pedidoWinthor.setData(rs.getDate("data"));
				pedidoWinthor.setHora(rs.getInt("hora"));
				pedidoWinthor.setMinuto(rs.getInt("minuto"));
				pedidoWinthor.setPosicao(rs.getString("posicao"));
				pedidoWinthor.setCodVendedor(rs.getInt("codusur"));
				pedidoWinthor.setVendedor(rs.getString("nome"));
				pedidoWinthor.setPeso(rs.getInt("totpeso"));
				pedidoWinthor.setVolume(rs.getInt("totvolume"));
				pedidoWinthor.setNumNota(rs.getInt("numnota"));
				pedidoWinthor.setNumVias(rs.getInt("numviaspedido"));
				pedidoWinthor.setInicioPedido(rs.getDate("dtiniciodigitacaopedido"));
				pedidoWinthor.setFimPedido(rs.getDate("dtfimdigitacaopedido"));
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
