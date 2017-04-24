package es.edu.unir.farmacia.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private SucursalFarmacia sucursal;
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the sucursal
	 */
	public SucursalFarmacia getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(SucursalFarmacia sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the pedidos
	 */
	public List<Pedido> getPedidos() {
		return pedidos;
	}

}
