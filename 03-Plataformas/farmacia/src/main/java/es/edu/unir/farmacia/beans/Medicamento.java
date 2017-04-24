package es.edu.unir.farmacia.beans;

import java.io.Serializable;

public class Medicamento implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String medicamento;
	private TipoMedicamento tipoMedicamento;
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
	public String getMedicamento() {
		return medicamento;
	}
	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}
	/**
	 * @return the tipoMedicamento
	 */
	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}
	/**
	 * @param tipoMedicamento the tipoMedicamento to set
	 */
	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	public String toString() {
		return this.id + " " + this.medicamento + " [" + this.tipoMedicamento.getTipoMedicamento() + "]";
	}
	
}
