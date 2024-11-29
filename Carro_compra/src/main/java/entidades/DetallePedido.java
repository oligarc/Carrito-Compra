package entidades;

public class DetallePedido {
	
	private int idPedido;
	private int lineaDetalle;
	private int idProducto;
	private int cantidad;
	private int precioUnitario;
	private int totalLineaDetalle;
	
	public DetallePedido() {
		
	}

	public DetallePedido(int idPedido, int lineaDetalle, int idProducto, int cantidad, int precioUnitario,
			int totalLineaDetalle) {
		this.idPedido = idPedido;
		this.lineaDetalle = lineaDetalle;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.totalLineaDetalle = totalLineaDetalle;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getLineaDetalle() {
		return lineaDetalle;
	}

	public void setLineaDetalle(int lineaDetalle) {
		this.lineaDetalle = lineaDetalle;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(int precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public int getTotalLineaDetalle() {
		return totalLineaDetalle;
	}

	public void setTotalLineaDetalle(int totalLineaDetalle) {
		this.totalLineaDetalle = totalLineaDetalle;
	}

	@Override
	public String toString() {
		return "DetallePedido [idPedido=" + idPedido + ", lineaDetalle=" + lineaDetalle + ", idProducto=" + idProducto
				+ ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", totalLineaDetalle="
				+ totalLineaDetalle + "]";
	}
	
	

}
