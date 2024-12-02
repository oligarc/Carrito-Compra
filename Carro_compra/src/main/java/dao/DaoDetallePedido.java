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
		String query = "INSERT INTO DETALLEPEDIDO(IDPEDIDO,LINEADETALLE,IDPRODUCTO,CANTIDAD,PRECIO_UNITARIO,TOTAL_LINEADETALLE) VALUES (?,?,?,?,?,?)";
		
		try {
			con = miconex.getConexion();
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);
			ps.setInt(1, dp.getIdPedido());
			ps.setInt(2, dp.getLineaDetalle());
			ps.setInt(3, dp.getIdProducto());
			ps.setInt(4, dp.getCantidad());
			ps.setInt(5, dp.getPrecioUnitario());
			ps.setInt(6, dp.getTotalLineaDetalle());
			
			ps.executeUpdate();
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
