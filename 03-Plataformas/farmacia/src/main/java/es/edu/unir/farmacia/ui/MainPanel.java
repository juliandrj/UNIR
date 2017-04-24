package es.edu.unir.farmacia.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import org.apache.commons.lang.SerializationUtils;

import es.edu.unir.farmacia.beans.DistribuidorFarmaceutico;
import es.edu.unir.farmacia.beans.Medicamento;
import es.edu.unir.farmacia.beans.Pedido;
import es.edu.unir.farmacia.beans.SucursalFarmacia;
import es.edu.unir.farmacia.beans.TipoMedicamento;
import es.edu.unir.farmacia.excepcions.FarmaciaException;
import es.edu.unir.farmacia.model.FarmaciaMng;

import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class MainPanel extends JPanel {
	
	private FarmaciaMng f = new FarmaciaMng();
	
	private JTextField nombreMedicamento;
	private JTextField cantidad;

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		
		JLabel lblFarmaciaSas = new JLabel("Farmacia SAS");
		lblFarmaciaSas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFarmaciaSas.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		
		JLabel lblHagaSuPedido = new JLabel("Haga su pedido:");
		lblHagaSuPedido.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblMedicamento = new JLabel("Medicamento:");
		
		JLabel lblNombre = new JLabel("Nombre:");
		
		nombreMedicamento = new JTextField();
		nombreMedicamento.setColumns(10);
		
		final JComboBox<TipoMedicamento> tiposMedicamento = new JComboBox<TipoMedicamento>();
		for (TipoMedicamento tm : this.f.getTiposMedicamento()) {
			tiposMedicamento.addItem(tm);
		}
		
		JLabel lblTipoDeMedicamento = new JLabel("Tipo de medicamento:");
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		
		cantidad = new JTextField();
		cantidad.setHorizontalAlignment(SwingConstants.LEFT);
		cantidad.setColumns(10);
		
		JLabel lblDistribuidor = new JLabel("Distribuidor:");
		
		JLabel lblOrden = new JLabel("ORDEN");
		lblOrden.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		
		final JComboBox<DistribuidorFarmaceutico> distribuidores = new JComboBox<DistribuidorFarmaceutico>();
		for (DistribuidorFarmaceutico df : this.f.getDistribuidores()) {
			distribuidores.addItem(df);
		}
		
		final JTextArea resumen = new JTextArea();
		resumen.setFont(new Font("Consolas", Font.PLAIN, 8));
		resumen.setLineWrap(true);
		resumen.setEditable(false);
		
		JButton btnAgregarMedicamento = new JButton("Agregar medicamento");
		btnAgregarMedicamento.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (nombreMedicamento.getText() == null || nombreMedicamento.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "No ha digitado el nombre del medicamento.");
				} else if (cantidad.getText() == null || cantidad.getText().isEmpty() || !cantidad.getText().matches("^(-){0,1}[0-9]+$")) {
					JOptionPane.showMessageDialog(null, "No ha digitado la cantidad o no ha digitado un numero.");
				}
				Medicamento m = new Medicamento();
				m.setId(0);
				m.setMedicamento(nombreMedicamento.getText());
				m.setTipoMedicamento((TipoMedicamento)SerializationUtils.clone(tiposMedicamento.getItemAt(tiposMedicamento.getSelectedIndex())));
				Pedido p = new Pedido();
				p.setCantidad(Integer.valueOf(cantidad.getText()));
				p.setDistribuidor((DistribuidorFarmaceutico)SerializationUtils.clone(distribuidores.getItemAt(distribuidores.getSelectedIndex())));
				p.setMedicamento(m);
				try {
					f.agregarPedido(p);
					int n = 0;
					resumen.setText("");
					for (Pedido p1 : f.getPedidos()) {
						resumen.setText(resumen.getText() + "\n" + p1.getCantidad() + " unidades del " + p1.getMedicamento().getTipoMedicamento().getTipoMedicamento() + " " + m.getMedicamento());
						n += p1.getCantidad();
					}
					resumen.setText(resumen.getText() + "\n" + "------------------------------");
					resumen.setText(resumen.getText() + "\n" + "Total: " + n + " medicamento(s) solicitado(s)");
					JOptionPane.showMessageDialog(null, "Pedido al distribuidor: " + p.getDistribuidor().getNombre());
				} catch (FarmaciaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		final JComboBox<SucursalFarmacia> sucursales = new JComboBox<SucursalFarmacia>();
		for (SucursalFarmacia sf : f.getSucursales()) {
			sucursales.addItem(sf);
		}
		
		JButton btnRalizarOrden = new JButton("Ralizar Orden");
		btnRalizarOrden.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (f.getPedidos().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Primero agregue al menos un medicamento.");
					return;
				}
				try {
					f.enviarOrden((SucursalFarmacia)SerializationUtils.clone(sucursales.getItemAt(sucursales.getSelectedIndex())));
					resumen.setText("");
					JOptionPane.showMessageDialog(null, "Para la farmacia situada en " + sucursales.getItemAt(sucursales.getSelectedIndex()).getDireccion());
				} catch (FarmaciaException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		JLabel lblSeleccioneLaSucursal = new JLabel("Seleccione la sucursal de envío:");
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nombreMedicamento.setText("");
				tiposMedicamento.setSelectedIndex(0);
				cantidad.setText("");
				distribuidores.setSelectedIndex(0);
				resumen.setText("");
				sucursales.setSelectedIndex(0);
				f.getPedidos().clear();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(585, Short.MAX_VALUE)
					.addComponent(btnAgregarMedicamento)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblOrden, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFarmaciaSas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE)
								.addComponent(lblHagaSuPedido, GroupLayout.DEFAULT_SIZE, 761, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblMedicamento, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(655))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNombre, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
										.addComponent(lblTipoDeMedicamento)
										.addComponent(lblCantidad))
									.addPreferredGap(ComponentPlacement.RELATED))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblDistribuidor)
									.addGap(66)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(distribuidores, 0, 615, Short.MAX_VALUE)
								.addComponent(nombreMedicamento, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
								.addComponent(tiposMedicamento, Alignment.TRAILING, 0, 615, Short.MAX_VALUE)
								.addComponent(cantidad, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
							.addContainerGap())))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(7)
					.addComponent(resumen, GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSeleccioneLaSucursal)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(sucursales, 0, 318, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReiniciar)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRalizarOrden)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFarmaciaSas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblHagaSuPedido)
					.addGap(18)
					.addComponent(lblMedicamento)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(nombreMedicamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNombre))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(tiposMedicamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTipoDeMedicamento))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(cantidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidad))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDistribuidor)
						.addComponent(distribuidores, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAgregarMedicamento)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOrden)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(resumen, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRalizarOrden)
						.addComponent(sucursales, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSeleccioneLaSucursal)
						.addComponent(btnReiniciar))
					.addContainerGap())
		);
		setLayout(groupLayout);

	}
}
