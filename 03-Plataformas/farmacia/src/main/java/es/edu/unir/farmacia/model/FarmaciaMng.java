package es.edu.unir.farmacia.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import es.edu.unir.farmacia.beans.DistribuidorFarmaceutico;
import es.edu.unir.farmacia.beans.Orden;
import es.edu.unir.farmacia.beans.Pedido;
import es.edu.unir.farmacia.beans.SucursalFarmacia;
import es.edu.unir.farmacia.beans.TipoMedicamento;
import es.edu.unir.farmacia.excepcions.FarmaciaException;
import es.edu.unir.farmacia.helpers.PropertiesHelper;

public class FarmaciaMng {
	
	private Logger log = Logger.getLogger(getClass());
	private Orden orden = new Orden();
	private Integer consecutivo = 0;
	
	/**
	 * Carga el listado de tipos de medicamentos.
	 * @return
	 */
	public List<TipoMedicamento> getTiposMedicamento() {
		Gson gson = new Gson();
		List<TipoMedicamento> tms = new ArrayList<TipoMedicamento>();
		TipoMedicamento[] tps = gson.fromJson(PropertiesHelper.getPropertie("lista.tipos.medicamento"), TipoMedicamento[].class);
		for (TipoMedicamento tm : tps) {
			tms.add(tm);
		}
		log.debug("tipos de medicamento cargados.");
		return tms;
	}
	
	/**
	 * Carga el listado de distribuidores.
	 * @return
	 */
	public List<DistribuidorFarmaceutico> getDistribuidores() {
		Gson gson = new Gson();
		List<DistribuidorFarmaceutico> dfs = new ArrayList<DistribuidorFarmaceutico>();
		DistribuidorFarmaceutico[] ds = gson.fromJson(PropertiesHelper.getPropertie("lista.distribuidores"), DistribuidorFarmaceutico[].class);
		for (DistribuidorFarmaceutico df : ds) {
			dfs.add(df);
		}
		log.debug("distribuidores cargados.");
		return dfs;
	}
	
	public List<SucursalFarmacia> getSucursales() {
		Gson gson = new Gson();
		List<SucursalFarmacia> ss = new ArrayList<SucursalFarmacia>();
		SucursalFarmacia[] scs = gson.fromJson(PropertiesHelper.getPropertie("lista.sucursales"), SucursalFarmacia[].class);
		for (SucursalFarmacia s : scs) {
			ss.add(s);
		}
		log.debug("sucursales cargadas.");
		return ss;
	}
	
	public List<Pedido> getPedidos() {
		return this.orden.getPedidos();
	}
	
	public void agregarPedido(Pedido p) throws FarmaciaException {
		if (p.getCantidad() < 1) {
			throw new FarmaciaException("cantidad no valida: " + p.getCantidad());
		}
		p.setId(this.consecutivo);
		this.consecutivo ++;
		this.orden.getPedidos().add(p);
		log.info("pedido agregado: " + p.getMedicamento().getMedicamento() + " (" + p.getCantidad() + ")");
	}
	
	public void eliminarPedido(Integer id) {
		List<Pedido> np = new ArrayList<Pedido>();
		for (Pedido p : this.orden.getPedidos()) {
			if (p.getId() != id) {
				np.add(p);
			}
		}
		this.orden.getPedidos().clear();
		this.orden.getPedidos().addAll(np);
	}
	
	public void enviarOrden(SucursalFarmacia sucursal) throws FarmaciaException {
		log.info("ORDEN -> " + sucursal.getNombre());
		this.orden.setSucursal(sucursal);
		int n = 0;
		log.info("id\t\t#\t\tDistribuidor\t\t\tMedicamento");
		DecimalFormat df = new DecimalFormat("000");
		for (Pedido p : this.orden.getPedidos()) {
			log.info(df.format(p.getId()) + "\t\t" + df.format(p.getCantidad()) + "\t\t" + p.getDistribuidor().getNombre() + "\t\t\t" + p.getMedicamento().toString());
			n += p.getCantidad();
		}
		log.info("------------------------------");
		log.info("Total: " + n + " medicamento(s) solicitado(s)");
		this.orden = new Orden();
		this.consecutivo = 0;
	}
	
}
