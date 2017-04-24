package es.edu.unir.farmacia;

import org.apache.log4j.Logger;
import org.junit.Test;

import es.edu.unir.farmacia.beans.DistribuidorFarmaceutico;
import es.edu.unir.farmacia.beans.Medicamento;
import es.edu.unir.farmacia.beans.Pedido;
import es.edu.unir.farmacia.beans.SucursalFarmacia;
import es.edu.unir.farmacia.beans.TipoMedicamento;
import es.edu.unir.farmacia.excepcions.FarmaciaException;
import es.edu.unir.farmacia.model.FarmaciaMng;
import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	private Logger log = Logger.getLogger(getClass());
	private FarmaciaMng f = new FarmaciaMng();

	@Test
	public void cargarListados() {
		log.info("Cargando tipos de medicamento:");
		for (TipoMedicamento tp : f.getTiposMedicamento()) {
			log.info(" * " + tp.getTipoMedicamento());
		}
		log.info("Cargando distribuidores:");
		for (DistribuidorFarmaceutico df : f.getDistribuidores()) {
			log.info(" * " + df.getNombre());
		}
		log.info("Sucursales:");
		for (SucursalFarmacia sf : f.getSucursales()) {
			log.info(" * " + sf.getNombre());
		}
	}
	
	@Test
	public void hacerOrden() {
		Pedido p = new Pedido();
		p.setDistribuidor(this.f.getDistribuidores().get(0));
		Medicamento m = new Medicamento();
		m.setId(0);
		m.setMedicamento("Eutanex");
		m.setTipoMedicamento(this.f.getTiposMedicamento().get(0));
		p.setMedicamento(m);
		try {
			p.setCantidad(-4);
			f.agregarPedido(p);
			Assert.fail("No debe dejar pasar cantidades negativas.");
		} catch (FarmaciaException ex) {
			log.info("[OK] " + ex.getMessage());
		}
		try {
			p.setCantidad(4);
			f.agregarPedido(p);
			f.enviarOrden(f.getSucursales().get(0));
		} catch (FarmaciaException ex) {
			Assert.fail(ex.getMessage());
		}
	}
	
}
