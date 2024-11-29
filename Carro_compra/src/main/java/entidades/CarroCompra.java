package entidades;

import java.util.ArrayList;

public class CarroCompra {
	
	private ArrayList<ProductoCarro> elementos;
	
	public CarroCompra() {
		elementos = new ArrayList<ProductoCarro>();
	}
	
	public void setElementos(ArrayList<ProductoCarro> elementos) {
		this.elementos = elementos;
	}
	
	public ArrayList<ProductoCarro> getElementos() {
		return elementos;
	}
	
	public void addProducto(ProductoCarro p) {
		elementos.add(p);
	}

	@Override
	public String toString() {
		return "CarroCompra [elementos=" + elementos + "]";
	}
	
	

}
