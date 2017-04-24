package es.edu.unir.farmacia.beans;

import java.io.Serializable;

public class DistribuidorFarmaceutico implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nombre;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String toString() {
		return this.getNombre();
	}

}
