package es.edu.unir.farmacia.beans;

import java.io.Serializable;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Medicamento medicamento;
	private Integer cantidad;
	private DistribuidorFarmaceutico distribuidor;
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
	 * @return the medicamento
	 */
	public Medicamento getMedicamento() {
		return medicamento;
	}
	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the distribuidor
	 */
	public DistribuidorFarmaceutico getDistribuidor() {
		return distribuidor;
	}
	/**
	 * @param distribuidor the distribuidor to set
	 */
	public void setDistribuidor(DistribuidorFarmaceutico distribuidor) {
		this.distribuidor = distribuidor;
	}

}
