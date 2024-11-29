package entidades;

public class ProductoCarro extends Producto {
	
	private int cantidad;
	
	public ProductoCarro() {
		
	}

	public ProductoCarro(Producto p, int cantidad) {
		
		this.setIdProducto(p.getIdProducto());
		this.setNombre(p.getNombre());
		this.setPrecioNormal(p.getPrecioNormal());
		this.setPrecioMinimo(p.getPrecioMinimo());
		this.cantidad = cantidad;
		
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "ProductoCarro [cantidad=" + cantidad + "]";
	}
	
	
	
	
}
