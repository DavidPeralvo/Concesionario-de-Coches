package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.portable.IndirectionException;

import concesionarioCoches.Coche;
import concesionarioCoches.Color;
import concesionarioCoches.Concesionario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class BuscarCocheColor extends ventanaPadre {

	private final JPanel contentPanel = new JPanel();

	private Coche coche;
	private Concesionario concesionario;
	private int indiceCoche=-1;
	private JButton posterior;
	private JButton anterior;
	public BuscarCocheColor( final ArrayList<Coche> concesionario) {
		modeloComboBox.setEnabled(false);
		setTitle("Buscar Coche por color\n");
		this.concesionario=crearConcesionario(concesionario);
		marcaComboBox.setEnabled(false);
		matricula.setEditable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
				}
			});
			btnCancelar.setBounds(311, 243, 117, 29);
			contentPanel.add(btnCancelar);
		}
		
		anterior = new JButton("<<");
		anterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVehiculo(concesionario.get(--indiceCoche));
				bottomTest();
			}
		});
		anterior.setBounds(77, 243, 117, 29);
		contentPanel.add(anterior);
		
		 posterior = new JButton(">>");
		posterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVehiculo(concesionario.get(++indiceCoche));
				bottomTest();
			}
		});
		posterior.setBounds(194, 243, 117, 29);
		contentPanel.add(posterior);
	}
	private void mostrarVehiculo(Coche coche){
		matricula.setText(coche.getMatricula());
		switch (coche.getColor()) {
		case PLATA:
			plata.setSelected(true);
			break;
		case ROJO:
			rojo.setSelected(true);
			break;
		case AZUL:
			azul.setSelected(true);
		}
		marcaComboBox.addItem(coche.getModelo().getMarca());
		marcaComboBox.setSelectedItem(coche.getModelo().getMarca());
		modeloComboBox.addItem(coche.getModelo());
		modeloComboBox.setSelectedItem(coche.getModelo());
		

	}
	private void bottomTest() {
		if (indiceCoche+1==concesionario.size())
			posterior.setEnabled(false);
		else
			posterior.setEnabled(true);

		if (concesionario.get(indiceCoche - 1) == null)
			anterior.setEnabled(false);
		else
			anterior.setEnabled(true);
	}
	private Concesionario crearConcesionario(ArrayList<Coche> concesionario) {
		Concesionario concesionarioPorColor = new Concesionario();
		for (Coche coche : concesionario) {
			concesionarioPorColor.annadir(coche.getMatricula(),
					coche.getColor(), coche.getModelo());
		}
		return concesionarioPorColor;
	}
}
