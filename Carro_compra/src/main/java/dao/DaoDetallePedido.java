package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexiones.Conexion;
import entidades.DetallePedido;

public class DaoDetallePedido {
	
	public DaoDetallePedido() {
		
	}
	
	public void addDetallePedido(DetallePedido dp) {
		
		Connection con = null;
		Conexion miconex = new Conexion();
		PreparedStatement ps = null;
		String query = "INSERT INTO DETALLEPEDIDO VALUES (?,?,?,?,?)";
		
		try {
			con = miconex.getConexion();
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setInt(1, dp.getIdPedido());
			ps.setInt(2, dp.getIdProducto());
			ps.setInt(3, dp.getCantidad());
			ps.setInt(4, dp.getPrecioUnitario());
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
