/**
 * 
 */
package es.edu.unir.farmacia.beans;

import java.io.Serializable;

/**
 * @author juliandrj
 *
 */
public class TipoMedicamento implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String tipoMedicamento;
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
	 * @return the tipoMedicamento
	 */
	public String getTipoMedicamento() {
		return tipoMedicamento;
	}
	/**
	 * @param tipoMedicamento the tipoMedicamento to set
	 */
	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	public String toString() {
		return this.getTipoMedicamento();
	}

}
