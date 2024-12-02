package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexiones.Conexion;
import entidades.Pedido;

public class DaoPedido {
	
	public DaoPedido() {
		
	}
	
	public int addPedido(Pedido p) {
		
		Connection con = null;
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query2 ="SELECT S_PEDIDO.NEXTVAL NUMERO FROM DUAL"; //Esto te devuelve el número que vayas a insertar antes de generarlo
		
		int idPedido=0;
		
		try {
			
			
			con = miconex.getConexion();
			con.setAutoCommit(false);
			ps = con.prepareStatement(query2);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				idPedido = rs.getInt("NUMERO");
			}
			
			ps.close();
			
			String query = "INSERT INTO PEDIDO (IDPEDIDO, IDCLIENTE, DIRECCIONDEENVIO) VALUES (S_PEDIDO.NEXTVAL, ?, ?)";
			//Aquí he tenido que quitar tanto la fecha como el pagado, por defecto SQL meterá la sysdate así que bien
			//java.sql.Timestamp fechaActual = new java.sql.Timestamp(System.currentTimeMillis());
			ps = con.prepareStatement(query);
			ps.setInt(1, p.getIdCliente());
			//ps.setTimestamp(2, fechaActual);
			ps.setString(2, p.getDireccionEnvio());
			ps.executeUpdate();
			System.out.println(p.toString());
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return idPedido;
	}

}
